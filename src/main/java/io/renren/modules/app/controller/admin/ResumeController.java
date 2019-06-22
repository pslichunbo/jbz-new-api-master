package io.renren.modules.app.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.ResumeTypeEntity;
import io.renren.modules.app.service.ResumeTypeService;
import io.renren.modules.app.service.impl.ResumeTypeServiceImpl;
import io.renren.modules.app.vo.ResumeVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ResumeEntity;
import io.renren.modules.app.service.ResumeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@RestController
@RequestMapping("app/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ResumeTypeServiceImpl resumeTypeServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:resume:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeService.queryPage(params);
        List<ResumeEntity> content = (List<ResumeEntity>) page.getContent();
        List<ResumeVo> list = new ArrayList<>();
        for (ResumeEntity r : content){
            ResumeVo vo = new ResumeVo();
            ResumeTypeEntity resumeTypeEntity = resumeTypeServiceImpl.selectById(r.getTypeId());
            if(resumeTypeEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setAddress(r.getAddress());
            vo.setDescribe(r.getDescribe());
            vo.setId(r.getId());
            vo.setLinkMan(r.getLinkMan());
            vo.setLinkNumber(r.getLinkNumber());
            vo.setName(r.getName());
            vo.setPhone(r.getPhone());
            vo.setPortrait(r.getPortrait());
            vo.setRemark(r.getRemark());
            vo.setPosition(r.getPosition());
            vo.setSex(r.getSex());
            vo.setStatus(r.getStatus());
            vo.setTitle(r.getTitle());
            vo.setTreatment(r.getTreatment());
            vo.setTypeName(resumeTypeEntity.getName());
            vo.setWorkAddress(r.getWorkAddress());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:resume:info")
    public R info(@PathVariable("id") Long id){
			ResumeEntity resume = resumeService.selectById(id);

        return R.ok().put("resume", resume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:resume:save")
    public R save(@RequestBody ResumeEntity resume){
			resumeService.insert(resume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:resume:update")
    public R update(@RequestBody ResumeEntity resume){
			resumeService.updateById(resume);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:resume:delete")
    public R delete(@RequestBody Long[] ids){
			resumeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查询所有类型
     */
    @GetMapping("/allType")
    public R selectAllType(){
        return R.ok().put("data",resumeTypeServiceImpl.queryAll());
    }
}
