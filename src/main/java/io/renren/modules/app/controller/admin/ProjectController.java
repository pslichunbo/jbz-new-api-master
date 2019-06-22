package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.ProjectTypeEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.ProjectTypeServiceImpl;
import io.renren.modules.app.vo.ProjectVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ProjectEntity;
import io.renren.modules.app.service.ProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@RestController
@RequestMapping("app/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    private ProjectTypeServiceImpl projectTypeServiceImpl;

    @Autowired
    private AreaService areaService;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:project:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);
        List<ProjectEntity> content = (List<ProjectEntity>) page.getContent();
        List<ProjectVo> list = new ArrayList<>();
        for (ProjectEntity p : content){
            AreaEntity areaEntity = areaServiceImpl.selectById(p.getAreaId());
            if(areaEntity == null){
                return R.error("数据查询错误！");
            }
            SysUserEntity userEntity = sysUserServiceImpl.selectById(p.getUserId());
            if(userEntity == null){
                return R.error("数据查询错误！");
            }
            ProjectTypeEntity projectTypeEntity = projectTypeServiceImpl.selectById(p.getTypeId());
            if(projectTypeEntity == null){
                return R.error("数据查询错误！");
            }
            ProjectVo vo = new ProjectVo();
            vo.setAddress(p.getAddress());
            vo.setArea(areaEntity.getAreaName());
            vo.setContractor(p.getContractor());
            vo.setCreateTime(p.getCreateTime());
            vo.setId(p.getId());
            vo.setImages(p.getImages());
            vo.setPhone(p.getPhone());
            vo.setPrincipal(p.getPrincipal());
            vo.setPrincipalAddr(p.getPrincipalAddr());
            vo.setStatus(p.getStatus());
            vo.setProjectBrief(p.getProjectBrief());
            vo.setTitle(p.getTitle());
            vo.setTypeName(projectTypeEntity.getName());
            vo.setUserName(userEntity.getUsername());
            vo.setContinues(p.getContinues());
            vo.setCost(p.getCost());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:project:info")
    public R info(@PathVariable("id") Long id){
        ProjectEntity s = projectService.selectById(id);
        ProjectVo vo = new ProjectVo();
        vo.setId(s.getId());
        vo.setTitle(s.getTitle());
        vo.setAreaId(s.getAreaId());
        vo.setCityId(Long.parseLong(areaService.selectById(s.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        vo.setImages(s.getImages());
        vo.setTypeId((s.getTypeId()).toString());
        vo.setPhone(s.getPhone());
        vo.setAddress(s.getAddress());
        vo.setCreateTime(s.getCreateTime());
        vo.setContractor(s.getContractor());
        vo.setPrincipal(s.getPrincipal());
        vo.setPrincipalAddr(s.getPrincipalAddr());
        vo.setStatus(s.getStatus());
        vo.setProjectBrief(s.getProjectBrief());
        vo.setUserId((s.getUserId()).toString());
        vo.setCost(s.getCost());
        return R.ok().put("project", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:project:save")
    public R save(@RequestBody ProjectEntity project){
            if (project.getAreaId() == null || project.getAreaId().equals("")){
                return R.error("地区不能为空");
            }
            if (project.getImages() == null || project.getImages().equals("\"\"")){
                return R.error("图片不能为空");
            }
            if (project.getTypeId() == null || project.getTypeId().equals("")){
                return R.error("类型不能为空");
            }
            if (project.getPhone().length() != 11){
                return R.error("电话号码必须是十一位");
            }else {
                Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
                Matcher matcher = compile.matcher(project.getPhone());
                boolean matches = matcher.matches();
                if (!matches){
                    return R.error("手机号码格式不正确");
                }else {
                    project.setImages(project.getImages().replaceAll("[\\[\\]\\\"]",""));
                    project.setProjectBrief(project.getProjectBrief().replaceAll("<([^>]*)>",""));
                    project.setCreateTime(new Date());
                    project.setStatus((long) 0);
                    project.setContinues((long) 1);
                    SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                    project.setUserId(userEntity.getUserId());
                    projectService.insert(project);
                    return R.ok();
                }
            }
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:project:update")
    public R update(@RequestBody ProjectEntity project){
        if (project.getAreaId() == null || project.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (project.getTypeId() == null || project.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (project.getImages() == null || project.getImages().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (project.getPhone().length() != 11){
            return R.error("电话号码必须是11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            Matcher matcher = compile.matcher(project.getPhone());
            boolean matches = matcher.matches();
            if (!matches){
                return R.error("手机号码格式不正确");
            }else {
                project.setImages(project.getImages().replaceAll("[\\[\\]\\\"]",""));
                project.setProjectBrief(project.getProjectBrief().replaceAll("<([^>]*)>",""));
                SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                project.setUserId(userEntity.getUserId());
                projectService.updateById(project);
                return R.ok();
            }
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:project:delete")
    public R delete(@RequestBody Long[] ids){
			projectService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查询所有类型
     */
    @GetMapping("/allType")
    public R selectAllType(){
        return R.ok().put("data",projectTypeServiceImpl.queryAll());
    }
    /**
     *查询所有地区
     */
    @GetMapping("/allArea")
    public R selectAllArea(){
        return R.ok().put("data",areaServiceImpl.queryall());
    }
}
