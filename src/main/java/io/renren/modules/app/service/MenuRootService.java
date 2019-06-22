package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MenuRootEntity;

import java.util.List;
import java.util.Map;

/**
 * 一级分类表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
public interface MenuRootService extends IService<MenuRootEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<MenuRootEntity> allquery();
}

