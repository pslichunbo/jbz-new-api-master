package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PresentTypeDao;
import io.renren.modules.app.entity.PresentTypeEntity;
import io.renren.modules.app.service.PresentTypeService;

import javax.annotation.Resource;


@Service("presentTypeService")
public class PresentTypeServiceImpl extends ServiceImpl<PresentTypeDao, PresentTypeEntity> implements PresentTypeService {


    @Resource
    private PresentTypeDao presentTypeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PresentTypeEntity> page = this.selectPage(
                new Query<PresentTypeEntity>(params).getPage(),
                new EntityWrapper<PresentTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PresentTypeEntity> find() {
        return  presentTypeDao.find();
    }
}
