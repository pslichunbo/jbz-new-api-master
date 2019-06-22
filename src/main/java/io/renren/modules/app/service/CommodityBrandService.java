package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CommodityBrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品品牌表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface CommodityBrandService extends IService<CommodityBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<CommodityBrandEntity> allquery();
}

