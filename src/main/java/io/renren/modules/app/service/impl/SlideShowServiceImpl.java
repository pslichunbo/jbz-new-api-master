package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SlideShowDao;
import io.renren.modules.app.entity.SlideShowEntity;
import io.renren.modules.app.service.SlideShowService;


@Service("slideShowService")
public class SlideShowServiceImpl extends ServiceImpl<SlideShowDao, SlideShowEntity> implements SlideShowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SlideShowEntity> page = this.selectPage(
                new Query<SlideShowEntity>(params).getPage(),
                new EntityWrapper<SlideShowEntity>()
        );

        return new PageUtils(page);
    }

}
