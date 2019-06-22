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

import io.renren.modules.app.entity.ConfigEntity;
import io.renren.modules.app.service.ConfigService;
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
@RequestMapping("app/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:config:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = configService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:config:info")
    public R info(@PathVariable("id") Long id){
			ConfigEntity config = configService.selectById(id);

        return R.ok().put("config", config);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:config:save")
    public R save(@RequestBody ConfigEntity config){
			configService.insert(config);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:config:update")
    public R update(@RequestBody ConfigEntity config){
			configService.updateById(config);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:config:delete")
    public R delete(@RequestBody Long[] ids){
			configService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
