package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.GoldRecordTypeEntity;
import io.renren.modules.app.service.GoldRecordTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 金币类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/goldrecordtype")
public class GoldRecordTypeApiController {
    @Autowired
    private GoldRecordTypeService goldRecordTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goldRecordTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			GoldRecordTypeEntity goldRecordType = goldRecordTypeService.selectById(id);

        return R.ok().put("goldRecordType", goldRecordType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody GoldRecordTypeEntity goldRecordType){
			goldRecordTypeService.insert(goldRecordType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody GoldRecordTypeEntity goldRecordType){
			goldRecordTypeService.updateById(goldRecordType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			goldRecordTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
