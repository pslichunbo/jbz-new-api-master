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
@RequestMapping("app/goldrecordtype")
public class GoldRecordTypeController {

    @Autowired
    private GoldRecordTypeService goldRecordTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:goldrecordtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goldRecordTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:goldrecordtype:info")
    public R info(@PathVariable("id") Long id){
			GoldRecordTypeEntity goldRecordType = goldRecordTypeService.selectById(id);

        return R.ok().put("data", goldRecordType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:goldrecordtype:save")
    public R save(@RequestBody GoldRecordTypeEntity goldRecordType){
            goldRecordType.setCreateTime(new Date());
			goldRecordTypeService.insert(goldRecordType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:goldrecordtype:update")
    public R update(@RequestBody GoldRecordTypeEntity goldRecordType){
			goldRecordTypeService.updateById(goldRecordType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:goldrecordtype:delete")
    public R delete(@RequestBody Long[] ids){
			goldRecordTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
