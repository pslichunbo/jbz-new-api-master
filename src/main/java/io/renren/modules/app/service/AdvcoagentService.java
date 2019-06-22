package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AdvcoagentEntity;

import java.util.Map;

/**
 * 发布招聘-----找帮手
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:54
 */
public interface AdvcoagentService extends IService<AdvcoagentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils myqueryPage(Map<String, Object> params);
}

