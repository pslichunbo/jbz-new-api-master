package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.MenuNextEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MenuRootDao;
import io.renren.modules.app.entity.MenuRootEntity;
import io.renren.modules.app.service.MenuRootService;


@Service("menuRootService")
public class MenuRootServiceImpl extends ServiceImpl<MenuRootDao, MenuRootEntity> implements MenuRootService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenuRootEntity> page = this.selectPage(
                new Query<MenuRootEntity>(params).getPage(),
                new EntityWrapper<MenuRootEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MenuRootEntity> allquery() {
        return baseMapper.allquery();
    }


    public List<MenuRootEntity> All(){
        return baseMapper.allquery();
    }

}
