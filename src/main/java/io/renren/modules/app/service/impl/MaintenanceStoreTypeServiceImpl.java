package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MaintenanceStoreTypeDao;
import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;
import io.renren.modules.app.service.MaintenanceStoreTypeService;


@Service("maintenanceStoreTypeService")
public class MaintenanceStoreTypeServiceImpl extends ServiceImpl<MaintenanceStoreTypeDao, MaintenanceStoreTypeEntity> implements MaintenanceStoreTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MaintenanceStoreTypeEntity> page = this.selectPage(
                new Query<MaintenanceStoreTypeEntity>(params).getPage(),
                new EntityWrapper<MaintenanceStoreTypeEntity>()
        );

        return new PageUtils(page);
    }

    public List<MaintenanceStoreTypeEntity> selectAll(){


        EntityWrapper ew = new EntityWrapper(new MaintenanceStoreTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }

}
