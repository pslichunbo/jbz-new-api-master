package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ResumeDao;
import io.renren.modules.app.entity.ResumeEntity;
import io.renren.modules.app.service.ResumeService;


@Service("resumeService")
public class ResumeServiceImpl extends ServiceImpl<ResumeDao, ResumeEntity> implements ResumeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ResumeEntity> page = this.selectPage(
                new Query<ResumeEntity>(params).getPage(),
                new EntityWrapper<ResumeEntity>()
        );

        return new PageUtils(page);
    }

}
