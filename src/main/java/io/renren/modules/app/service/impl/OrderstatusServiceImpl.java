package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.OrderstatusDao;
import io.renren.modules.app.entity.OrderstatusEntity;
import io.renren.modules.app.service.OrderstatusService;


@Service("orderstatusService")
public class OrderstatusServiceImpl extends ServiceImpl<OrderstatusDao, OrderstatusEntity> implements OrderstatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderstatusEntity> page = this.selectPage(
                new Query<OrderstatusEntity>(params).getPage(),
                new EntityWrapper<OrderstatusEntity>()
        );

        return new PageUtils(page);
    }

}
