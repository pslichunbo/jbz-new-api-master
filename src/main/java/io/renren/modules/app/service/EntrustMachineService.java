package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.EntrustMachineEntity;

import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:51:31
 */
public interface EntrustMachineService extends IService<EntrustMachineEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils MyqueryPage(Map<String, Object> params);
}

