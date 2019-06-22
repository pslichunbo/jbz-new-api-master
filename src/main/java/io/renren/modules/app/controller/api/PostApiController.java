package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.PostService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-24 10:30:16
 */
@RestController
@RequestMapping("api/post")
public class PostApiController {
    @Autowired
    private PostService postService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = postService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 所有的职位列表
     */
    @RequestMapping("/allList")
    public R Postlist(){
        List<PostEntity> query = postService.query();
        return R.ok().put("data", query);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			PostEntity post = postService.selectById(id);
        return R.ok().put("post", post);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PostEntity post){
			postService.insert(post);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PostEntity post){
			postService.updateById(post);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			postService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
