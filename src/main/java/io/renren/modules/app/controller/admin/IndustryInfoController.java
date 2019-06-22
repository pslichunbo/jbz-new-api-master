package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.renren.modules.app.form.IndustryInfoForm;
import io.renren.modules.app.service.impl.IndustryInfoServiceImpl;
import io.renren.modules.app.vo.IndustryInfoVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.IndustryInfoEntity;
import io.renren.modules.app.service.IndustryInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 行业信息表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/industryinfo")
public class IndustryInfoController {
    @Autowired
    private IndustryInfoService industryInfoService;
    @Autowired
    private IndustryInfoServiceImpl industryInfoServiceImpl;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:industryinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = industryInfoService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/listOne")
//    @RequiresPermissions("app:industryinfo:list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = industryInfoService.queryPageOne(params);
        List<IndustryInfoEntity> content = (List<IndustryInfoEntity>) page.getContent();
        List<IndustryInfoVo> list = new ArrayList<>();
        for(IndustryInfoEntity s : content){
            IndustryInfoVo vo = new IndustryInfoVo();
            SysUserEntity sysUserEntity = sysUserService.selectById(s.getUserId());
            if (sysUserEntity == null) {
                return R.error("用户信息有误");
            }
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setImageLinks(s.getImageLinks());
            vo.setContent(s.getContent());
            vo.setDelSign(s.getDelSign());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setName(sysUserEntity.getUsername());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("data", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:industryinfo:info")
    public R info(@PathVariable("id") Long id){
			IndustryInfoEntity industryInfo = industryInfoService.selectById(id);
        return R.ok().put("data", industryInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:industryinfo:save")
    public R save(@RequestBody IndustryInfoForm form){
            if (form.getUserId() == null || form.getUserId().equals("")){
                return R.error("用户不能为空");
            }
            if (form.getImageLinks() == null || form.getImageLinks().equals("\"\"")){
                return R.error("图片不能为空");
            }
            IndustryInfoEntity entity = new IndustryInfoEntity();
            entity.setImageLinks(form.getImageLinks().replaceAll("[\\[\\]\\\"]",""));
            entity.setContent(form.getContent().replaceAll("</?[^<]+>",""));
            entity.setCreateTime(new Date());
            entity.setDelSign(form.getDellSign());
            entity.setTitle(form.getTitle());
            entity.setUserId(form.getUserId());
			industryInfoService.insert(entity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:industryinfo:update")
    public R update(@RequestBody IndustryInfoEntity industryInfo){
        if (industryInfo.getUserId() == null || industryInfo.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (industryInfo.getImageLinks() == null || industryInfo.getImageLinks().equals("\"\"")){
            return R.error("图片不能为空");
        }
        industryInfo.setImageLinks(industryInfo.getImageLinks().replaceAll("[\\[\\]\\\"]",""));
        industryInfo.setContent(industryInfo.getContent().replaceAll("<([^>]*)>",""));    //todo 无法过滤可以替换为此方法
        industryInfo.setAlterTime(new Date());
        industryInfoService.updateById(industryInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:industryinfo:delete")
    public R delete(@RequestBody Long[] ids){
			industryInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *根据用户id和行业id删除行业lyj
     */
    @DeleteMapping("/remove")
    public R deleteByUserId(@RequestParam Map<String, Object> params){
        industryInfoServiceImpl.removeByUserId(params);
        return R.ok();
    }
}
