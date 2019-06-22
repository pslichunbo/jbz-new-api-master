package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ProjectTypeEntity;

import java.util.Map;

/**
 * 项目类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
public interface ProjectTypeService extends IService<ProjectTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

