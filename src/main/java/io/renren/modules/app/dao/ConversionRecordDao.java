package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ConversionRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 兑换记录表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@Mapper
public interface ConversionRecordDao extends BaseMapper<ConversionRecordEntity> {
	
}
