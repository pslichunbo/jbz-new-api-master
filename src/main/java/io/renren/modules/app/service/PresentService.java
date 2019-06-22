package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.app.vo.PresentEntityVo;

import java.util.Map;

/**
 * 礼品表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public interface PresentService extends IService<PresentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPageAll(Map<String, Object> params);

}

