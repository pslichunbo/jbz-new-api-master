package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.SeekerEntity;

import java.util.List;
import java.util.Map;

/**
 * 求职者简历----找帮手
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:55
 */
public interface SeekerService extends IService<SeekerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    SeekerEntity selectByuserId(Long userid);

}

