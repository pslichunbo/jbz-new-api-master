package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.renren.modules.app.service.CommonService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.SlideShowEntity;
import io.renren.modules.app.service.SlideShowService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 轮播图
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("app/slideshow")
public class SlideShowController {
    @Autowired
    private SlideShowService slideShowService;


    @Autowired
    private CommonService commonServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = slideShowService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			SlideShowEntity slideShow = slideShowService.selectById(id);

        return R.ok().put("data", slideShow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SlideShowEntity s){
        if (s.getSlideShowUrl().equals("[]") || s.getSlideShowUrl() == null){
            return R.error("不能上传空图片");
        }
        s.setSlideShowUrl(s.getSlideShowUrl().replaceAll("[\\[\\]\\\"]", ""));
        s.setCreateTime(new Date());
		slideShowService.insert(s);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SlideShowEntity slideShow){
			slideShowService.updateById(slideShow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			slideShowService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
