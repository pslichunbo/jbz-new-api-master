package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.app.service.impl.ConversionRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ConversionRecordEntity;
import io.renren.modules.app.service.ConversionRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 兑换记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("api/conversionrecord")
public class ConversionRecordApiController {
    @Autowired
    private ConversionRecordService conversionRecordService;
    @Autowired
    private ConversionRecordServiceImpl conversionRecordServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ConversionRecordEntity conversionRecord = conversionRecordService.selectById(id);

        return R.ok().put("conversionRecord", conversionRecord);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ConversionRecordEntity conversionRecord){
			conversionRecordService.insert(conversionRecord);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ConversionRecordEntity conversionRecord){
			conversionRecordService.updateById(conversionRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			conversionRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *根据用户id分页查询兑换记录表lyj
     */
    @GetMapping("/queryById")
    public R selectById(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordServiceImpl.queryByUserId(params);
        return R.ok().put("data",page);
    }

}
