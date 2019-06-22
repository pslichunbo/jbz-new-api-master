package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MerchantTypeDao;
import io.renren.modules.app.entity.MerchantTypeEntity;
import io.renren.modules.app.service.MerchantTypeService;


@Service("merchantTypeService")
public class MerchantTypeServiceImpl extends ServiceImpl<MerchantTypeDao, MerchantTypeEntity> implements MerchantTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MerchantTypeEntity> page = this.selectPage(
                new Query<MerchantTypeEntity>(params).getPage(),
                new EntityWrapper<MerchantTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<MerchantTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new MerchantTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
