package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ProjectEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@Mapper
public interface ProjectDao extends BaseMapper<ProjectEntity> {
    List<ProjectEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
