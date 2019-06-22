package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;

import java.util.Map;

/**
 * 维修店类型
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-30 11:37:39
 */
public interface MaintenanceStoreTypeService extends IService<MaintenanceStoreTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

