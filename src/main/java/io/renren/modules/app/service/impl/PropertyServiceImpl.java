package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.vo.PropertyEntityVo;
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

import io.renren.modules.app.dao.PropertyDao;
import io.renren.modules.app.entity.PropertyEntity;
import io.renren.modules.app.service.PropertyService;


@Service("propertyService")
public class PropertyServiceImpl extends ServiceImpl<PropertyDao, PropertyEntity> implements PropertyService {
    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PropertyEntity> page = this.selectPage(
                new Query<PropertyEntity>(params).getPage(),
                new EntityWrapper<>(new PropertyEntity())
        );

        return new PageUtils(page);
    }

    @Override
    public List<PropertyEntity> allquery() {
        return baseMapper.allquery();
    }

}
