package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AdvcoagentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 发布招聘-----找帮手
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:54
 */
@Mapper
public interface AdvcoagentDao extends BaseMapper<AdvcoagentEntity> {
    List<AdvcoagentEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
}
