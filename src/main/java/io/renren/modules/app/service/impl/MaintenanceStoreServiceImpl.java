package io.renren.modules.app.service.impl;

import io.renren.modules.app.controller.admin.MaintenanceStoreController;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;
import io.renren.modules.app.vo.MaintenanceStoreEntityVo;
import io.renren.modules.app.vo.MaintenanceStoreVo;
import io.renren.modules.app.vo.StoreVo;
import io.renren.modules.app.vo.StoreVos;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MaintenanceStoreDao;
import io.renren.modules.app.entity.MaintenanceStoreEntity;
import io.renren.modules.app.service.MaintenanceStoreService;


@Service("maintenanceStoreService")
public class MaintenanceStoreServiceImpl extends ServiceImpl<MaintenanceStoreDao, MaintenanceStoreEntity> implements MaintenanceStoreService {

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private MaintenanceStoreTypeServiceImpl maintenanceStoreTypeServiceImpl;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<MaintenanceStoreEntity> wrapper = new EntityWrapper<>(new MaintenanceStoreEntity());
        if (params.get("areaId") != null){
            wrapper.eq("area_id",params.get("areaId"));
        }
        if (params.get("typeId") != null){
            wrapper.eq("type_id",params.get("typeId"));
        }
        wrapper.orderBy("create_time",false);
        Page<MaintenanceStoreEntity> page = this.selectPage(
                new Query<MaintenanceStoreEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        Page<MaintenanceStoreEntity> page = this.selectPage(
                new Query<MaintenanceStoreEntity>(params).getPage(),
                new EntityWrapper<MaintenanceStoreEntity>()
        );

        return new PageUtils(page);
    }


    public PageUtils selectAll(Map<String, Object> params) {
        Page<MaintenanceStoreEntity> page = this.selectPage(
                new Query<MaintenanceStoreEntity>(params).getPage(),
                new EntityWrapper<>(new MaintenanceStoreEntity())
        );
        return new PageUtils(page);
    }
    //根据id查询详情
    public MaintenanceStoreVo queryById(Long id){
        EntityWrapper ew = new EntityWrapper(new MaintenanceStoreEntity());
        MaintenanceStoreEntity storeEntity = this.selectById(id);
        MaintenanceStoreVo vo = new MaintenanceStoreVo();
        vo.setUserId(storeEntity.getUserId());
        vo.setStoreName(storeEntity.getStoreName());
        vo.setStoreInfo(storeEntity.getStoreInfo());
        vo.setStoreImage(storeEntity.getStoreImage());
        String beautifulImage = storeEntity.getStoreBeautifulImage();
        String s = beautifulImage.replaceAll("[\\[\\]]", "");
        String[] split = s.split(",");
        List<String> list = Arrays.asList(split);
        vo.setStoreBeautifulImage(list);

        AreaEntity areaEntity = areaServiceImpl.selectById(storeEntity.getAreaId());
        vo.setStoreAddress(areaEntity.getTreeNames());
        vo.setId(storeEntity.getId());
        vo.setShopManagerPhone(storeEntity.getShopManagerPhone());
        vo.setShopManagerName(storeEntity.getShopManagerName());
        String businessScope = storeEntity.getBusinessScope();
        String s1 = businessScope.replaceAll("[\\[\\]]", "");
        String[] split1 = s1.split(",");
        List<String> asList = Arrays.asList(split1);
        vo.setBusinessScope(asList);
        vo.setAddress(storeEntity.getAddress());
        return vo;
    }

    public List<StoreVos> queryByIndex(){
        EntityWrapper ew = new EntityWrapper(new MaintenanceStoreEntity());
        ew.orderBy("create_time",false);
        List<MaintenanceStoreEntity> list = this.selectList(ew);
        List<MaintenanceStoreEntity> collect = list.stream().limit(3).collect(Collectors.toList());
        List<StoreVos> vosList = new ArrayList<>();
        for (MaintenanceStoreEntity m : collect){
            StoreVos vos = new StoreVos();
            AreaEntity areaEntity = areaServiceImpl.selectById(m.getAreaId());
            vos.setAreaName(areaEntity.getTreeNames());
            vos.setName(m.getStoreName());
            String[] split = m.getStoreImage()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            vos.setStoreImage(split[0]);
            MaintenanceStoreTypeEntity maintenanceStoreTypeEntity = maintenanceStoreTypeServiceImpl.selectById(m.getTypeId());
            vos.setTypeName(maintenanceStoreTypeEntity.getName());
            vosList.add(vos);
        }
        return vosList;
    }

    /**
     * 封装视图对象
     */
    public StoreVo getVo(MaintenanceStoreEntity entity){
        StoreVo vo = new StoreVo();
        if (entity.getStoreBeautifulImage() != null || !entity.getStoreBeautifulImage().equals("")){
            vo.setStoreBeautifulImage(
                    entity.getStoreBeautifulImage()
                            .replaceAll("[\\[\\]\\\"]","")
                            .split(","));
        }else {
            vo.setStoreBeautifulImage(null);
        }
        vo.setAddress(entity.getAddress());
        vo.setAreaName(areaServiceImpl.selectById(entity.getAreaId()).getTreeNames());
        vo.setBusinessScope(entity.getBusinessScope());
        vo.setId(entity.getId());
        vo.setShopManagerName(entity.getShopManagerName());
        vo.setShopManagerPhone(entity.getShopManagerPhone());
        vo.setStoreImage(entity.getStoreImage());
        vo.setStoreInfo(entity.getStoreInfo());
        vo.setStoreName(entity.getStoreName());
        vo.setTypeName(maintenanceStoreTypeServiceImpl.selectById(entity.getTypeId()).getName());
        vo.setUserName(sysUserService.selectById(entity.getUserId()).getUsername());
        vo.setAlterTime(entity.getAlterTime());
        vo.setCreateTime(entity.getCreateTime());
        vo.setDeleteTime(entity.getDeleteTime());
        vo.setAreaId(Long.parseLong(entity.getAreaId()));
        vo.setTypeId(entity.getTypeId());
        vo.setUserId(entity.getUserId());
        return vo;
    }

    public MaintenanceStoreEntity getByUserId(Long userId){
        EntityWrapper<MaintenanceStoreEntity> wrapper = new EntityWrapper<>(new MaintenanceStoreEntity());
        wrapper.eq("user_id",userId);
        return this.selectOne(wrapper);
    }
}
