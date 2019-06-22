package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/conversionrecordtype")
public class ConversionRecordTypeController {
    @Autowired
    private ConversionRecordTypeService conversionRecordTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:conversionrecordtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:conversionrecordtype:info")
    public R info(@PathVariable("id") Long id){
			ConversionRecordTypeEntity conversionRecordType = conversionRecordTypeService.selectById(id);

        return R.ok().put("data", conversionRecordType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:conversionrecordtype:save")
    public R save(@RequestBody ConversionRecordTypeEntity conversionRecordType){
			conversionRecordTypeService.insert(conversionRecordType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:conversionrecordtype:update")
    public R update(@RequestBody ConversionRecordTypeEntity conversionRecordType){
			conversionRecordTypeService.updateById(conversionRecordType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:conversionrecordtype:delete")
    public R delete(@RequestBody Long[] ids){
			conversionRecordTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
