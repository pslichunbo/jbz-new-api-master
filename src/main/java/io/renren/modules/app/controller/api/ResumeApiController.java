package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ResumeEntity;
import io.renren.modules.app.service.ResumeService;
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
@RequestMapping("api/resume")
public class ResumeApiController {
    @Autowired
    private ResumeService resumeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ResumeEntity resume = resumeService.selectById(id);

        return R.ok().put("resume", resume);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ResumeEntity resume){
			resumeService.insert(resume);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ResumeEntity resume){
			resumeService.updateById(resume);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			resumeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
