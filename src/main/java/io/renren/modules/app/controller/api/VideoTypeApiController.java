package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.service.impl.VideoTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("api/videotype")
public class VideoTypeApiController {
    @Autowired
    private VideoTypeService videoTypeService;

    @Autowired
    private VideoTypeServiceImpl videoTypeServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			VideoTypeEntity videoType = videoTypeService.selectById(id);

        return R.ok().put("videoType", videoType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody VideoTypeEntity videoType){
			videoTypeService.insert(videoType);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody VideoTypeEntity videoType){
			videoTypeService.updateById(videoType);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			videoTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    @GetMapping("/all")
    public R selectAll(){
        List<VideoTypeEntity> videoTypeEntities = videoTypeServiceImpl.queryALL();
        return R.ok().put("data",videoTypeEntities);
    }

}
