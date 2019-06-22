package io.renren.modules.app.controller.api;

import java.util.*;

import io.renren.modules.app.entity.LabelEntity;
import io.renren.modules.app.entity.MerchantTypeEntity;
import io.renren.modules.app.service.LabelService;
import io.renren.modules.app.service.MerchantTypeService;
import io.renren.modules.app.service.impl.MerchantServiceImpl;
import io.renren.modules.app.vo.MerchantEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MerchantEntity;
import io.renren.modules.app.service.MerchantService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 信息对象表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/merchant")
public class MerchantApiController {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private MerchantServiceImpl merchantServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = merchantService.queryPageOne(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MerchantEntity merchant = merchantService.selectById(id);

        return R.ok().put("data", merchant);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MerchantEntity merchant){
        merchant.setCreateTime(new Date());
			merchantService.insert(merchant);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MerchantEntity merchant){
        merchant.setAlterTime(new Date());
			merchantService.updateById(merchant);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			merchantService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *信息发布查询接口lyj
     */
    @GetMapping("/selectAll")
    public R queryAll(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = merchantServiceImpl.queryById(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     *根据用户id和类型id查询用户发布信息接口lyj
     */
    @GetMapping("/all")
    public R selectAll(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = merchantServiceImpl.queryAll(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     *删除商家某条信息接口(根据用户id和信息id删除)lyj
     */
    @DeleteMapping("/remove")
    public R deleteById(@RequestParam Map<String, Object> params){
        Long id = Long.parseLong((String)params.get("id"));
        Long userId = Long.parseLong((String)params.get("userId"));
        merchantServiceImpl.removeById(id, userId);
        return R.ok();
    }
}
