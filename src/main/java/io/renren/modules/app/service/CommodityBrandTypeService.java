package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CommodityBrandTypeEntity;

import java.util.Map;

/**
 * 商品品牌类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface CommodityBrandTypeService extends IService<CommodityBrandTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

