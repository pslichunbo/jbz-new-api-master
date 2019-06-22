package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MachineDao;
import io.renren.modules.app.entity.MachineEntity;
import io.renren.modules.app.service.MachineService;


@Service("machineService")
public class MachineServiceImpl extends ServiceImpl<MachineDao, MachineEntity> implements MachineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MachineEntity> page = this.selectPage(
                new Query<MachineEntity>(params).getPage(),
                new EntityWrapper<MachineEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage1(Map<String, Object> params) {

        if (params.get("currentPage") == null) {
            params.put("currentPage","1");
        }
        if (params.get("pageSize") == null) {
            params.put("pageSize","10");
        }

        int i1 = (Integer.parseInt((String) params.get("currentPage")) - 1) * (Integer.parseInt((String) params.get("pageSize")));
        String num = String.valueOf(i1);
        params.put("pagenum",num);
        List<MachineEntity> projectEntities = baseMapper.conditionQuery(params);
        int i = baseMapper.conditionQueryNum(params);
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
        PageUtils page = new PageUtils(projectEntities,i,pageSize,currentPage);
        return page;

    }

}
