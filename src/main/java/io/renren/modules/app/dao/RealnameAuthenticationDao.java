package io.renren.modules.app.dao;

import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 实名认证表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 15:27:28
 */
@Mapper
public interface RealnameAuthenticationDao extends BaseMapper<RealnameAuthenticationEntity> {
	
}
