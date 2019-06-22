package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PresentTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 礼品类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface PresentTypeService extends IService<PresentTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<PresentTypeEntity> find();
}

