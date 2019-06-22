package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PostDao;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.PostService;


@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostDao, PostEntity> implements PostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PostEntity> page = this.selectPage(
                new Query<PostEntity>(params).getPage(),
                new EntityWrapper<PostEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PostEntity> query() {
        return baseMapper.query();
    }

    public List<PostEntity> queryAll(){
        EntityWrapper<PostEntity> wrapper = new EntityWrapper<>(new PostEntity());
        return this.selectList(wrapper);
    }




}
