package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MachineEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 新机表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@Mapper
public interface MachineDao extends BaseMapper<MachineEntity> {
    List<MachineEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
