package io.renren.modules.app.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.PostService;
import io.renren.modules.app.vo.AdminAdvcoVO;
import io.renren.modules.app.vo.AdvcoagentEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AdvcoagentDao;
import io.renren.modules.app.entity.AdvcoagentEntity;
import io.renren.modules.app.service.AdvcoagentService;


@Service("advcoagentService")
public class AdvcoagentServiceImpl extends ServiceImpl<AdvcoagentDao, AdvcoagentEntity> implements AdvcoagentService {

    @Autowired
    private AreaServiceImpl areaServiceImpl;
    @Autowired
    private AreaService areaService;
    @Autowired
    private PostService postService;
    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdvcoagentEntity> page = this.selectPage(
                new Query<AdvcoagentEntity>(params).getPage(),
                new EntityWrapper<AdvcoagentEntity>()
                .orderBy("create_time",false)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils myqueryPage(Map<String, Object> params) {
        Page<AdvcoagentEntity> page = this.selectPage(
                new Query<AdvcoagentEntity>(params).getPage(),
                new EntityWrapper<>(new AdvcoagentEntity())
                        .eq("user_id",params.get("userId").toString())
        );
        return new PageUtils(page);
    }

    public PageUtils queryAll(Map<String, Object> params){
        if(params.get("pageSize")== null){
            params.put("pageSize",30);
        }
        if(params.get("currentPage")== null){
            params.put("currentPage",1);
        }
        String num = String.valueOf((Integer.parseInt((String)params.get("currentPage"))-1)*(Integer.parseInt((String)params.get("pageSize"))));
        params.put("pagenum",num);
        List<AdvcoagentEntity> advcoagentEntities = baseMapper.conditionQuery(params);
        int i = baseMapper.conditionQueryNum(params);
        int pageSize = Integer.parseInt((String)params.get("pageSize"));
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        PageUtils page = new PageUtils(advcoagentEntities, i,pageSize,currentPage);
        return page;
    }

    public PageUtils queryByUserId(Map<String, Object> params){
        Long userId = Long.parseLong(params.get("userId").toString());
        Page<AdvcoagentEntity> page = this.selectPage(
                new Query<AdvcoagentEntity>(params).getPage(),
                new EntityWrapper<>(new AdvcoagentEntity())
                .where("user_id ="+userId)
        );
        return new PageUtils(page);
    }

    public void deleteByUserId(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long userId = Long.parseLong(params.get("userId").toString());
        EntityWrapper ew = new EntityWrapper(new AdvcoagentEntity());
        ew.where("`id`={0} and user_id = {1}",id,userId);
        this.delete(ew);
    }

    /**
     * 封装视图对象
     */
    public AdvcoagentEntityVo getAdvcoagentEntityVo(AdvcoagentEntity entity){
        AdvcoagentEntityVo vo = new AdvcoagentEntityVo();
        vo.setDepict(entity.getDepict());
        vo.setRemark(entity.getRemark());
        vo.setAddress(entity.getAddress());
        vo.setAdvertiseNumber(entity.getAdvertiseNumber());
        vo.setAgeGroup(entity.getAgeGroup());
        vo.setAlterTime(entity.getAlterTime());
        vo.setAreaName(areaServiceImpl.selectById(entity.getAreaId()).getTreeNames());
        vo.setCompany(entity.getCompany());
        vo.setCreateTime(entity.getCreateTime());
        vo.setExperience(entity.getExperience());
        vo.setId(entity.getId());
        vo.setJob(postService.selectById(entity.getJobId()).getName());
        vo.setPhone(entity.getPhone());
        vo.setPrincipal(entity.getPrincipal());
        vo.setProperty(entity.getProperty());
        vo.setSalary(entity.getSalary());
        vo.setSex(entity.getSex());
        vo.setTitle(entity.getTitle());
        vo.setUserName(sysUserService.selectById(entity.getUserId()).getUsername());
        vo.setUserId(entity.getUserId());
        vo.setJobId(entity.getJobId());
        return vo;
    }
    /**
     * 后台视图
     */
    public AdvcoagentEntityVo getVo(AdvcoagentEntity s){
        AdvcoagentEntityVo en= new AdvcoagentEntityVo();
        AreaEntity areaEntity = areaService.selectById(s.getAreaId());
        SysUserEntity userEntity = sysUserService.selectById(s.getUserId());
        if (userEntity != null){
            en.setUserName(userEntity.getUsername());
        }
        en.setId(s.getId());
        PostEntity postEntity = postService.selectById(s.getJobId());
        en.setJob(postEntity.getName());
        en.setExperience(s.getExperience());
        en.setSalary(s.getSalary());
        en.setProperty(s.getProperty());
        en.setAdvertiseNumber(s.getAdvertiseNumber());
        en.setAgeGroup(s.getAgeGroup());
        en.setSex(s.getSex());
        if(s.getDepict() != null){
            en.setDepict(s.getDepict());
        }else {
            en.setDepict(s.getDepict());
        }
        en.setCreateTime(s.getCreateTime());
        en.setAlterTime(s.getAlterTime());
        en.setTitle(s.getTitle());
        en.setAreaName(areaEntity.getTreeNames());
        en.setAddress(s.getAddress());
        en.setCompany(s.getCompany());
        en.setPrincipal(s.getPrincipal());
        en.setPhone(s.getPhone());
        if(s.getRemark() != null){
            en.setRemark(s.getRemark());
        }else {
            en.setRemark(s.getRemark());
        }

       return en;
    }


    public AdminAdvcoVO getAdminVo(AdvcoagentEntity entity){
        AdminAdvcoVO vo = new AdminAdvcoVO();
        vo.setAddress(entity.getAddress());
        vo.setAdvertiseNumber(entity.getAdvertiseNumber());
        vo.setAgeGroup(entity.getAgeGroup());
        vo.setAlterTime(entity.getAlterTime());
        vo.setAreaId(entity.getAreaId());
        String[] split = areaService.selectById(entity.getAreaId()).getParentCodes().split(",");
        vo.setProviceId(split[1]);
        vo.setCityId(split[2]);
        vo.setCompany(entity.getCompany());
        vo.setCreateTime(entity.getCreateTime());
        vo.setDepict(entity.getDepict());
        vo.setExperience(entity.getExperience());
        vo.setId(entity.getId());
        vo.setJobId(entity.getJobId());
        vo.setPhone(entity.getPhone());
        vo.setPrincipal(entity.getPrincipal());
        vo.setProperty(entity.getProperty());
        vo.setRemark(entity.getRemark());
        vo.setSalary(entity.getSalary());
        vo.setSex(entity.getSex());
        vo.setTitle(entity.getTitle());
        vo.setUserId(entity.getUserId());
        return vo;
    }



}
