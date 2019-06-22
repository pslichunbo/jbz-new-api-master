package io.renren.modules.app.dao;

import io.renren.modules.app.entity.AreaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 全国行政区域
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-30 14:49:23
 */
@Mapper
public interface AreaDao extends BaseMapper<AreaEntity> {

    AreaEntity getArea(@Param("id") String id);
	
}
