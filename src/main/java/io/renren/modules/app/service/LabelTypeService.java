package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.LabelTypeEntity;

import java.util.Map;

/**
 * 标签类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface LabelTypeService extends IService<LabelTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

