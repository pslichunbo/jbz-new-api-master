package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/commoditybrandtype")
public class CommodityBrandTypeController {
    @Autowired
    private CommodityBrandTypeService commodityBrandTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:commoditybrandtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commodityBrandTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:commoditybrandtype:info")
    public R info(@PathVariable("id") Long id){
			CommodityBrandTypeEntity commodityBrandType = commodityBrandTypeService.selectById(id);

        return R.ok().put("data", commodityBrandType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:commoditybrandtype:save")
    public R save(@RequestBody CommodityBrandTypeEntity commodityBrandType){
            commodityBrandType.setCreateTime(new Date());
			commodityBrandTypeService.insert(commodityBrandType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:commoditybrandtype:update")
    public R update(@RequestBody CommodityBrandTypeEntity commodityBrandType){
			commodityBrandTypeService.updateById(commodityBrandType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:commoditybrandtype:delete")
    public R delete(@RequestBody Long[] ids){
			commodityBrandTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
