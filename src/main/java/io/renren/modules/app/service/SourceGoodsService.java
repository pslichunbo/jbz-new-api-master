package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SourceGoodsEntity;

import java.util.Map;

/**
 * 货源表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
public interface SourceGoodsService extends IService<SourceGoodsEntity> {



    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage1(Map<String, Object> params);


    //分页查询全部货源
    PageUtils selectPage(Map<String, Object> params);
}

