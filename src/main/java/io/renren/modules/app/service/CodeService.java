package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.CodeEntity;

import java.util.Map;

/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-16 14:16:55
 */
public interface CodeService extends IService<CodeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    String code(String phone);

}

