package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.LabelTypeEntity;
import io.renren.modules.app.entity.MerchantEntity;
import io.renren.modules.app.service.LabelTypeService;
import io.renren.modules.app.service.MerchantService;
import io.renren.modules.app.vo.LabelEntityVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private LabelTypeService labelTypeService;


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:label:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = labelService.queryPage(params);
        List<LabelEntity> content = (List<LabelEntity>) page.getContent();
        List<LabelEntityVo> list = new ArrayList<>();
        for(LabelEntity s : content){
            LabelEntityVo vo = new LabelEntityVo();
            MerchantEntity merchantEntity = merchantService.selectById(s.getMerchantId());
            if(merchantEntity == null){
                return R.error("数据查询错误！");
            }
            LabelTypeEntity labelTypeEntity = labelTypeService.selectById(s.getTypeId());
            if(labelTypeEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setName(s.getName());
            vo.setDescription(s.getDescription());
            vo.setTypeName(labelTypeEntity.getName());
            vo.setDelSign(s.getDelSign());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setState(s.getState());
            vo.setMerchantName(merchantEntity.getName());
            list.add(vo);

        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:label:info")
    public R info(@PathVariable("id") Long id){
			LabelEntity label = labelService.selectById(id);

        return R.ok().put("data", label);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:label:save")
    public R save(@RequestBody LabelEntity label){
            label.setCreateTime(new Date());
			labelService.insert(label);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:label:update")
    public R update(@RequestBody LabelEntity label){
			labelService.updateById(label);

        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:label:delete")
    public R delete(@RequestBody Long[] ids){
			labelService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
