package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MaintenanceStoreEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 维修店
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@Mapper
public interface MaintenanceStoreDao extends BaseMapper<MaintenanceStoreEntity> {
    List<MaintenanceStoreEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
