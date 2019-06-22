package io.renren.modules.app.dao;

import io.renren.modules.app.entity.SeekerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 求职者简历----找帮手
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:55
 */
@Mapper
public interface SeekerDao extends BaseMapper<SeekerEntity> {

    List<SeekerEntity> conditionQuery(Map<String, Object> params);

    int conditionQueryNum(Map<String, Object> params);

    SeekerEntity selectByuserId(@Param("userid") Long userid);
	
}
