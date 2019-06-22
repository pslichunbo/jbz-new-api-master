package io.renren.modules.app.service.impl;

import io.renren.modules.app.service.PostService;
import io.renren.modules.app.vo.SeekerEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.SeekerDao;
import io.renren.modules.app.entity.SeekerEntity;
import io.renren.modules.app.service.SeekerService;


@Service("seekerService")
public class SeekerServiceImpl extends ServiceImpl<SeekerDao, SeekerEntity> implements SeekerService {
    @Autowired
    private AreaServiceImpl areaServiceImpl;
    @Autowired
    private PostService postService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SeekerEntity> page = this.selectPage(
                new Query<SeekerEntity>(params).getPage(),
                new EntityWrapper<>(new SeekerEntity())
                .orderBy("create_time",false)
        );


        return new PageUtils(page);
    }

    @Override
    public SeekerEntity selectByuserId(Long userid) {
        EntityWrapper<SeekerEntity> wrapper = new EntityWrapper<>(new SeekerEntity());
        wrapper.eq("user_id",userid);
        return this.selectOne(wrapper);
    }
    /**
     *列表
     */
    public PageUtils queryByAll(Map<String, Object> params){
        if(params.get("pageSize")== null){
            params.put("pageSize",30);
        }
        if(params.get("currentPage")== null){
            params.put("currentPage",1);
        }
        String num = String.valueOf((Integer.parseInt(params.get("currentPage").toString())-1)*(Integer.parseInt(params.get("pageSize").toString())));
        params.put("pagenum",num);
        List<SeekerEntity> seekerEntities = baseMapper.conditionQuery(params);
        int i = baseMapper.conditionQueryNum(params);
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        PageUtils page = new PageUtils(seekerEntities, i,pageSize,currentPage);
        return page;
    }

    public boolean updateBySeekerEntity(SeekerEntity seekerEntity){
        EntityWrapper<SeekerEntity> wrapper = new EntityWrapper<>(new SeekerEntity());
        wrapper.eq("user_id",seekerEntity.getUserId());
        return this.update(seekerEntity,wrapper);
    }
    public SeekerEntityVo getSeekerEntityVo(SeekerEntity entity){
        SeekerEntityVo vo = new SeekerEntityVo();
        vo.setAlterTime(entity.getAlterTime());
        vo.setAreaName(areaServiceImpl.selectById(entity.getAreaId()).getTreeNames());
        vo.setBirthday(entity.getBirthday());
        vo.setCreateTime(entity.getCreateTime());
        vo.setDepict(entity.getDepict());
        vo.setExperience(entity.getExperience());
        vo.setId(entity.getId());
        vo.setJob(postService.selectById(entity.getJobId()).getName());
        vo.setName(entity.getName());
        vo.setPhone(entity.getPhone());
        vo.setPhoto(
                entity.getPhoto().replaceAll("[\\[\\]\\\"]","")
                .split(",")
        );
        vo.setPortrait(entity.getPortrait());
        vo.setSalary(entity.getSalary());
        vo.setSex(entity.getSex());
        vo.setSpecialty(entity.getSpecialty());
        return vo;
    }
}
