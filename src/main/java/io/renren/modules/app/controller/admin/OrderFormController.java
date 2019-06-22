package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.dao.OrderstatusDao;
import io.renren.modules.app.entity.MessageEntity;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.service.impl.OrderFormServiceImpl;
import io.renren.modules.app.service.impl.QualificationsAuthenticateServiceImpl;
import io.renren.modules.app.service.impl.SourceGoodsServiceImpl;
import io.renren.modules.app.vo.AdminSourceGoodsVo;
import io.renren.modules.app.vo.ApiOrderVo;
import io.renren.modules.app.vo.OrderFormEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.OrderFormEntity;
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
@RequestMapping("app/AdminOrderForm")
public class OrderFormController {
    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SourceGoodsService sourceGoodsService;

    @Autowired
    private MessageService messageService;

    @Resource
    private OrderstatusDao orderstatusDao;
    @Autowired
    private OrderFormServiceImpl orderFormServiceImpl;

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    private SourceGoodsServiceImpl sourceGoodsServiceImpl;

    @Autowired
    private QualificationsAuthenticateServiceImpl qualificationsAuthenticateServiceImpl;

    @Autowired
    private AreaService areaService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:orderform:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderFormService.query(params);
        List<OrderFormEntity> content = (List<OrderFormEntity>) page.getContent();
        List<OrderFormEntityVo> vos = new ArrayList<>();
        for(OrderFormEntity s : content){
            OrderFormEntityVo vo = new  OrderFormEntityVo();
            vo.setId(s.getId());
            vo.setOrderId(s.getOrderId());
            vo.setTel(sourceGoodsService.selectById(s.getSourceGoodsId()).getTel());
            vo.setState(s.getState());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sourceGoodsService.selectById(s.getSourceGoodsId()).getLinkName());
            vo.setOrderTime(s.getOrderTime());
            vo.setArriveTime(s.getArriveTime());
            vo.setGoodsUserName(sysUserService.selectById(s.getGoodsUserId()));
            vo.setEvaluate(s.getEvaluate());
            vo.setRemark(s.getRemark());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 处理列表
     */
    @RequestMapping("/list1")
    public R list1(@RequestParam Map<String, Object> params){
        PageUtils page = orderFormService.query1(params);
        List<OrderFormEntity> content = (List<OrderFormEntity>) page.getContent();
        List<OrderFormEntityVo> vos = new ArrayList<>();
        for(OrderFormEntity s : content){
            OrderFormEntityVo vo = new  OrderFormEntityVo();
            vo.setId(s.getId());
            vo.setOrderId(s.getOrderId());
            vo.setTel(sourceGoodsService.selectById(s.getSourceGoodsId()).getTel());
            vo.setState(s.getState());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sourceGoodsService.selectById(s.getSourceGoodsId()).getLinkName());
            vo.setOrderTime(s.getOrderTime());
            vo.setArriveTime(s.getArriveTime());
            vo.setGoodsUserName(sysUserService.selectById(s.getGoodsUserId()));
            vo.setEvaluate(s.getEvaluate());
            vo.setRemark(s.getRemark());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params){
        PageUtils page = orderFormService.query2(params);
        List<OrderFormEntity> content = (List<OrderFormEntity>) page.getContent();
        List<OrderFormEntityVo> vos = new ArrayList<>();
        for(OrderFormEntity s : content){
            OrderFormEntityVo vo = new  OrderFormEntityVo();
            vo.setId(s.getId());
            vo.setOrderId(s.getOrderId());
            vo.setTel(sourceGoodsService.selectById(s.getSourceGoodsId()).getTel());
            vo.setState(s.getState());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sourceGoodsService.selectById(s.getSourceGoodsId()).getLinkName());
            vo.setOrderTime(s.getOrderTime());
            vo.setArriveTime(s.getArriveTime());
            vo.setGoodsUserName(sysUserService.selectById(s.getGoodsUserId()));
            vo.setEvaluate(s.getEvaluate());
            vo.setRemark(s.getRemark());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:orderform:info")
    public R info(@PathVariable("id") Long id){
		OrderFormEntity s = orderFormService.selectById(id);
        AdminSourceGoodsVo vo = orderFormServiceImpl.getAdminSourceGoodsVo(s);
        return R.ok().put("data", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:orderform:save")
    public R save(@RequestBody OrderFormEntity orderForm){
			orderFormService.insert(orderForm);

        return R.ok();
    }

    /**
     * 订单处理
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:orderform:update")
    public R update(@RequestBody OrderFormEntity orderForm){
        SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(orderForm.getSourceGoodsId());
        sourceGoodsEntity.setState(orderForm.getState());
        sourceGoodsService.updateById(sourceGoodsEntity);
        OrderFormEntity orderFormEntity = orderFormService.selectById(orderForm.getId());
        orderFormService.dispose(orderForm);
        orderFormService.deletesp(orderForm);
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setCreateTime(new Date());
        messageEntity.setTitle("【我的货源】");
        messageEntity.setUserId(orderFormEntity.getUserId());
        messageEntity.setContent("您的货源"+orderstatusDao.Bystatus(orderForm.getState()).getName()+"，请及时查看！");
        messageEntity.setDelSign(0L);
        messageEntity.setReadSign(0L);
        messageEntity.setTypeId(2L);
        messageService.insert(messageEntity);
        MessageEntity messageEntity1 = new MessageEntity();
        messageEntity1.setCreateTime(new Date());
        messageEntity1.setTitle("【我的订单】");
        messageEntity1.setUserId(orderFormEntity.getGoodsUserId());
        messageEntity1.setContent("您的订单"+orderstatusDao.Bystatus(orderForm.getState()).getName()+"，请及时查看！");
        messageEntity1.setDelSign(0L);
        messageEntity1.setReadSign(0L);
        messageEntity1.setTypeId(1L);
        messageService.insert(messageEntity1);
        return R.ok();
    }

    /**
     * 逻辑删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:orderform:delete")
    public R delete(@RequestBody Long[] ids){
			orderFormService.delete(ids);
        return R.ok();
    }


    /**
     * 筛选资格认证的用户
     */
    @RequestMapping("qualificationsAu")
    public R qualificationsAuInfo(){
        List<SysUserEntity> list = sysUserServiceImpl.selectByUser();
        return R.ok().put("data", list);
    }

    /**
     * 筛选管理员列表
     */
    @RequestMapping("real")
    public R realAuInfo(){
//        List<SysUserEntity> sysUserEntities = sysUserService.realName();
//        List<SysUserEntity> user = new ArrayList<>();
//        for(SysUserEntity s : sysUserEntities){
//            if("".equals(s.getRealnameId()) || s.getRealnameId() == null){
//                continue;
//            }
//            if("1".equals(realnameAuthenticationService.selectById(s.getRealnameId()).getStatus())){
//                user.add(s);
//            }
//        }
        List<SysUserEntity> sysUserEntities = sysUserServiceImpl.selectByAdmin();
        return R.ok().put("data", sysUserEntities);
    }

    /**
     * 货源列表管理员直接根据货源id和拉货人id直接生成订单
     */
    @RequestMapping("/adminBysourceGoods")
    public R adminBySourceGoods(@RequestParam Map<String, Object> params){
        SourceGoodsEntity goodsId = sourceGoodsService.selectById(params.get("goodsId").toString());
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setCreateTime(new Date());
        messageEntity.setTitle("【我的货源】");
        messageEntity.setUserId(goodsId.getUserId());
        messageEntity.setContent("您的货源"+"取货中"+"，请及时查看！");
        messageEntity.setDelSign(0L);
        messageEntity.setReadSign(0L);
        messageEntity.setTypeId(2L);
        messageService.insert(messageEntity);
        MessageEntity messageEntity1 = new MessageEntity();
        messageEntity1.setCreateTime(new Date());
        messageEntity1.setTitle("【我的订单】");
        messageEntity1.setUserId(Long.parseLong(params.get("goodsUserId").toString()));
        messageEntity1.setContent("您的货源"+"取货中"+"，请及时查看！");
        messageEntity1.setDelSign(0L);
        messageEntity1.setReadSign(0L);
        messageEntity1.setTypeId(1L);
        messageService.insert(messageEntity1);
        return sourceGoodsServiceImpl.adminByOrder(params);
    }
    /**
     * 获取有资格拉货的用户
     */
    @RequestMapping("/listDriver")
    public R listDriver(){

        return qualificationsAuthenticateServiceImpl.listByDriver();
    }


}
