package io.renren.modules.app.controller.api;


import java.util.*;
import java.util.stream.Collectors;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.ProjectTypeEntity;
import io.renren.modules.app.form.ProjectForm;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.ProjectServiceImpl;
import io.renren.modules.app.service.impl.ProjectTypeServiceImpl;
import io.renren.modules.app.vo.ProjectApiVo;
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
@RequestMapping("aul/project")
public class ProjectApiController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ProjectTypeServiceImpl projectTypeServiceImpl;

    @Autowired
    private AreaServiceImpl areaServiceImpl;


    /**
     * 工程项目首页
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = projectService.queryPage(params);
        List<ProjectEntity> content = (List<ProjectEntity>) pageUtils.getContent();
        List<ProjectApiVo> list = new ArrayList<>();
        content.stream().filter(p->list.add(projectServiceImpl.getVo(p))).collect(Collectors.toList());
        pageUtils.setContent(list);
        return R.ok().put("data",pageUtils);
        }




    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProjectEntity project = projectService.selectById(id);
        ProjectApiVo vo = projectServiceImpl.getVo(project);
        return R.ok().put("data", vo);
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProjectForm form){
            ProjectEntity project = new ProjectEntity();
            project.setImages(form.getImages().replaceAll("[\\[\\]\\\"]",""));
            project.setAddress(form.getAddress());
            project.setUserId(form.getUserId());
            project.setAreaId(form.getArea());
            project.setCost(form.getCost());
            project.setContractor(form.getContractor());
            project.setPhone(form.getPhone());
            project.setPrincipal(form.getPrincipal());
            project.setTitle(form.getTitle());
            project.setTypeId(form.getTypeId());
            project.setCreateTime(new Date());
            project.setProjectBrief(form.getProjectBrief());
            //是否承接 0已承接 1未承接
            project.setContinues((long) 1);
            //状态 0可用 1不可用
            project.setStatus((long) 0);
			projectService.insert(project);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProjectEntity project){
			projectService.updateById(project);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			projectService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


/**
 *查询所有可用类型的接口
 */
    @GetMapping("/allType")
    public R selectAllType(){
        return R.ok().put("data",projectTypeServiceImpl.queryAll());
    }

    /**
     *根据用户id查询用户发布的项目接口
     */
    @GetMapping("/byUserId")
    public R selectByUserId(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = projectServiceImpl.queryByUserId(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     * 根据用户id和工程id删除工程
     */
    @DeleteMapping("/deleteByIdWithUserId")
    public R deleteByIdWithUserId(@RequestParam Map<String, Object> params){
        if (params.get("id") == null){
            return R.error("必须提供项目ID");
        }
        if (params.get("userId") == null){
            return R.error("必须提供用户ID");
        }
        projectServiceImpl.deleteByUserIdWithProjectId(params);
        return R.ok();
    }

}
