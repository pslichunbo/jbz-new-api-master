package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.modules.app.service.impl.MaintenanceStoreTypeServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;
import io.renren.modules.app.service.MaintenanceStoreTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修店类型
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-30 11:37:39
 */
@RestController
@RequestMapping("app/maintenancestoretype")

public class MaintenanceStoreTypeController {
    @Autowired
    private MaintenanceStoreTypeService maintenanceStoreTypeService;

    @Autowired

    private MaintenanceStoreTypeServiceImpl maintenanceStoreTypeServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:maintenancestoretype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenanceStoreTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:maintenancestoretype:info")
    public R info(@PathVariable("id") Long id){
			MaintenanceStoreTypeEntity maintenanceStoreType = maintenanceStoreTypeService.selectById(id);

        return R.ok().put("data", maintenanceStoreType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:maintenancestoretype:save")
    public R save(@RequestBody MaintenanceStoreTypeEntity maintenanceStoreType){
            maintenanceStoreType.setCreateTime(new Date());
            maintenanceStoreType.setStatus(0L);
			maintenanceStoreTypeService.insert(maintenanceStoreType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaintenanceStoreTypeEntity maintenanceStoreType){
			maintenanceStoreTypeService.updateById(maintenanceStoreType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:maintenancestoretype:delete")
    public R delete(@RequestBody Long[] ids){
			maintenanceStoreTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     *查询所有类型
     */
    @GetMapping("/allTypes")
    public R queryAllType(){


        return R.ok().put("data",maintenanceStoreTypeServiceImpl.selectAll());
    }

}
