package io.renren.modules.app.service.impl;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.SourceGoodsService;
import io.renren.modules.app.vo.AdminSourceGoodsVo;
import io.renren.modules.app.vo.ApiOrderVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.OrderFormDao;
import io.renren.modules.app.entity.OrderFormEntity;
import io.renren.modules.app.service.OrderFormService;

import javax.annotation.Resource;


@Service("orderFormService")
public class OrderFormServiceImpl extends ServiceImpl<OrderFormDao, OrderFormEntity> implements OrderFormService {

    @Resource
    private OrderFormDao orderFormDao;

    @Autowired
    private SourceGoodsService sourceGoodsService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OrderFormService orderFormService;


    @Override
    public void dispose(OrderFormEntity orderForm) {
        baseMapper.dispose(orderForm);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if(params.get("state").equals("") || params.get("state") == null){
        Page<OrderFormEntity> page = this.selectPage(
                new Query<OrderFormEntity>(params).getPage(),
                new EntityWrapper<OrderFormEntity>().where("goods_user_id = {0}",params.get("goodsUserId"))
        );

        return new PageUtils(page);
    }else {
            Page<OrderFormEntity> page = this.selectPage(
                    new Query<OrderFormEntity>(params).getPage(),
                    new EntityWrapper<OrderFormEntity>().where("state = {0} and goods_user_id = {1}",params.get("state"),params.get("goodsUserId"))
            );
            return new PageUtils(page);
        }
    }

