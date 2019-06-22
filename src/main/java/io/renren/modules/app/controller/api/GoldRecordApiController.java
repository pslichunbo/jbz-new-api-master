package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.GoldRecordEntity;
import io.renren.modules.app.service.GoldRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 金币记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/goldrecord")
public class GoldRecordApiController {
    @Autowired
    private GoldRecordService goldRecordService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goldRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			GoldRecordEntity goldRecord = goldRecordService.selectById(id);

        return R.ok().put("goldRecord", goldRecord);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody GoldRecordEntity goldRecord){
			goldRecordService.insert(goldRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody GoldRecordEntity goldRecord){
			goldRecordService.updateById(goldRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			goldRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
