package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MenuNextDao;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.MenuNextService;


@Service("menuNextService")
public class MenuNextServiceImpl extends ServiceImpl<MenuNextDao, MenuNextEntity> implements MenuNextService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenuNextEntity> page = this.selectPage(
                new Query<MenuNextEntity>(params).getPage(),
                new EntityWrapper<MenuNextEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MenuNextEntity> allquery() {
        return baseMapper.allquery();
    }

    public List<MenuNextEntity> queryByRoot(Long rootId){
        EntityWrapper ew = new EntityWrapper(new MenuNextEntity());
        ew.where("menu_root_id ="+rootId);
        return this.selectList(ew);
    }
    public List<MenuNextEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new MenuNextEntity());
        ew.where("state = 0");
        List<MenuNextEntity> list = this.selectList(ew);
        for (MenuNextEntity m : list){
            String[] split = m.getImageUrl()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            m.setImageUrl(split[0]);
        }
        return list;

    }

}
