package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.VideoTypeEntity;
import io.renren.modules.app.service.VideoTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 视频类型表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("app/videotype")
public class VideoTypeController {
    @Autowired
    private VideoTypeService videoTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:videotype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/findAll")
    public R listAll(){
        List<VideoTypeEntity> page = videoTypeService.queryALL();
        return R.ok().put("data", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:videotype:info")
    public R info(@PathVariable("id") Long id){
			VideoTypeEntity videoType = videoTypeService.selectById(id);

        return R.ok().put("videoType", videoType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:videotype:save")
    public R save(@RequestBody VideoTypeEntity videoType){
        videoType.setCreateTime(new Date());
        videoTypeService.insert(videoType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:videotype:update")
    public R update(@RequestBody VideoTypeEntity videoType){
			videoTypeService.updateById(videoType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:videotype:delete")
    public R delete(@RequestBody Long[] ids){
			videoTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
