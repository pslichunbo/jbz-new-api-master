package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ContentColumnEntity;
import io.renren.modules.app.service.ContentColumnService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-20 15:02:48
 */
@RestController
@RequestMapping("api/contentcolumn")
public class ContentColumnApiController {
    @Autowired
    private ContentColumnService contentColumnService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = contentColumnService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			ContentColumnEntity contentColumn = contentColumnService.selectById(id);

        return R.ok().put("contentColumn", contentColumn);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ContentColumnEntity contentColumn){
			contentColumnService.insert(contentColumn);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ContentColumnEntity contentColumn){
			contentColumnService.updateById(contentColumn);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			contentColumnService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
