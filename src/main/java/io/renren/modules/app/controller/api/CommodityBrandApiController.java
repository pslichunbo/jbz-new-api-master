package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.app.service.impl.CommodityBrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.CommodityBrandEntity;
import io.renren.modules.app.service.CommodityBrandService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品品牌表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/commoditybrand")
public class CommodityBrandApiController {
    @Autowired
    private CommodityBrandService commodityBrandService;
    @Autowired
    private CommodityBrandServiceImpl commodityBrandServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commodityBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			CommodityBrandEntity commodityBrand = commodityBrandService.selectById(id);

        return R.ok().put("commodityBrand", commodityBrand);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CommodityBrandEntity commodityBrand){
			commodityBrandService.insert(commodityBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody CommodityBrandEntity commodityBrand){
			commodityBrandService.updateById(commodityBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			commodityBrandService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     *获取品牌的所有接口如果不传typeid则查询所有的品牌lyj
     */
    @GetMapping("/queryByTypeId")
    public R selectByTypeId(@RequestParam Map<String, Object> params) {
        String typeId = params.get("typeId").toString();
        if (typeId.equals("0") || typeId.equals("")) {
            //查询所有
            PageUtils pageUtils = commodityBrandServiceImpl.queryAll(params);
            return R.ok().put("data",pageUtils);
        }else{
            PageUtils pageUtils = commodityBrandServiceImpl.queryByTypeId(params);
            return R.ok().put("data",pageUtils);
        }
    }

}
