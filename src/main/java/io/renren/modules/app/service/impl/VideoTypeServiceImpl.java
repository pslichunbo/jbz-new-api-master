package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.VideoTypeDao;
import io.renren.modules.app.entity.VideoTypeEntity;
import io.renren.modules.app.service.VideoTypeService;

import javax.annotation.Resource;


@Service("videoTypeService")
public class VideoTypeServiceImpl extends ServiceImpl<VideoTypeDao, VideoTypeEntity> implements VideoTypeService {


    @Resource
    private VideoTypeDao videoTypeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VideoTypeEntity> page = this.selectPage(
                new Query<VideoTypeEntity>(params).getPage(),
                new EntityWrapper<VideoTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<VideoTypeEntity> queryALL() {
        return videoTypeDao.findAll();
    }


}
