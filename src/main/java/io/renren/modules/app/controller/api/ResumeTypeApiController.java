package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ResumeTypeEntity;
import io.renren.modules.app.service.ResumeTypeService;
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
@RequestMapping("api/resumetype")
public class ResumeTypeApiController {
    @Autowired
    private ResumeTypeService resumeTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ResumeTypeEntity resumeType = resumeTypeService.selectById(id);

        return R.ok().put("resumeType", resumeType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ResumeTypeEntity resumeType){
			resumeTypeService.insert(resumeType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ResumeTypeEntity resumeType){
			resumeTypeService.updateById(resumeType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			resumeTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
