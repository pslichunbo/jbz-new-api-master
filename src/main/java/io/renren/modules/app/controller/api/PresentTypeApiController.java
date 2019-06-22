package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/presenttype")
public class PresentTypeApiController {
    @Autowired
    private PresentTypeService presentTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = presentTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			PresentTypeEntity presentType = presentTypeService.selectById(id);

        return R.ok().put("presentType", presentType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PresentTypeEntity presentType){
			presentTypeService.insert(presentType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PresentTypeEntity presentType){
			presentTypeService.updateById(presentType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			presentTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