    @Override
    public PageUtils query(Map<String, Object> params) {
        EntityWrapper<OrderFormEntity> wrapper = new EntityWrapper<>(new OrderFormEntity());
        if (!(params.get("orderId").toString()).equals("") && params.get("orderId") !=null){
            wrapper.like("order_id",params.get("orderId").toString());
        }
        wrapper.where("state in (0,1)");
        wrapper.eq("del_sign",0);
        wrapper.orderBy("create_time",false);
        Page<OrderFormEntity> page = this.selectPage(
                new Query<OrderFormEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils query1(Map<String, Object> params) {
        EntityWrapper<OrderFormEntity> wrapper = new EntityWrapper<>(new OrderFormEntity());
        if (!params.get("orderId").equals("") || params.get("orderId") !=null){
            wrapper.like("order_id",params.get("orderId").toString());
        }
        wrapper.where("del_sign = 0 and state not in (0,1,7)");
        wrapper.orderBy("source_goods_id",false);
        Page<OrderFormEntity> page = this.selectPage(
                new Query<OrderFormEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils query2(Map<String, Object> params) {
        EntityWrapper<OrderFormEntity> wrapper = new EntityWrapper<>(new OrderFormEntity());
        if (!params.get("orderId").equals("") || params.get("orderId") !=null){
            wrapper.like("order_id",params.get("orderId").toString());
        }
        wrapper.where("del_sign = 0 and state = 7");
        wrapper.orderBy("source_goods_id",false);
        Page<OrderFormEntity> page = this.selectPage(
                new Query<OrderFormEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public int proposerNum(Long sourceGoodsId) {
        return orderFormDao.proposerNum(sourceGoodsId);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long s : ids){
            orderFormDao.logicdelete(s);
        }
    }

    @Override
    public void deletesp(OrderFormEntity orderForm) {
        orderFormDao.deletesp(orderForm);
    }

    @Override
    public void updateWithId(Map<String, Object> params) {
        orderFormDao.updateWithId(params);
    }


    public List<OrderFormEntity> getAll(Long userId){
        EntityWrapper<OrderFormEntity> wrapper = new EntityWrapper<>(new OrderFormEntity());
        wrapper.eq("goods_user_id",userId);
        wrapper.orderBy("create_time",false);
        return this.selectList(wrapper);
    }

    public ApiOrderVo getOrderVo(OrderFormEntity entity){
        ApiOrderVo vo = new ApiOrderVo();
        SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(entity.getSourceGoodsId());
        if (sourceGoodsEntity != null){
            vo.setArriveTime(entity.getArriveTime());
            String[] split = areaService.selectById(sourceGoodsEntity.getEndCounty()).getTreeNames().split("/");
            if (split.length > 0){
                vo.setEndAddress(split[0]);
            }else {
                vo.setEndAddress(null);
            }
            vo.setEndMinuteAddress(sourceGoodsEntity.getEndPointAddr());
            vo.setEvaluate(entity.getEvaluate());
            vo.setOrderNumber(sourceGoodsEntity.getGoodsNumber());
            vo.setOrderTime(entity.getOrderTime());
            vo.setRemark(entity.getRemark());
            vo.setShipperName(sysUserService.selectById(entity.getUserId()).getUsername());
            String[] split1 = areaService.selectById(sourceGoodsEntity.getStartCounty()).getTreeNames().split("/");
            if (split1.length > 0){
                vo.setStartAddress(split1[0]);
            }else {
                vo.setStartAddress(null);
            }
            vo.setStartMinuteAddress(sourceGoodsEntity.getStartPointAddr());
            vo.setState(entity.getState());
            vo.setImages(sourceGoodsEntity.getImages().split(","));
            vo.setOrderId(entity.getId());
            vo.setCreateGoodsTime(sourceGoodsEntity.getCreateTime());
            vo.setEndLatitude(sourceGoodsEntity.getEndLatitude());
            vo.setEndLongitude(sourceGoodsEntity.getEndLongitude());
            vo.setStartLatitude(sourceGoodsEntity.getStartLatitude());
            vo.setStartLongitude(sourceGoodsEntity.getStartLongitude());
            vo.setUrgent(sourceGoodsEntity.getUrgent());
            vo.setClerkOrderingNum(orderFormService.proposerNum(sourceGoodsEntity.getId()));
            vo.setWeight(sourceGoodsEntity.getWeight());
            vo.setShipperPhone(sysUserService.selectById(sourceGoodsEntity.getUserId()).getMobile());
            return vo;
        }
        return null;
    }
    public List<OrderFormEntity> selectByGoodsId(Long sourceGoodsId){
        EntityWrapper<OrderFormEntity> wrapper = new EntityWrapper<>(new OrderFormEntity());
        wrapper.eq("source_goods_id",sourceGoodsId);
        return this.selectList(wrapper);
    }


    public AdminSourceGoodsVo getAdminSourceGoodsVo(OrderFormEntity entity){
        SourceGoodsEntity sourceGoodsEntity = sourceGoodsService.selectById(entity.getSourceGoodsId());
        AdminSourceGoodsVo vo = new AdminSourceGoodsVo();
        vo.setStartAddress(areaService.selectById(sourceGoodsEntity.getStartCounty()).getTreeNames());
        vo.setEndAddress(areaService.selectById(sourceGoodsEntity.getEndCounty()).getTreeNames());
        vo.setId(entity.getId());
        vo.setState(entity.getState());
        vo.setWeight(sourceGoodsEntity.getWeight());
        vo.setArriveTime(entity.getArriveTime());
        vo.setEndMinuteAddress(sourceGoodsEntity.getEndPointAddr());
        vo.setStartMinuteAddress(sourceGoodsEntity.getStartPointAddr());
        vo.setOrderNumber(entity.getOrderId());
        vo.setOrderTime(entity.getOrderTime());
        vo.setRemark(entity.getRemark());
        vo.setEvaluate(entity.getEvaluate());
        vo.setArriveTime(entity.getArriveTime());
        vo.setGoodsId(sourceGoodsEntity.getId());
        vo.setShipperName(sysUserService.selectById(sourceGoodsEntity.getUserId()).getRealName());
        vo.setShipperPhone(sysUserService.selectById(sourceGoodsEntity.getUserId()).getMobile());
        vo.setOrderUserName(sysUserService.selectById(entity.getGoodsUserId()).getRealName());
        vo.setOrderUserPhone(sysUserService.selectById(entity.getGoodsUserId()).getMobile());
        return vo;
    }


}
