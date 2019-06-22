package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.GoldRecordEntity;

import java.util.Map;

/**
 * 金币记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface GoldRecordService extends IService<GoldRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

