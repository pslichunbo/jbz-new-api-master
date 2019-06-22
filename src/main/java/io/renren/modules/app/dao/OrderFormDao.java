package io.renren.modules.app.dao;

import io.renren.modules.app.entity.OrderFormEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 订单表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
@Mapper
public interface OrderFormDao extends BaseMapper<OrderFormEntity> {

    int proposerNum(@Param("sourceGoodsId") Long sourceGoodsId);
    void logicdelete(@Param("id") Long id);
    void dispose(OrderFormEntity orderForm);
    void deletesp(OrderFormEntity orderForm);
    void updateWithId(Map<String, Object> params);
	
}
