package io.renren.modules.app.controller.api;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;

import io.renren.common.utils.R;



/**
 * 文章表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/article")
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;


    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ArticleEntity article){
			articleService.updateById(article);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			articleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
}
