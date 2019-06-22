package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.CommodityBrandTypeEntity;
import io.renren.modules.app.service.CommodityBrandTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品品牌类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/commoditybrandtype")
public class CommodityBrandTypeApiController {
    @Autowired
    private CommodityBrandTypeService commodityBrandTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commodityBrandTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			CommodityBrandTypeEntity commodityBrandType = commodityBrandTypeService.selectById(id);

        return R.ok().put("commodityBrandType", commodityBrandType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CommodityBrandTypeEntity commodityBrandType){
			commodityBrandTypeService.insert(commodityBrandType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody CommodityBrandTypeEntity commodityBrandType){
			commodityBrandTypeService.updateById(commodityBrandType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			commodityBrandTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
