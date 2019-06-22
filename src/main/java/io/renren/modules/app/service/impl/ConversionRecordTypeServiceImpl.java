package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ConversionRecordTypeDao;
import io.renren.modules.app.entity.ConversionRecordTypeEntity;
import io.renren.modules.app.service.ConversionRecordTypeService;


@Service("conversionRecordTypeService")
public class ConversionRecordTypeServiceImpl extends ServiceImpl<ConversionRecordTypeDao, ConversionRecordTypeEntity> implements ConversionRecordTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConversionRecordTypeEntity> page = this.selectPage(
                new Query<ConversionRecordTypeEntity>(params).getPage(),
                new EntityWrapper<ConversionRecordTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<ConversionRecordTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new ConversionRecordTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
