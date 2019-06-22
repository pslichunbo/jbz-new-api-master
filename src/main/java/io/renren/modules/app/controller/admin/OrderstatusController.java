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

import io.renren.modules.app.entity.OrderstatusEntity;
import io.renren.modules.app.service.OrderstatusService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 17:50:35
 */
@RestController
@RequestMapping("app/orderstatus")
public class OrderstatusController {
    @Autowired
    private OrderstatusService orderstatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:orderstatus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderstatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:orderstatus:info")
    public R info(@PathVariable("id") Integer id){
			OrderstatusEntity orderstatus = orderstatusService.selectById(id);

        return R.ok().put("orderstatus", orderstatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:orderstatus:save")
    public R save(@RequestBody OrderstatusEntity orderstatus){
			orderstatusService.insert(orderstatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:orderstatus:update")
    public R update(@RequestBody OrderstatusEntity orderstatus){
			orderstatusService.updateById(orderstatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:orderstatus:delete")
    public R delete(@RequestBody Integer[] ids){
			orderstatusService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
