package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CustomerDao;
import io.renren.modules.app.entity.CustomerEntity;
import io.renren.modules.app.service.CustomerService;


@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CustomerEntity> page = this.selectPage(
                new Query<CustomerEntity>(params).getPage(),
                new EntityWrapper<CustomerEntity>().like("name",params.get("name").toString())
        );

        return new PageUtils(page);
    }

    @Override
    public List<CustomerEntity> query() {
        return baseMapper.query();
    }


}
