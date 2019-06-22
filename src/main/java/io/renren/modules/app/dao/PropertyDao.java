package io.renren.modules.app.dao;

import io.renren.modules.app.entity.PropertyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 属性
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@Mapper
public interface PropertyDao extends BaseMapper<PropertyEntity> {

    List<PropertyEntity> allquery();
	
}
