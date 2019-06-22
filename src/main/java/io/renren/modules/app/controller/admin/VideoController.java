package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.VideoTypeEntity;
import io.renren.modules.app.service.VideoTypeService;
import io.renren.modules.app.vo.VideoVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("app/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoTypeService videoTypeService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:video:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoService.queryPage(params);
        List<VideoEntity> content = (List<VideoEntity>) page.getContent();
        List<VideoVo> list = new ArrayList<>();
        for(VideoEntity s : content){
            VideoVo vo =   new VideoVo();
            SysUserEntity sysUserEntity = sysUserService.selectById(s.getUserId());
            if(sysUserEntity == null){
                return R.error("数据查询错误！");
            }
            VideoTypeEntity videoTypeEntity = videoTypeService.selectById(s.getTypeId());
            if(videoTypeEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setVideoName(s.getVideoName());
            vo.setVideoInfo(s.getVideoInfo());
            vo.setTypeName(videoTypeEntity.getName());
            vo.setVideoUrl(s.getVideoUrl());
            vo.setUrlPath(s.getUrlPath());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sysUserEntity.getUsername());
            vo.setImage(s.getImage());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 查看某个类型视频
     */
    @RequestMapping("/infoType")
    public R infoType(@RequestParam Map<String, Object> params){
        PageUtils video = videoService.queryPageid(params);

        return R.ok().put("video", video);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:video:info")
    public R info(@PathVariable("id") Long id){
			VideoEntity video = videoService.selectById(id);

        return R.ok().put("video", video);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:video:save")
    public R save(@RequestBody VideoEntity video){
        if (video.getTypeId() == null || video.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (video.getUserId() == null || video.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (video.getImage() == null || video.getImage().equals("\"\"")){
            return R.error("封面图不能为空");
        }
        if (video.getVideoUrl() == null || video.getVideoUrl().equals("\"\"")){
            return R.error("视频不能为空");
        }
        video.setVideoUrl(video.getVideoUrl().replaceAll("[\\[\\]\\\"]",""));
        video.setImage(video.getImage().replaceAll("[\\[\\]\\\"]",""));
        video.setVideoInfo(video.getVideoInfo().replaceAll("<([^>]*)>",""));
        video.setCreateTime(new Date());
        videoService.insert(video);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:video:update")
    public R update(@RequestBody VideoEntity video){
        if (video.getTypeId() == null || video.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (video.getUserId() == null || video.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (video.getImage() == null || video.getImage().equals("\"\"")){
            return R.error("封面图不能为空");
        }
        if (video.getVideoUrl() == null || video.getVideoUrl().equals("["+"]")){
            return R.error("视频不能为空");
        }
        video.setVideoUrl(video.getVideoUrl().replaceAll("[\\[\\]\\\"]",""));
        video.setUrlPath(video.getVideoUrl().replaceAll("[\\[\\]\\\"]",""));
        video.setImage(video.getImage().replaceAll("[\\[\\]\\\"]",""));
        video.setVideoInfo(video.getVideoInfo().replaceAll("<([^>]*)>","$1"));
        video.setAlterTime(new Date());
		videoService.updateById(video);
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:video:delete")
    public R delete(@RequestBody Long[] ids){
			videoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
