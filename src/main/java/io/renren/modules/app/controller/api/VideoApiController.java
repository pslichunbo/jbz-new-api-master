package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.VideoEntity;
import io.renren.modules.app.service.VideoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 视频表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("aul/video")
public class VideoApiController {
    @Autowired
    private VideoService videoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 根据视频ID类型查询视频
     */
    @GetMapping("/typeid")
    public R typeid(@RequestParam Map<String, Object> params){
        PageUtils page = videoService.queryPageid(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			VideoEntity video = videoService.selectById(id);

        return R.ok().put("video", video);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody VideoEntity video){
            SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
            video.setUserId(userEntity.getUserId());
            video.setCreateTime(new Date());
			videoService.insert(video);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody VideoEntity video){
            video.setAlterTime(new Date());
			videoService.updateById(video);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			videoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
