package io.renren.modules.app.dao;

import io.renren.modules.app.entity.FileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@Mapper
public interface FileDao extends BaseMapper<FileEntity> {
	
}
