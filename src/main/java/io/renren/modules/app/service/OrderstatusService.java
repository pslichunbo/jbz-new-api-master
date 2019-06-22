package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.OrderstatusEntity;

import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 17:50:35
 */
public interface OrderstatusService extends IService<OrderstatusEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

