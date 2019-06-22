package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

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
@RequestMapping("api/maintenancestoretype")
public class MaintenanceStoreTypeApiController {
    @Autowired
    private MaintenanceStoreTypeService maintenanceStoreTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenanceStoreTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MaintenanceStoreTypeEntity maintenanceStoreType = maintenanceStoreTypeService.selectById(id);

        return R.ok().put("maintenanceStoreType", maintenanceStoreType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MaintenanceStoreTypeEntity maintenanceStoreType){
			maintenanceStoreTypeService.insert(maintenanceStoreType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MaintenanceStoreTypeEntity maintenanceStoreType){
			maintenanceStoreTypeService.updateById(maintenanceStoreType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			maintenanceStoreTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
