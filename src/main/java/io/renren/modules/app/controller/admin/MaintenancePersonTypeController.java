package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.service.impl.MaintenancePersonTypeServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenancePersonTypeEntity;
import io.renren.modules.app.service.MaintenancePersonTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修人类型
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-30 11:37:39
 */
@RestController
@RequestMapping("app/maintenancepersontype")
public class MaintenancePersonTypeController {
    @Autowired
    private MaintenancePersonTypeService maintenancePersonTypeService;

    @Autowired
    private MaintenancePersonTypeServiceImpl maintenancePersonTypeServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenancePersonTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MaintenancePersonTypeEntity maintenancePersonType = maintenancePersonTypeService.selectById(id);

        return R.ok().put("data", maintenancePersonType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaintenancePersonTypeEntity maintenancePersonType){
            maintenancePersonType.setCreateTime(new Date());
			maintenancePersonTypeService.insert(maintenancePersonType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaintenancePersonTypeEntity maintenancePersonType){
			maintenancePersonTypeService.updateById(maintenancePersonType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			maintenancePersonTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     *查询所有类型
     */
    @GetMapping("/allTypes")
    public R queryAllTypes(){


        List<MaintenancePersonTypeEntity> maintenancePersonTypeEntities = maintenancePersonTypeServiceImpl.selectAll();
        return R.ok().put("data",maintenancePersonTypeEntities);
    }

}
