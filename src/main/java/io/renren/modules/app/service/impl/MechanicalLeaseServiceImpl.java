package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.OldMachineEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MechanicalLeaseDao;
import io.renren.modules.app.entity.MechanicalLeaseEntity;
import io.renren.modules.app.service.MechanicalLeaseService;


@Service("mechanicalLeaseService")
public class MechanicalLeaseServiceImpl extends ServiceImpl<MechanicalLeaseDao, MechanicalLeaseEntity> implements MechanicalLeaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<MechanicalLeaseEntity> wrapper = new EntityWrapper<>(new MechanicalLeaseEntity());
        if (params.get("areaId") != null){
            wrapper.eq("area_id",params.get("areaId"));
        }
        if (params.get("menuNextId") != null){
            wrapper.eq("menu_next_id",params.get("menuNextId"));
        }
        if (params.get("menuRootId") != null){
            wrapper.eq("menu_root_id",params.get("menuRootId"));
        }
        if (params.get("workingLife") != null){
            wrapper.like("working_life",params.get("workingLife").toString());
        }
        if (params.get("leaseholdPrice") != null){
            if (params.get("leaseholdPrice").equals("100以下")){
                wrapper.le("leasehold_price",100);
            }
            if (params.get("leaseholdPrice").equals("100-300")){
                wrapper.gt("leasehold_price",100);
                wrapper.le("leasehold_price",300);
            }
            if (params.get("leaseholdPrice").equals("300-500")){
                wrapper.gt("leasehold_price",300);
                wrapper.le("leasehold_price",500);
            }
            if (params.get("leaseholdPrice").equals("500-1000")){
                wrapper.gt("leasehold_price",500);
                wrapper.le("leasehold_price",1000);
            }
            if (params.get("leaseholdPrice").equals("1000以上")){
                wrapper.gt("leasehold_price",1000);
            }
        }
        wrapper.orderBy("create_time",false);
        Page<MechanicalLeaseEntity> page = this.selectPage(
                new Query<MechanicalLeaseEntity>(params).getPage(),
               wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage1(Map<String, Object> params) {
        Page<MechanicalLeaseEntity> page = this.selectPage(
                new Query<MechanicalLeaseEntity>(params).getPage(),
                new EntityWrapper<MechanicalLeaseEntity>().orderBy("create_time",false)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        Page<MechanicalLeaseEntity> page = this.selectPage(
                new Query<MechanicalLeaseEntity>(params).getPage(),
                new EntityWrapper<MechanicalLeaseEntity>()
                .where("user_id = {0}",params.get("userId"))
                .orderBy("create_time",false)
        );
        return new PageUtils(page);
    }

//    @Override
//    public PageUtils query(Map<String, Object> params) {
//        if (params.get("currentPage") == null) {
//            params.put("currentPage","1");
//        }
//        if (params.get("pageSize") == null) {
//            params.put("pageSize","10");
//        }
//        if (params.get("price") != null){
//            String prices = params.get("price").toString();
//
//        }
//
//        int i1 = (Integer.parseInt((String) params.get("currentPage")) - 1) * (Integer.parseInt((String) params.get("pageSize")));
//        String num = String.valueOf(i1);
//        params.put("pagenum",num);
//        List<MechanicalLeaseEntity> projectEntities = baseMapper.conditionQuery(params);
//        int i = baseMapper.conditionQueryNum(params);
//        int currentPage = Integer.parseInt(params.get("currentPage").toString());
//        int pageSize = Integer.parseInt(params.get("pageSize").toString());
//        PageUtils page = new PageUtils(projectEntities,i,pageSize,currentPage);
//        return page;
//    }

    public boolean deleteByIdWithUserId(Map<String, Object> params){
        EntityWrapper<MechanicalLeaseEntity> wrapper = new EntityWrapper<>(new MechanicalLeaseEntity());
        wrapper.eq("id",params.get("id").toString());
        wrapper.eq("user_id",params.get("userId").toString());
        return this.delete(wrapper);
    }

}
