package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.GoldRecordDao;
import io.renren.modules.app.entity.GoldRecordEntity;
import io.renren.modules.app.service.GoldRecordService;


@Service("goldRecordService")
public class GoldRecordServiceImpl extends ServiceImpl<GoldRecordDao, GoldRecordEntity> implements GoldRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoldRecordEntity> page = this.selectPage(
                new Query<GoldRecordEntity>(params).getPage(),
                new EntityWrapper<GoldRecordEntity>()
        );

        return new PageUtils(page);
    }

}
