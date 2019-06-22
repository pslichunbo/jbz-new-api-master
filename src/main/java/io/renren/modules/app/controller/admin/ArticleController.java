package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import io.renren.modules.app.service.impl.ArticleServiceImpl;
import io.renren.modules.app.vo.ArticleVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 文章表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleServiceImpl articleServiceImpl;


    @Autowired
    private SysUserService sysUserService;



    /**
     * 列表
     */
    @GetMapping("/apilist")
    public R aapilist(@RequestParam Map<String, Object> params){
        PageUtils page = articleService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 保存
     */
    @PostMapping("/apisave")
    public R apisave(@RequestBody ArticleEntity article){
        article.setCreateTime(new Date());
        article.setDelSign((long) 0);
        articleService.insert(article);
        return R.ok();
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:article:list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = articleService.queryPage(params);
        List<ArticleEntity> content = (List<ArticleEntity>) page.getContent();
        List<ArticleVo> list = new ArrayList<>();
        content.stream().forEach(a->list.add(articleServiceImpl.getvo(a)));
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/apiinfo/{id}")
    public R apiinfo(@PathVariable("id") Long id){
        ArticleEntity article = articleService.selectById(id);
        return R.ok().put("article", article);
    }




    @RequestMapping("/listOne")
//    @RequiresPermissions("app:article:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = articleService.queryPageOne(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:article:info")
    public R info(@PathVariable("id") Long id){
			ArticleEntity article = articleService.selectById(id);
        ArticleVo getvo = articleServiceImpl.getvo(article);
        return R.ok().put("data", getvo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:article:save")
    public R save(@RequestBody ArticleEntity article){
        article.setCreateTime(new Date());
        article.setContent(article.getContent().replaceAll("<([^>]*)>",""));
        article.setImageLinks(article.getImageLinks().replaceAll("[\\[\\]\\\"]",""));
       articleService.insert(article);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:article:update")
    public R update(@RequestBody ArticleEntity article){
        article.setContent(article.getContent().replaceAll("<([^>]*)>",""));
        article.setImageLinks(article.getImageLinks().replaceAll("[\\[\\]\\\"]",""));
        article.setAlterTime(new Date());
        articleService.updateById(article);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:article:delete")
    public R delete(@RequestBody Long[] ids){
			articleService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}
