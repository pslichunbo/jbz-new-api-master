package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.entity.OldMachineEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 二手机械表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@Mapper
public interface OldMachineDao extends BaseMapper<OldMachineEntity> {

    List<OldMachineEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
