package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ConfigEntity;

import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-22 16:24:53
 */
public interface ConfigService extends IService<ConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

