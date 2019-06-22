package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ConversionRecordEntity;

import java.util.Map;

/**
 * 兑换记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
public interface ConversionRecordService extends IService<ConversionRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageOne(Map<String, Object> params);
}

