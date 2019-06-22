package io.renren.modules.app.dao;

import io.renren.modules.app.entity.CodeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-16 14:16:55
 */
@Mapper
public interface CodeDao extends BaseMapper<CodeEntity> {

  CodeEntity code(String c);
	
}
