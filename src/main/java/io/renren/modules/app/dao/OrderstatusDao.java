package io.renren.modules.app.dao;

import io.renren.modules.app.entity.OrderstatusEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 17:50:35
 */
@Mapper
public interface OrderstatusDao extends BaseMapper<OrderstatusEntity> {
    OrderstatusEntity  Bystatus(@Param("id") Long id);
	
}
