package io.renren.modules.app.dao;

import io.renren.modules.app.entity.SourceGoodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 货源表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
@Mapper
public interface SourceGoodsDao extends BaseMapper<SourceGoodsEntity> {

    List<SourceGoodsEntity> conditionQuery(Map<String, Object> params);
    int conditionQueryNum(Map<String, Object> params);
	
}
