package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.RealnameAuthenticationEntity;

import java.util.Map;

/**
 * 实名认证表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 15:27:28
 */
public interface RealnameAuthenticationService extends IService<RealnameAuthenticationEntity> {



    PageUtils queryPage(Map<String, Object> params);
}

