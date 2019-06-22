package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.service.impl.LabelServiceImpl;
import io.renren.modules.app.vo.LabelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.LabelEntity;
import io.renren.modules.app.service.LabelService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 标签表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/label")
public class LabelApiController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private LabelServiceImpl labelServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = labelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			LabelEntity label = labelService.selectById(id);

        return R.ok().put("label", label);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody LabelEntity label){
			labelService.insert(label);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody LabelEntity label){
			labelService.updateById(label);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			labelService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *标签描述接口lyj
     */
    @GetMapping("/all")
    public R queryAll(){
        List<LabelVo> labelVo = labelServiceImpl.selectAll();
        return R.ok().put("data",labelVo);
    }

}
