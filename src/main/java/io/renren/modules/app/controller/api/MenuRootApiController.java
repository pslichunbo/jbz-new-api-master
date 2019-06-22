package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MenuRootEntity;
import io.renren.modules.app.service.MenuRootService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 一级分类表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("api/menuroot")
public class MenuRootApiController {
    @Autowired
    private MenuRootService menuRootService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuRootService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MenuRootEntity menuRoot = menuRootService.selectById(id);

        return R.ok().put("menuRoot", menuRoot);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MenuRootEntity menuRoot){
			menuRootService.insert(menuRoot);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MenuRootEntity menuRoot){
			menuRootService.updateById(menuRoot);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			menuRootService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
