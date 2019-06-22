package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.GoldRecordTypeDao;
import io.renren.modules.app.entity.GoldRecordTypeEntity;
import io.renren.modules.app.service.GoldRecordTypeService;


@Service("goldRecordTypeService")
public class GoldRecordTypeServiceImpl extends ServiceImpl<GoldRecordTypeDao, GoldRecordTypeEntity> implements GoldRecordTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoldRecordTypeEntity> page = this.selectPage(
                new Query<GoldRecordTypeEntity>(params).getPage(),
                new EntityWrapper<GoldRecordTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<GoldRecordTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new GoldRecordTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
