package io.renren.modules.app.dao;

import io.renren.modules.app.entity.PostEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-24 10:30:16
 */
@Mapper
public interface PostDao extends BaseMapper<PostEntity> {

    List<PostEntity> query();
	
}
