package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ConfigTypeDao;
import io.renren.modules.app.entity.ConfigTypeEntity;
import io.renren.modules.app.service.ConfigTypeService;


@Service("configTypeService")
public class ConfigTypeServiceImpl extends ServiceImpl<ConfigTypeDao, ConfigTypeEntity> implements ConfigTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConfigTypeEntity> page = this.selectPage(
                new Query<ConfigTypeEntity>(params).getPage(),
                new EntityWrapper<ConfigTypeEntity>()
        );

        return new PageUtils(page);
    }

}
