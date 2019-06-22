package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PropertyEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public interface PropertyService extends IService<PropertyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<PropertyEntity> allquery();
}

