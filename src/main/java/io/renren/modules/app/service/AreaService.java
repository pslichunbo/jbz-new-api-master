package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.AreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 全国行政区域
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-30 14:49:23
 */
public interface AreaService extends IService<AreaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<AreaEntity> getAreaList(String id);

    AreaEntity getArea(String id);


}

