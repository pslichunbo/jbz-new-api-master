package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;

import java.util.Map;

/**
 * 身份
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 14:59:42
 */
public interface QualificationsAuthenticateService extends IService<QualificationsAuthenticateEntity> {



    PageUtils queryPage(Map<String, Object> params);
}

