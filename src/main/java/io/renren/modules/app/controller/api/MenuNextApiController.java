package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.MenuRootEntity;
import io.renren.modules.app.service.impl.MenuNextServiceImpl;
import io.renren.modules.app.service.impl.MenuRootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.MenuNextService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 二级分类表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("api/menunext")
public class MenuNextApiController {
    @Autowired
    private MenuNextService menuNextService;

    @Autowired
    private MenuNextServiceImpl menuNextServiceImpl;

    @Autowired
    private MenuRootServiceImpl menuRootServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuNextService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MenuNextEntity menuNext = menuNextService.selectById(id);

        return R.ok().put("menuNext", menuNext);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MenuNextEntity menuNext){
			menuNextService.insert(menuNext);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MenuNextEntity menuNext){
			menuNextService.updateById(menuNext);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			menuNextService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     *获取所有二级列表
     */
    @GetMapping("/all")
    public R selectAll(){
        List<MenuNextEntity> menuNextEntities = menuNextServiceImpl.queryAll();
        return R.ok().put("data",menuNextEntities);
    }


}
