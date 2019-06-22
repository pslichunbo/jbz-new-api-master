package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.ProjectTypeEntity;
import io.renren.modules.app.service.ProjectTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@RestController
@RequestMapping("app/projecttype")
public class ProjectTypeController {
    @Autowired
    private ProjectTypeService projectTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:projecttype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:projecttype:info")
    public R info(@PathVariable("id") Long id){
			ProjectTypeEntity projectType = projectTypeService.selectById(id);

        return R.ok().put("data", projectType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:projecttype:save")
    public R save(@RequestBody ProjectTypeEntity projectType){
            projectType.setCreateTime(new Date());
			projectTypeService.insert(projectType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:projecttype:update")
    public R update(@RequestBody ProjectTypeEntity projectType){
			projectTypeService.updateById(projectType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:projecttype:delete")
    public R delete(@RequestBody Long[] ids){
			projectTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
