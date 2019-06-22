package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.LabelEntity;

import java.util.Map;

/**
 * 标签表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface LabelService extends IService<LabelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

