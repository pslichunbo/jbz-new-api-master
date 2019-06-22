package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.PresentTypeEntity;
import io.renren.modules.app.service.PresentTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 礼品类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/presenttype")
public class PresentTypeController {
    @Autowired
    private PresentTypeService presentTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:presenttype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = presentTypeService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/find")
//    @RequiresPermissions("app:presenttype:list")
    public R find(){
        List<PresentTypeEntity> data = presentTypeService.find();

        return R.ok().put("data", data);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:presenttype:info")
    public R info(@PathVariable("id") Long id){
			PresentTypeEntity presentType = presentTypeService.selectById(id);

        return R.ok().put("presenttype", presentType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:presenttype:save")
    public R save(@RequestBody PresentTypeEntity presentType){
        presentType.setCreateTime(new Date());
			presentTypeService.insert(presentType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:presenttype:update")
    public R update(@RequestBody PresentTypeEntity presentType){
			presentTypeService.updateById(presentType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:presenttype:delete")
    public R delete(@RequestBody Long[] ids){
			presentTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
