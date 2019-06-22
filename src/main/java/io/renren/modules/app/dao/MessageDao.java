package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MessageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 14:35:24
 */
@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
	
}
