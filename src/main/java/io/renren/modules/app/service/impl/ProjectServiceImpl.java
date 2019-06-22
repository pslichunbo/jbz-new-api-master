package io.renren.modules.app.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.service.ProjectTypeService;
import io.renren.modules.app.vo.ProjectApiVo;
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

import io.renren.modules.app.dao.ProjectDao;
import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.service.ProjectService;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {
    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private AreaServiceImpl areaService;

    @Autowired
    private ProjectTypeService projectTypeService;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<ProjectEntity> wrapper = new EntityWrapper<>(new ProjectEntity());
        if (params.get("typeId") != null){
            wrapper.eq("type_id",params.get("typeId").toString());
        }
        if (params.get("areaId") != null){
            String areaId = params.get("areaId").toString();
            String substring = areaId.substring(0, 2);
            wrapper.where("area_id like {0}",substring+"%");
        }
        if (params.get("sort") != null && params.get("sort").equals("ASC")){
            wrapper.orderBy("create_time",true);
        }
        if (params.get("sort") != null && params.get("sort").equals("DESC")){
            wrapper.orderBy("create_time",false);
        }

        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                wrapper
        );

        return new PageUtils(page);
    }




//    public PageUtils conditionQuery(Map<String, Object> params) {
//        if (params.get("currentPage") == null) {
//            params.put("currentPage","1");
//        }
//        if (params.get("pageSize") == null) {
//            params.put("pageSize","10");
//        }
//
//        //根据地区名查询地区id并存到map里
//        if (params.get("areaName") != null){
//            String areaName = params.get("areaName").toString();
//            AreaEntity areaEntity = areaServiceImpl.queryByName(areaName);
//            params.put("areaId",areaEntity.getAreaCode());
//        }
//
//        int i1 = (Integer.parseInt((String) params.get("currentPage")) - 1) * (Integer.parseInt((String) params.get("pageSize")));
//        String num = String.valueOf(i1);
//        params.put("pagenum",num);
//        List<ProjectEntity> projectEntities = baseMapper.conditionQuery(params);
//        int i = baseMapper.conditionQueryNum(params);
//        int currentPage = Integer.parseInt(params.get("currentPage").toString());
//        int pageSize = Integer.parseInt(params.get("pageSize").toString());
//        PageUtils page = new PageUtils(projectEntities,i,pageSize,currentPage);
//        return page;
//
//    }

    public PageUtils queryByaddress(Map<String, Object> params){
        String address = params.get("areaId").toString();
        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                new EntityWrapper<>(new ProjectEntity())
                .where("status = 0 and area_id ="+address)
                .orderBy("create_time",false)
        );
        return new PageUtils(page);
    }
    /**
     *根据用户id查询用户发布的工程项目
     */
    public PageUtils queryByUserId(Map<String, Object> params){
        int userId = Integer.parseInt(params.get("userId").toString());
        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                new EntityWrapper<>(new ProjectEntity())
                .where(" status = 0 and user_id ="+userId)
        );
        List<ProjectEntity> records = page.getRecords();
        for (ProjectEntity p : records){
            String[] split = p.getImages()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            p.setImages(split[0]);
        }
        return new PageUtils(page);
    }

    public boolean deleteByUserIdWithProjectId(Map<String, Object> params){
        EntityWrapper<ProjectEntity> wrapper = new EntityWrapper<>(new ProjectEntity());
        wrapper.eq("id",params.get("id").toString());
        wrapper.eq("user_id",params.get("userId").toString());
        return this.delete(wrapper);
    }

    public ProjectApiVo getVo(ProjectEntity entity){
        ProjectApiVo vo = new ProjectApiVo();
        vo.setAddress(entity.getAddress());
        vo.setArea(areaService.selectById(entity.getAreaId()).getTreeNames());
        vo.setContinues(entity.getContinues());
        vo.setContractor(entity.getContractor());
        vo.setCost(entity.getCost());
        vo.setCreateTime(entity.getCreateTime());
        vo.setId(entity.getId());
        vo.setImages(entity.getImages());
        vo.setPhone(entity.getPhone());
        vo.setPrincipal(entity.getPrincipal());
        vo.setPrincipalAddr(entity.getPrincipalAddr());
        vo.setProjectBrief(entity.getProjectBrief());
        vo.setStatus(entity.getStatus());
        vo.setTitle(entity.getTitle());
        vo.setTypeName(projectTypeService.selectById(entity.getTypeId()).getName());
        vo.setUserId(entity.getUserId());
        vo.setCost(entity.getCost());
        return vo;
    }


}
