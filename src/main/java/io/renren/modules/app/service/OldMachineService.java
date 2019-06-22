package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.entity.OldMachineEntity;

import java.util.List;
import java.util.Map;

/**
 * 二手机械表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public interface OldMachineService extends IService<OldMachineEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage1(Map<String, Object> params);
    PageUtils MyqueryPage(Map<String, Object> params);
//    PageUtils query(Map<String, Object> params);
    List<MenuNextEntity> queryNext(Long id);

    boolean deleteByUserId(Map<String, Object> params);
}

