package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MechanicalLeaseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.app.entity.OldMachineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机械租赁表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@Mapper
public interface MechanicalLeaseDao extends BaseMapper<MechanicalLeaseEntity> {

    List<MechanicalLeaseEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
