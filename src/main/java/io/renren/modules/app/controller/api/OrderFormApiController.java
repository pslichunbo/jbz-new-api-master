package io.renren.modules.app.controller.api;

import java.util.*;

import io.renren.common.utils.GetOrderId;
import io.renren.modules.app.dao.OrderstatusDao;
import io.renren.modules.app.entity.*;
import io.renren.modules.app.service.*;
import io.renren.modules.app.service.impl.OrderFormServiceImpl;
import io.renren.modules.app.service.impl.QualificationsAuthenticateServiceImpl;
import io.renren.modules.app.service.impl.RealnameAuthenticationServiceImpl;
import io.renren.modules.app.vo.ApiOrderVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.annotation.Resource;


/**
 * 订单表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
@RestController
@RequestMapping("app/orderform")
public class OrderFormApiController {
    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SourceGoodsService  sourceGoodsService;

    @Autowired
    private MessageService messageService;

    @Resource
    private OrderstatusDao orderstatusDao;

    @Autowired
    private OrderFormServiceImpl orderFormServiceImpl;

    @Autowired
    private QualificationsAuthenticateService qualificationsAuthenticateService;
    @Autowired
    private QualificationsAuthenticateServiceImpl qualificationsAuthenticateServiceImpl;

    @Autowired
    private RealnameAuthenticationService realnameAuthenticationService;
    @Autowired
    private RealnameAuthenticationServiceImpl realnameAuthenticationServiceImpl;

    /**
     * 我的订单(根据state查询)
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderFormService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 申请接单{jin}
     */
    @PostMapping("/applyFor")
    public R applyFor(@RequestParam Map<String, Object> params){
        Long sourceGoodsId = Long.parseLong((String)params.get("sourceGoodsId"));
        int i = orderFormService.proposerNum(sourceGoodsId);
        if(i >= 3){
            return R.error("已经超过接单人数");
        }
        Long goodsUserId = Long.parseLong((String)params.get("goodsUserId"));
        //判断用户是否已经实名认证
        QualificationsAuthenticateEntity qualificationsAuthenticateEntity = qualificationsAuthenticateServiceImpl.getByUserId(goodsUserId);
        RealnameAuthenticationEntity realnameAuthenticationEntity = realnameAuthenticationServiceImpl.getByUserId(goodsUserId);
        if (qualificationsAuthenticateEntity == null){
            return R.error("你还未资格认证");
        }else if (realnameAuthenticationEntity == null){
            return R.error("你还未实名认证");
        } else {
            if (qualificationsAuthenticateEntity.getState() == 0){
                return R.error("你的驾驶资格正在审核中，请耐心等待");
            }else if (qualificationsAuthenticateEntity.getState() == 2){
                return R.error("你的资格认证未通过");
            }else if (realnameAuthenticationEntity.getStatus().equals("0")){
                return R.error("你的实名认证正在审核中，请耐心等待");
            }else if (realnameAuthenticationEntity.getStatus().equals("2")){
                return R.error("你的实名认证未通过");
            } else {
                String evaluate = (String) params.get("evaluate");
                String remark = (String) params.get("remark");
                SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(sourceGoodsId);
                OrderFormEntity order = new OrderFormEntity();
                order.setOrderId(GetOrderId.getOrderIdByTime());
                order.setTel(sourceGoodsEntity.getTel());
                order.setSourceGoodsId(sourceGoodsId);
                order.setCreateTime(new Date());
                order.setUserId(sourceGoodsEntity.getUserId());
                order.setOrderTime(new Date());
                order.setGoodsUserId(goodsUserId);
                order.setEvaluate(evaluate);
                order.setRemark(remark);
//                if (i >= 2){
//                    order.setState(2L);
//                    sourceGoodsEntity.setState(2L);
//                    sourceGoodsService.updateById(sourceGoodsEntity);
//                    orderFormService.updateById(order);
//
//                }else {

//                }
                order.setState(1L);
                sourceGoodsEntity.setState(1L);
                orderFormService.insert(order);
                sourceGoodsService.updateById(sourceGoodsEntity);
                orderFormService.updateById(order);

            }
        }
        return R.ok();
    }



    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			OrderFormEntity orderForm = orderFormService.selectById(id);

        return R.ok().put("orderForm", orderForm);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody OrderFormEntity orderForm){
			orderFormService.insert(orderForm);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody OrderFormEntity orderForm){

			orderFormService.updateById(orderForm);

        return R.ok();
    }

    /**
     * 修改
     */
    @GetMapping("/updateOrder")
    public R updateOrder(@RequestParam Map<String, Object> params){
        OrderFormEntity orderForm = orderFormService.selectById((String) params.get("id"));
        orderForm.setState(Long.parseLong((String)params.get("state")));
        if (Long.parseLong(params.get("state").toString()) == 6){
            orderForm.setArriveTime(new Date());
        }
        orderFormService.updateById(orderForm);
        SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(orderForm.getSourceGoodsId());
        sourceGoodsEntity.setState(Long.parseLong((String)params.get("state")));
        sourceGoodsService.updateById(sourceGoodsEntity);
        return R.ok();
    }



    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			orderFormService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 我的订单全部数据不分页
     */
    @GetMapping("/allMyOrder/{userId}")
    public R getAllMyOrder(@PathVariable("userId") Long userId){
        List<OrderFormEntity> all = orderFormServiceImpl.getAll(userId);
        List<ApiOrderVo> voList = new ArrayList<>();
        all.stream().forEach(o->voList.add(orderFormServiceImpl.getOrderVo(o)));
        return R.ok().put("data",voList);
    }

    /**
     *根据订单id修改订单状态
     */
    @GetMapping("/updateByWithId")
    public R updateByWithId(@RequestParam Map<String, Object> params){
        orderFormService.updateWithId(params);
        OrderFormEntity orderFormEntity = orderFormService.selectById(params.get("id").toString());
        SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(orderFormEntity.getSourceGoodsId());
        if (Long.parseLong(params.get("state").toString()) == 6){
            orderFormEntity.setArriveTime(new Date());
        }
        sourceGoodsEntity.setState(Long.parseLong(params.get("state").toString()));
        sourceGoodsService.updateById(sourceGoodsEntity);
        orderFormService.updateById(orderFormEntity);
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setCreateTime(new Date());
        messageEntity.setTitle("【我的货源】");
        messageEntity.setUserId(orderFormEntity.getUserId());
        messageEntity.setContent("您的货源"+orderstatusDao.Bystatus(Long.parseLong((String)params.get("state"))).getName()+"，请及时查看！");
        messageEntity.setDelSign(0L);
        messageEntity.setReadSign(0L);
        messageEntity.setTypeId(2L);
        messageService.insert(messageEntity);
        MessageEntity messageEntity1 = new MessageEntity();
        messageEntity1.setCreateTime(new Date());
        messageEntity1.setTitle("【我的订单】");
        messageEntity1.setUserId(orderFormEntity.getGoodsUserId());
        messageEntity1.setContent("您的货源"+orderstatusDao.Bystatus(Long.parseLong((String)params.get("state"))).getName()+"，请及时查看！");
        messageEntity1.setDelSign(0L);
        messageEntity1.setReadSign(0L);
        messageEntity1.setTypeId(1L);
        messageService.insert(messageEntity1);
        return R.ok();
    }


}
