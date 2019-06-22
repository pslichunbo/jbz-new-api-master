package io.renren.modules.app.dao;

import io.renren.modules.app.entity.OldMachineEntity;
import io.renren.modules.app.entity.PartsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 配件表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@Mapper
public interface PartsDao extends BaseMapper<PartsEntity> {
    List<PartsEntity> conditionQuery(Map<String, Object> params);
    Integer conditionQueryNum(Map<String, Object> params);
	
}
