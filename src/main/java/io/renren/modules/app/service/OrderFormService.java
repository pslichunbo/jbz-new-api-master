package io.renren.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.OrderFormEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 订单表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
public interface OrderFormService extends IService<OrderFormEntity> {
    void dispose(OrderFormEntity orderForm);
    PageUtils queryPage(Map<String, Object> params);
    PageUtils query(Map<String, Object> params);
    PageUtils query1(Map<String, Object> params);
    PageUtils query2(Map<String, Object> params);
    int proposerNum(Long sourceGoodsId);
    void delete(Long[] ids);
    void deletesp(OrderFormEntity orderForm);
    void updateWithId(Map<String, Object> params);
}

