package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.OrderstatusEntity;
import io.renren.modules.app.service.OrderstatusService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 17:50:35
 */
@RestController
@RequestMapping("api/orderstatus")
public class OrderstatusApiController {
    @Autowired
    private OrderstatusService orderstatusService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderstatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			OrderstatusEntity orderstatus = orderstatusService.selectById(id);

        return R.ok().put("orderstatus", orderstatus);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody OrderstatusEntity orderstatus){
			orderstatusService.insert(orderstatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody OrderstatusEntity orderstatus){
			orderstatusService.updateById(orderstatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			orderstatusService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
