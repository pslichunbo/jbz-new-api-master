package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PostEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-24 10:30:16
 */
public interface PostService extends IService<PostEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PostEntity> query();
}

