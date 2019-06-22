package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MerchantEntity;

import java.util.Map;

/**
 * 信息对象表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface MerchantService extends IService<MerchantEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageOne(Map<String, Object> params);
    Boolean removeById(Long id, Long userId);
}

