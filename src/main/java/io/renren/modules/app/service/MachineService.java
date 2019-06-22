package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MachineEntity;

import java.util.Map;

/**
 * 新机表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public interface MachineService extends IService<MachineEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage1(Map<String, Object> params);
}

