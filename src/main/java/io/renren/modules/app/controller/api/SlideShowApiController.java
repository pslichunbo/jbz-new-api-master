package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.renren.modules.app.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/slideshow")
public class SlideShowApiController {
    @Autowired
    private SlideShowService slideShowService;


    @Autowired
    private CommonService commonServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = slideShowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			SlideShowEntity slideShow = slideShowService.selectById(id);

        return R.ok().put("slideShow", slideShow);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestParam("file") MultipartFile url){
        String suffix = url.getOriginalFilename().substring(url.getOriginalFilename().lastIndexOf("."));
        R r = commonServiceImpl.fileUpload(url);
        String name = url.getOriginalFilename();
        String img = (String)r.get("data");
        String[] split = img.split(",");
        HashMap re = new HashMap<String, String>();
        re.put("name",name);
        re.put("url",split[0]);
        SlideShowEntity slideShow = new SlideShowEntity();
        slideShow.setSlideShowUrl(split[0]);
        slideShow.setCreateTime(new Date());
        slideShowService.insert(slideShow);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody SlideShowEntity slideShow){
			slideShowService.updateById(slideShow);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			slideShowService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
