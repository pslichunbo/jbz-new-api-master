package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ProjectTypeDao;
import io.renren.modules.app.entity.ProjectTypeEntity;
import io.renren.modules.app.service.ProjectTypeService;

import javax.validation.constraints.Null;


@Service("projectTypeService")
public class ProjectTypeServiceImpl extends ServiceImpl<ProjectTypeDao, ProjectTypeEntity> implements ProjectTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectTypeEntity> page = this.selectPage(
                new Query<ProjectTypeEntity>(params).getPage(),
                new EntityWrapper<ProjectTypeEntity>()
        );

        return new PageUtils(page);
    }

    public List<ProjectTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new ProjectTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }

}
