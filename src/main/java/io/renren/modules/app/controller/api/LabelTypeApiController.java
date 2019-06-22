package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.LabelTypeEntity;
import io.renren.modules.app.service.LabelTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 标签类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/labeltype")
public class LabelTypeApiController {
    @Autowired
    private LabelTypeService labelTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = labelTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			LabelTypeEntity labelType = labelTypeService.selectById(id);

        return R.ok().put("labelType", labelType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody LabelTypeEntity labelType){
			labelTypeService.insert(labelType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody LabelTypeEntity labelType){
			labelTypeService.updateById(labelType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			labelTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
