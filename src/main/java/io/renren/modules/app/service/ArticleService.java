package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.ArticleEntity;

import java.util.List;
import java.util.Map;

/**
 * 文章表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface ArticleService extends IService<ArticleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageOne(Map<String, Object> params);

    PageUtils queryPageID(Map<String, Object> params);

    List<ArticleEntity> selectAll();
}

