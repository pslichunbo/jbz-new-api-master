package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ConversionRecordTypeEntity;
import io.renren.modules.app.service.ConversionRecordTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 兑换记录类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-21 09:21:45
 */
@RestController
@RequestMapping("api/conversionrecordtype")
public class ConversionRecordTypeApiController {
    @Autowired
    private ConversionRecordTypeService conversionRecordTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ConversionRecordTypeEntity conversionRecordType = conversionRecordTypeService.selectById(id);

        return R.ok().put("conversionRecordType", conversionRecordType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ConversionRecordTypeEntity conversionRecordType){
			conversionRecordTypeService.insert(conversionRecordType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ConversionRecordTypeEntity conversionRecordType){
			conversionRecordTypeService.updateById(conversionRecordType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			conversionRecordTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
