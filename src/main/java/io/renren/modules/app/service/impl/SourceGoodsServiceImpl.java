package io.renren.modules.app.service.impl;

import io.renren.common.utils.GetOrderId;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.OrderFormEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.OrderFormService;
import io.renren.modules.app.vo.ApiSourceVo;
import io.renren.modules.app.vo.SourceGoodsEntityVo;
import io.renren.modules.app.vo.UserVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SourceGoodsDao;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.SourceGoodsService;


@Service("sourceGoodsService")
public class SourceGoodsServiceImpl extends ServiceImpl<SourceGoodsDao, SourceGoodsEntity> implements SourceGoodsService {
    @Autowired
    private AreaServiceImpl areaServiceImpl;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private OrderFormServiceImpl orderFormServiceImpl;
    @Autowired
    private AreaService areaService;
    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SourceGoodsService sourceGoodsService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if(params.get("state").equals("") || params.get("state") == null){
            Page<SourceGoodsEntity> page = this.selectPage(
                    new Query<SourceGoodsEntity>(params).getPage(),
                    new EntityWrapper<SourceGoodsEntity>().where("user_id = {0}",params.get("userId"))
            );
            return new PageUtils(page);
        }else {
            Page<SourceGoodsEntity> page = this.selectPage(
                    new Query<SourceGoodsEntity>(params).getPage(),
                    new EntityWrapper<SourceGoodsEntity>().where("state = {0} and user_id = {1}",params.get("state"),params.get("userId"))
            );
            return new PageUtils(page);
        }
    }

    @Override
    public PageUtils queryPage1(Map<String, Object> params) {
        Page<SourceGoodsEntity> page = this.selectPage(
                new Query<SourceGoodsEntity>(params).getPage(),
                new EntityWrapper<SourceGoodsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils selectPage(Map<String, Object> params) {
        EntityWrapper<SourceGoodsEntity> wrapper = new EntityWrapper<>(new SourceGoodsEntity());
        if (params.get("start") != null){
            wrapper.eq("start_county",params.get("start").toString());
        }
        if (params.get("end") != null){
            wrapper.eq("end_county",params.get("end").toString());
        }
        wrapper.in("state","0,1");
        wrapper.orderBy("create_time",false);
        Page<SourceGoodsEntity> page = this.selectPage(
                new Query<SourceGoodsEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

public List<SourceGoodsEntity> selectAll(Long userId){
        EntityWrapper<SourceGoodsEntity> wrapper = new EntityWrapper<>(new SourceGoodsEntity());
        wrapper.eq("user_id",userId);
        wrapper.orderBy("create_time",false);
        return this.selectList(wrapper);
}



public ApiSourceVo getVo(SourceGoodsEntity entity){
        ApiSourceVo vo = new ApiSourceVo();
        vo.setAlterTime(entity.getAlterTime());
        vo.setCargoDescription(entity.getCargoDescription());
        vo.setClerkOrderingNum(orderFormService.proposerNum(entity.getId()));
        vo.setCreateTime(entity.getCreateTime());
        vo.setEndAddress(entity.getEndAddress());
        vo.setShipperName(entity.getLinkName());
        vo.setDriverPhone(entity.getTel());

          if (entity.getEndCity() != null){
            vo.setEndCity(areaServiceImpl.selectById(entity.getEndCity()).getTreeNames());
        }else {
            vo.setEndCity(null);
        }
        String treeNames = areaServiceImpl.selectById(entity.getEndCounty()).getTreeNames();
        String[] split = treeNames.split("/");
        vo.setEndCounty(split[0]);
        vo.setEndLatitude(entity.getEndLatitude());
        vo.setEndLongitude(entity.getEndLongitude());
        vo.setEndPointAddr(entity.getEndPointAddr());
        if (entity.getEndProvince() == null){
            vo.setEndProvince(null);
        }else {
            vo.setEndProvince(entity.getEndProvince());
        }
        vo.setId(entity.getId());
        if (entity.getImages() != null){
            vo.setImages(entity.getImages().split(","));
        }else {
            vo.setImages(null);
        }
        vo.setLinkName(entity.getLinkName());
        vo.setStartAddress(entity.getStartAddress());
        if (entity.getStartCity() == null){
            vo.setStartCity(null);
        }else {
            vo.setStartCity(areaServiceImpl.selectById(entity.getStartCity()).getTreeNames());
        }
        String treeNames1 = areaServiceImpl.selectById(entity.getStartCounty()).getTreeNames();
        String[] split1 = treeNames1.split("/");
        vo.setStartCounty(split1[0]);
        vo.setStartLatitude(entity.getStartLatitude());
        vo.setStartLongitude(entity.getStartLongitude());
        vo.setStartPointAddr(entity.getStartPointAddr());
        if (entity.getStartProvince() == null){
            vo.setStartProvince(null);
        }else {
            vo.setStartProvince(areaServiceImpl.selectById(entity.getStartProvince()).getTreeNames());
        }
        vo.setState(entity.getState());
        vo.setTel(entity.getTel());
        vo.setUrgent(entity.getUrgent());
        vo.setUserId(entity.getUserId());
        vo.setWeight(entity.getWeight());
        vo.setGoodsNumber(entity.getGoodsNumber());
        if (entity.getEndProvince() == null){
            vo.setEndProvince(null);
        }else {
            vo.setEndProvince(areaServiceImpl.selectById(entity.getEndProvince()).getTreeNames());
        }
            List<UserVo> list = new ArrayList<>();
            List<OrderFormEntity> formEntityList = orderFormServiceImpl.selectByGoodsId(entity.getId());
            List<Long> userIdList = new ArrayList<>();
            for (OrderFormEntity o : formEntityList){
               userIdList.add(o.getGoodsUserId());
               vo.setOrderTime(o.getOrderTime());
               vo.setAlterTime(o.getAlterTime());
               vo.setOrderId(o.getId().toString());
            }
            for (Long id : userIdList){
                SysUserEntity sysUserEntity = sysUserService.selectById(id);
                UserVo userVo= new UserVo();
                userVo.setName(sysUserEntity.getUsername());
                userVo.setPhone(sysUserEntity.getMobile());
                userVo.setUserId(sysUserEntity.getUserId());
                list.add(userVo);
            }
            vo.setVoList(list);
        return vo;
}

/**
 * 根据用户id和货源id删除货源
 */
public boolean deleteByUserIdWithId(Map<String, Object> params){
    EntityWrapper<SourceGoodsEntity> wrapper = new EntityWrapper<>(new SourceGoodsEntity());
    wrapper.eq("id",params.get("id").toString());
    wrapper.eq("user_id",params.get("userId").toString());
    return this.delete(wrapper);
}


/**
 * 后台返回视图
 */
public SourceGoodsEntityVo getSourceGoodsEntityVo(SourceGoodsEntity s){
    SourceGoodsEntityVo vo =  new SourceGoodsEntityVo();
    vo.setId(s.getId());
    if (s.getStartProvince() == null){
        vo.setStartProvince(null);
    }else {
        vo.setStartProvince(areaService.selectById(s.getStartProvince()).getAreaName());
    }
    if (s.getStartCity() == null){
        vo.setStartCity(null);
    }else {
        vo.setStartCity(areaService.selectById(s.getStartCity()).getAreaName());
    }
    vo.setStartCounty(areaService.selectById(s.getStartCounty()).getTreeNames());
    if (s.getEndProvince() == null){
        vo.setEndProvince(null);
    }else {
        vo.setEndProvince(areaService.selectById(s.getEndProvince()).getAreaName());
    }
    if (s.getEndCity() == null){
        vo.setEndCity(null);
    }else {
        vo.setEndCity(areaService.selectById(s.getEndCity()).getAreaName());
    }
    vo.setEndCounty(areaService.selectById(s.getEndCounty()).getTreeNames());
    vo.setStartPointAddr(s.getStartPointAddr());
    vo.setEndPointAddr(s.getEndPointAddr());
    vo.setStartAddress(areaService.selectById(s.getStartCounty()).getTreeNames());
    vo.setEndAddress(areaService.selectById(s.getEndCounty()).getTreeNames());
    vo.setCargoDescription(s.getCargoDescription());
    vo.setTel(s.getTel());
    vo.setLinkName(s.getLinkName());
    vo.setState(s.getState());
    vo.setCreateTime(s.getCreateTime());
    vo.setAlterTime(s.getAlterTime());
    vo.setUserName(sysUserService.selectById(s.getUserId()).getRealName());
    vo.setUrgent(s.getUrgent());
    vo.setWeight(s.getWeight());
    vo.setClerkOrderingNum(s.getClerkOrderingNum());
    vo.setGoodsNumber(s.getGoodsNumber());
    return vo;
}


public R adminByOrder(Map<String, Object> params){
    if (params.get("goodsId") != null){
        SourceGoodsEntity goodsEntity = sourceGoodsService.selectById(Long.parseLong(params.get("goodsId").toString()));
        if (goodsEntity.getState() != 0 && goodsEntity.getState() != 1){
            return R.error("该订单不能指派");
        }else {
            OrderFormEntity orderFormEntity = new OrderFormEntity();
            orderFormEntity.setOrderTime(new Date());
            orderFormEntity.setState(3L);
            orderFormEntity.setCreateTime(goodsEntity.getCreateTime());
            if (params.get("goodsUserId") != null){
                orderFormEntity.setGoodsUserId(Long.parseLong(params.get("goodsUserId").toString()));
            }else {
                return R.error("拉货人不能为空");
            }
            orderFormEntity.setOrderId(GetOrderId.getOrderIdByTime());
            orderFormEntity.setTel(goodsEntity.getTel());
            orderFormEntity.setUserId(goodsEntity.getUserId());
            orderFormEntity.setSourceGoodsId(goodsEntity.getId());
            orderFormService.insert(orderFormEntity);
            //生成订单同时把货源状态与订单状态同步
            goodsEntity.setState(3L);
            sourceGoodsService.updateById(goodsEntity);
        }
    }
    return R.ok();
}

}
