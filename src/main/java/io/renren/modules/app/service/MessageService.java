package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.MessageEntity;

import java.util.Map;

/**
 * 消息表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 14:35:24
 */
public interface MessageService extends IService<MessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils SysqueryPage(Map<String, Object> params);
    PageUtils orderqueryPage(Map<String, Object> params);
    PageUtils sourcequeryPage(Map<String, Object> params);
}

