package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ConversionRecordTypeEntity;

import java.util.Map;

/**
 * 兑换记录类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-21 09:21:45
 */
public interface ConversionRecordTypeService extends IService<ConversionRecordTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

