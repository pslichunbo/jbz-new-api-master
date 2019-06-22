package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ResumeTypeDao;
import io.renren.modules.app.entity.ResumeTypeEntity;
import io.renren.modules.app.service.ResumeTypeService;


@Service("resumeTypeService")
public class ResumeTypeServiceImpl extends ServiceImpl<ResumeTypeDao, ResumeTypeEntity> implements ResumeTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ResumeTypeEntity> page = this.selectPage(
                new Query<ResumeTypeEntity>(params).getPage(),
                new EntityWrapper<ResumeTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<ResumeTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new ResumeTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
