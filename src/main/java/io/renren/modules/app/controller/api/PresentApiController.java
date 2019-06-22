package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.app.entity.PresentTypeEntity;
import io.renren.modules.app.service.PresentTypeService;
import io.renren.modules.app.vo.PresentEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.app.service.PresentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;




/**
 * 礼品表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/present")
public class PresentApiController {
    @Autowired
    private PresentService presentService;

    @Autowired
    private PresentTypeService presentTypeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = presentService.queryPageAll(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){

        PresentEntity present = presentService.selectById(id);
        PresentTypeEntity typeEntity = presentTypeService.selectById(present.getTypeId());
        PresentEntityVo re = new PresentEntityVo(present.getId(),present.getTitle(),present.getImageLink(),
                present.getPrice(),present.getInventory(),present.getIntro(),present.getImportanceExplain(),typeEntity.getName(),present.getDelSign(),
                present.getCreateTime(),present.getAlterTime(),present.getDeleteTime());
        return R.ok().put("present", re);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PresentEntity present){
			presentService.insert(present);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PresentEntity present){
			presentService.updateById(present);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			presentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
