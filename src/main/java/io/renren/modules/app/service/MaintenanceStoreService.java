package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MaintenanceStoreEntity;

import java.util.Map;

/**
 * 维修店
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface MaintenanceStoreService extends IService<MaintenanceStoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageOne(Map<String, Object> params);
}

