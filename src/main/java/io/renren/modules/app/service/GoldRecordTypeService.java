package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.GoldRecordTypeEntity;

import java.util.Map;

/**
 * 金币类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface GoldRecordTypeService extends IService<GoldRecordTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

