package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.PropertyEntity;
import io.renren.modules.app.service.PropertyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 属性
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("au/property")
public class PropertyApiController {
    @Autowired
    private PropertyService propertyService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = propertyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			PropertyEntity property = propertyService.selectById(id);

        return R.ok().put("property", property);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PropertyEntity property){
			propertyService.insert(property);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PropertyEntity property){
			propertyService.updateById(property);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			propertyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
