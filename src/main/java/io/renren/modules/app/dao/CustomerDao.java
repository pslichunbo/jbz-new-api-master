package io.renren.modules.app.dao;

import io.renren.modules.app.entity.CustomerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-18 09:51:11
 */
@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
    List<CustomerEntity> query();
	
}
