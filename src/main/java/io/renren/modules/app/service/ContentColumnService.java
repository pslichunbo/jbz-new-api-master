package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ContentColumnEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-20 15:02:48
 */
public interface ContentColumnService extends IService<ContentColumnEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<ContentColumnEntity> select();
    List<ContentColumnEntity> queryNext(String id);

}

