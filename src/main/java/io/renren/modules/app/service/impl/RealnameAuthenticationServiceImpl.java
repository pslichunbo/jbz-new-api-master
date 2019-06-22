package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.RealnameAuthenticationDao;
import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import io.renren.modules.app.service.RealnameAuthenticationService;


@Service("realnameAuthenticationService")
public class RealnameAuthenticationServiceImpl extends ServiceImpl<RealnameAuthenticationDao, RealnameAuthenticationEntity> implements RealnameAuthenticationService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RealnameAuthenticationEntity> page = this.selectPage(
                new Query<RealnameAuthenticationEntity>(params).getPage(),
                new EntityWrapper<>(new RealnameAuthenticationEntity())
        );
        return new PageUtils(page);
    }
    /***
     * 根据用户id查询认证记录
     */
    public RealnameAuthenticationEntity getByUserId(Long userId){
        EntityWrapper<RealnameAuthenticationEntity> wrapper = new EntityWrapper<>(new RealnameAuthenticationEntity());
        wrapper.eq("user_id",userId);
        return this.selectOne(wrapper);
    }

}
