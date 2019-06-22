package io.renren.modules.app.service.impl;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MaintenancePersonTypeDao;
import io.renren.modules.app.entity.MaintenancePersonTypeEntity;
import io.renren.modules.app.service.MaintenancePersonTypeService;


@Service("maintenancePersonTypeService")
public class MaintenancePersonTypeServiceImpl extends ServiceImpl<MaintenancePersonTypeDao, MaintenancePersonTypeEntity> implements MaintenancePersonTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MaintenancePersonTypeEntity> page = this.selectPage(
                new Query<MaintenancePersonTypeEntity>(params).getPage(),
                new EntityWrapper<MaintenancePersonTypeEntity>()
        );

        return new PageUtils(page);
    }

    public List<MaintenancePersonTypeEntity> selectAll(){


        EntityWrapper ew = new EntityWrapper(new MaintenancePersonTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }

}
