package io.renren.modules.app.service.impl;

import io.renren.modules.app.dao.MenuNextDao;
import io.renren.modules.app.entity.MachineEntity;
import io.renren.modules.app.entity.MenuNextEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.OldMachineDao;
import io.renren.modules.app.entity.OldMachineEntity;
import io.renren.modules.app.service.OldMachineService;

import javax.annotation.Resource;


@Service("oldMachineService")
public class OldMachineServiceImpl extends ServiceImpl<OldMachineDao, OldMachineEntity> implements OldMachineService {

    @Resource
    private MenuNextDao menuNextDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<OldMachineEntity> wrapper = new EntityWrapper<>(new OldMachineEntity());
        if (params.get("menuRootId") != null){
            wrapper.eq("menu_root_id",params.get("menuRootId"));
        }
        if (params.get("menuNextId") != null){
            wrapper.eq("menu_next_id",params.get("menuNextId"));
        }
        if (params.get("areaId") != null){
            wrapper.eq("area_id",params.get("areaId"));
        }
        if (params.get("brandId") != null){
            wrapper.eq("brand_id",params.get("brandId"));
        }
        if (params.get("workingLife") != null){
            wrapper.like("working_life",params.get("workingLife").toString());
        }
        wrapper.orderBy("create_time",false);
        Page<OldMachineEntity> page = this.selectPage(
                new Query<OldMachineEntity>(params).getPage(),
                wrapper
        );

        return new PageUtils(page);
    }
    @Override
    public PageUtils queryPage1(Map<String, Object> params) {
        Page<OldMachineEntity> page = this.selectPage(
                new Query<OldMachineEntity>(params).getPage(),
                new EntityWrapper<OldMachineEntity>().orderBy("create_time",false)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        Page<OldMachineEntity> page = this.selectPage(
                new Query<OldMachineEntity>(params).getPage(),
                new EntityWrapper<OldMachineEntity>().where("user_id = {0}",params.get("userId"))
        );
        return new PageUtils(page);
    }

//    @Override
//    public PageUtils query(Map<String, Object> params) {
//
//        if (params.get("currentPage") == null) {
//            params.put("currentPage","1");
//        }
//        if (params.get("pageSize") == null) {
//            params.put("pageSize","10");
//        }
//
//        int i1 = (Integer.parseInt((String) params.get("currentPage")) - 1) * (Integer.parseInt((String) params.get("pageSize")));
//        String num = String.valueOf(i1);
//        params.put("pagenum",num);
//        List<OldMachineEntity> projectEntities = baseMapper.conditionQuery(params);
//        int i = baseMapper.conditionQueryNum(params);
//        int currentPage = Integer.parseInt(params.get("currentPage").toString());
//        int pageSize = Integer.parseInt(params.get("pageSize").toString());
//        PageUtils page = new PageUtils(projectEntities,i,pageSize,currentPage);
//        return page;
//    }

    @Override
    public List<MenuNextEntity> queryNext(Long id) {
        return menuNextDao.queryNext(id);
    }

    @Override
    public boolean deleteByUserId(Map<String, Object> params) {
        EntityWrapper<OldMachineEntity> wrapper = new EntityWrapper<>(new OldMachineEntity());
        wrapper.eq("id",params.get("id"));
        wrapper.eq("user_id",params.get("userId"));
        return this.delete(wrapper);
    }

}
