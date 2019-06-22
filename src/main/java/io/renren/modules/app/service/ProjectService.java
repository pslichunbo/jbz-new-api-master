package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

