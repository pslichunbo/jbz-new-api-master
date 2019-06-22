package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MaintenancePersonTypeEntity;

import java.util.Map;

/**
 * 维修人类型
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-30 11:37:39
 */
public interface MaintenancePersonTypeService extends IService<MaintenancePersonTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

