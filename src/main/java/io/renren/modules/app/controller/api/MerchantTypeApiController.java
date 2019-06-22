package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/merchanttype")
public class MerchantTypeApiController {
    @Autowired
    private MerchantTypeService merchantTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = merchantTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MerchantTypeEntity merchantType = merchantTypeService.selectById(id);

        return R.ok().put("data", merchantType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MerchantTypeEntity merchantType){
        merchantType.setCreateTime(new Date());
			merchantTypeService.insert(merchantType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MerchantTypeEntity merchantType){
			merchantTypeService.updateById(merchantType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			merchantTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
