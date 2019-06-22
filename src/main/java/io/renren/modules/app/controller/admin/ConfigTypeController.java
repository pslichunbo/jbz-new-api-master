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

import io.renren.modules.app.entity.ConfigTypeEntity;
import io.renren.modules.app.service.ConfigTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-22 16:24:53
 */
@RestController
@RequestMapping("app/configtype")
public class ConfigTypeController {
    @Autowired
    private ConfigTypeService configTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:configtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = configTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:configtype:info")
    public R info(@PathVariable("id") Long id){
			ConfigTypeEntity configType = configTypeService.selectById(id);

        return R.ok().put("configType", configType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:configtype:save")
    public R save(@RequestBody ConfigTypeEntity configType){
			configTypeService.insert(configType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:configtype:update")
    public R update(@RequestBody ConfigTypeEntity configType){
			configTypeService.updateById(configType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:configtype:delete")
    public R delete(@RequestBody Long[] ids){
			configTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
