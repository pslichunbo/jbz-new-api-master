package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.IndustryInfoEntity;

import java.util.Map;

/**
 * 行业信息表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface IndustryInfoService extends IService<IndustryInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageOne(Map<String, Object> params);
}

