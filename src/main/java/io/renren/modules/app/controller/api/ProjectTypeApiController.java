package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/projecttype")
public class ProjectTypeApiController {
    @Autowired
    private ProjectTypeService projectTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ProjectTypeEntity projectType = projectTypeService.selectById(id);

        return R.ok().put("projectType", projectType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProjectTypeEntity projectType){
			projectTypeService.insert(projectType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProjectTypeEntity projectType){
			projectTypeService.updateById(projectType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			projectTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
