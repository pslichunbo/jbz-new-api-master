package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.FileEntity;
import io.renren.modules.app.service.FileService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 文件表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/file")
public class FileApiController {
    @Autowired
    private FileService fileService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			FileEntity file = fileService.selectById(id);

        return R.ok().put("file", file);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody FileEntity file){
			fileService.insert(file);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody FileEntity file){
			fileService.updateById(file);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			fileService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
