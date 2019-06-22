package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MechanicalLeaseEntity;

import java.util.Map;

/**
 * 机械租赁表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public interface MechanicalLeaseService extends IService<MechanicalLeaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage1(Map<String, Object> params);
    PageUtils MyqueryPage(Map<String, Object> params);
//    PageUtils query(Map<String, Object> params);
    boolean deleteByIdWithUserId(Map<String, Object>params);
}

