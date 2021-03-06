package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.service.impl.LabelTypeServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("app/labeltype")
public class LabelTypeController {
    @Autowired
    private LabelTypeService labelTypeService;
    @Autowired
    private LabelTypeServiceImpl labelTypeServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:labeltype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = labelTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:labeltype:info")
    public R info(@PathVariable("id") Long id){
			LabelTypeEntity labelType = labelTypeService.selectById(id);

        return R.ok().put("data", labelType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:labeltype:save")
    public R save(@RequestBody LabelTypeEntity labelType){
            labelType.setCreateTime(new Date());
			labelTypeService.insert(labelType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:labeltype:update")
    public R update(@RequestBody LabelTypeEntity labelType){
			labelTypeService.updateById(labelType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:labeltype:delete")
    public R delete(@RequestBody Long[] ids){
			labelTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查询出所有标签类型
     */
    @GetMapping("/all")
    public R selectAll(){
        List<LabelTypeEntity> list = labelTypeServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
