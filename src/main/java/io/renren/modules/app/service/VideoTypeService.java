package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.VideoTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 视频类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
public interface VideoTypeService extends IService<VideoTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<VideoTypeEntity> queryALL();

}

