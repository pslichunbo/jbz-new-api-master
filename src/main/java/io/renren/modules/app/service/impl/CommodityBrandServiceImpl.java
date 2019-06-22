package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.CommodityBrandTypeEntity;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.CommodityBrandTypeService;
import io.renren.modules.app.service.MenuNextService;
import io.renren.modules.app.vo.CommodityBrandVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CommodityBrandDao;
import io.renren.modules.app.entity.CommodityBrandEntity;
import io.renren.modules.app.service.CommodityBrandService;


@Service("commodityBrandService")
public class CommodityBrandServiceImpl extends ServiceImpl<CommodityBrandDao, CommodityBrandEntity> implements CommodityBrandService {
    @Autowired
    private MenuNextService menuNextService;
    @Autowired
    private CommodityBrandTypeService commodityBrandTypeService;
    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommodityBrandEntity> page = this.selectPage(
                new Query<CommodityBrandEntity>(params).getPage(),
                new EntityWrapper<CommodityBrandEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CommodityBrandEntity> allquery() {
        return baseMapper.allquery();
    }


    public PageUtils queryByTypeId(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<CommodityBrandEntity> page = this.selectPage(
                new Query<CommodityBrandEntity>(params).getPage(),
                new EntityWrapper<>(new CommodityBrandEntity())
                .where("status = 1 and type_id = "+Integer.parseInt(params.get("typeId").toString()))
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public PageUtils queryAll(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<CommodityBrandEntity> page = this.selectPage(
                new Query<CommodityBrandEntity>(params).getPage(),
                new EntityWrapper<>(new CommodityBrandEntity())
                .where("status = 1").orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    //根据二级列表id查询品牌
    public List<CommodityBrandEntity> queryByMenuNextId(Long menuNextId){
        EntityWrapper ew = new EntityWrapper(new CommodityBrandEntity());
        ew.where("status = 1 and menu_next_id ="+menuNextId);
        return this.selectList(ew);
    }

    /**
     *根据用户id和品牌id删除品牌lyj
     */
    public boolean removeByTypeId(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long userId = Long.parseLong(params.get("userId").toString());
        EntityWrapper ew = new EntityWrapper(new CommodityBrandEntity());
        ew.where("`id` = {0} and user_id = {1} and status = 1",id,userId);
        return this.delete(ew);
    }
    public List<CommodityBrandEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new CommodityBrandEntity());
        return this.selectList(ew);
    }
    public List<CommodityBrandEntity> queryByBrand(){
        EntityWrapper ew = new EntityWrapper(new CommodityBrandEntity());
        ew.orderBy("alter_time",false);
        List<CommodityBrandEntity> list = this.selectList(ew);
        list.stream().limit(12).collect(Collectors.toList());
        return list;
    }
    public CommodityBrandVo getCommodityBrandVo(CommodityBrandEntity entity){
        CommodityBrandVo vo = new CommodityBrandVo();
        vo.setAlterTime(entity.getAlterTime());
        vo.setBrandInfo(entity.getBrandInfo());
        vo.setBrandLogo(entity.getBrandLogo());
        vo.setBrandName(entity.getBrandName());
        vo.setCreateTime(entity.getCreateTime());
        vo.setDeleteTime(entity.getDeleteTime());
        vo.setId(entity.getId());
        MenuNextEntity menuNextEntity = menuNextService.selectById(entity.getMenuNextId());
        if (menuNextEntity != null){
            vo.setMenuNextName(menuNextEntity.getMenuName());
        }
        vo.setStatus(entity.getStatus());
        CommodityBrandTypeEntity commodityBrandTypeEntity = commodityBrandTypeService.selectById(entity.getTypeId());
        if (commodityBrandTypeEntity != null){
            vo.setTypeName(commodityBrandTypeEntity.getName());
        }
        SysUserEntity sysUserEntity = sysUserService.selectById(entity.getUserId());
        if (sysUserEntity != null){
            vo.setUserName(sysUserEntity.getRealName());
        }
        return vo;
    }
}
