package io.renren.modules.app.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.PresentTypeEntity;
import io.renren.modules.app.service.PresentTypeService;
import io.renren.modules.app.vo.PresentEntityVo;
import io.renren.modules.app.vo.PresentVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/present")
public class PresentController {
    @Autowired
    private PresentService presentService;


    @Autowired
    private PresentTypeService presentTypeService;

    /**
     * 列表
     */
    @RequestMapping("/listAll")
//    @RequiresPermissions("app:present:list")
    public R listAll(@RequestParam Map<String, Object> params){
        PageUtils page = presentService.queryPageAll(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:present:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = presentService.queryPage(params);
        List<PresentEntity> content = (List<PresentEntity>) page.getContent();
        List<PresentVo> list = new ArrayList<>();
        for(PresentEntity s : content) {
            PresentVo vo = new PresentVo();
            PresentTypeEntity presentTypeEntity = presentTypeService.selectById(s.getTypeId());
            if(presentTypeEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setImageLink(s.getImageLink());
            vo.setPrice(s.getPrice());
            vo.setInventory(s.getInventory());
            vo.setIntro(s.getIntro());
            vo.setImportanceExplain(s.getImportanceExplain());
            vo.setName(presentTypeEntity.getName());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            list.add(vo);

        }
        page.setContent(list);
        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:present:info")
    public R info(@PathVariable("id") Long id){
        PresentEntity present = presentService.selectById(id);
        PresentTypeEntity typeEntity = presentTypeService.selectById(present.getTypeId());
        PresentEntityVo re = new PresentEntityVo(present.getId(),present.getTitle(),present.getImageLink(),
                present.getPrice(),present.getInventory(),present.getIntro(),present.getImportanceExplain(),typeEntity.getName(),present.getDelSign(),
                present.getCreateTime(),present.getAlterTime(),present.getDeleteTime());

        return R.ok().put("present", present);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:present:save")
    public R save(@RequestBody PresentEntity present){
			presentService.insert(present);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:present:update")
    public R update(@RequestBody PresentEntity present){
			presentService.updateById(present);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:present:delete")
    public R delete(@RequestBody Long[] ids){
			presentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
