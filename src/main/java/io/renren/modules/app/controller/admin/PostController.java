package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:post:list")
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
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:post:info")
    public R info(@PathVariable("id") Long id){
			PostEntity post = postService.selectById(id);

        return R.ok().put("post", post);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:post:save")
    public R save(@RequestBody PostEntity post){
        post.setCreateTime(new Date());
			postService.insert(post);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:post:update")
    public R update(@RequestBody PostEntity post){
        post.setAlterTime(new Date());
			postService.updateById(post);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:post:delete")
    public R delete(@RequestBody Long[] ids){
			postService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
