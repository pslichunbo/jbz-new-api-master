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

import io.renren.modules.app.entity.MerchantTypeEntity;
import io.renren.modules.app.service.MerchantTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 信息对象类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/merchanttype")
public class MerchantTypeController {
    @Autowired
    private MerchantTypeService merchantTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:merchanttype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = merchantTypeService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:merchanttype:info")
    public R info(@PathVariable("id") Long id){
			MerchantTypeEntity merchantType = merchantTypeService.selectById(id);

        return R.ok().put("data", merchantType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:merchanttype:save")
    public R save(@RequestBody MerchantTypeEntity merchantType){
            merchantType.setCreateTime(new Date());
			merchantTypeService.insert(merchantType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:merchanttype:update")
    public R update(@RequestBody MerchantTypeEntity merchantType){
			merchantTypeService.updateById(merchantType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:merchanttype:delete")
    public R delete(@RequestBody Long[] ids){
			merchantTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
