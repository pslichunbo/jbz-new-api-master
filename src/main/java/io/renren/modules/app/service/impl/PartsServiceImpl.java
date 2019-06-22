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

import io.renren.modules.app.dao.PartsDao;
import io.renren.modules.app.entity.PartsEntity;
import io.renren.modules.app.service.PartsService;


@Service("partsService")
public class PartsServiceImpl extends ServiceImpl<PartsDao, PartsEntity> implements PartsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PartsEntity> page = this.selectPage(
                new Query<PartsEntity>(params).getPage(),
                new EntityWrapper<PartsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        Page<PartsEntity> page = this.selectPage(
                new Query<PartsEntity>(params).getPage(),
                new EntityWrapper<PartsEntity>().where("user_id = {0}",params.get("userId")).orderBy("create_time",false)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage1(Map<String, Object> params) {
        Page<PartsEntity> page = this.selectPage(
                new Query<PartsEntity>(params).getPage(),
                new EntityWrapper<PartsEntity>().orderBy("create_time",false)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils query(Map<String, Object> params) {
        if (params.get("currentPage") == null) {
            params.put("currentPage","1");
        }
        if (params.get("pageSize") == null) {
            params.put("pageSize","10");
        }

        int i1 = (Integer.parseInt((String) params.get("currentPage")) - 1) * (Integer.parseInt((String) params.get("pageSize")));
        String num = String.valueOf(i1);
        params.put("pagenum",num);
        List<PartsEntity> projectEntities = baseMapper.conditionQuery(params);
        Integer integer = baseMapper.conditionQueryNum(params);
        if (integer == null){
            integer = 0;
        }
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
        PageUtils page = new PageUtils(projectEntities,integer,pageSize,currentPage);
        return page;
    }

}
