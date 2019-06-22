package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/configtype")
public class ConfigTypeApiController {
    @Autowired
    private ConfigTypeService configTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = configTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ConfigTypeEntity configType = configTypeService.selectById(id);

        return R.ok().put("configType", configType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ConfigTypeEntity configType){
			configTypeService.insert(configType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ConfigTypeEntity configType){
			configTypeService.updateById(configType);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			configTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
