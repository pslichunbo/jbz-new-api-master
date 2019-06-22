package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SlideShowEntity;

import java.util.Map;

/**
 * 轮播图
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
public interface SlideShowService extends IService<SlideShowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

