package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mchange.lang.LongUtils;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.PostService;
import io.renren.modules.app.service.impl.AdvcoagentServiceImpl;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.vo.AdminAdvcoVO;
import io.renren.modules.app.vo.AdvcoagentEntityVo;
import io.renren.modules.app.vo.AdvcoagentEntityVos;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.AdvcoagentEntity;
import io.renren.modules.app.service.AdvcoagentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 发布招聘-----找帮手
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:54
 */
@RestController
@RequestMapping("app/advcoagent")
public class AdvcoagentController {
    @Autowired
    private AdvcoagentService advcoagentService;
    @Autowired
    private AreaServiceImpl areaServiceImpl;
    @Autowired
    private AdvcoagentServiceImpl advcoagentServiceImpl;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:advcoagent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = advcoagentService.queryPage(params);
        List<AdvcoagentEntity> list = (List<AdvcoagentEntity>) page.getContent();
        List<AdvcoagentEntityVo> vos = new ArrayList<>();
        list.stream().forEach(a->vos.add(advcoagentServiceImpl.getVo(a)));
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:advcoagent:info")
    public R info(@PathVariable("id") Long id){
			AdvcoagentEntity advcoagent = advcoagentService.selectById(id);
        AdminAdvcoVO adminVo = advcoagentServiceImpl.getAdminVo(advcoagent);
        return R.ok().put("data", adminVo);
    }

    /**
     * my信息
     */
    @RequestMapping("/myinfo/{id}")
//    @RequiresPermissions("app:advcoagent:info")
    public R myinfo(@PathVariable("id") Long id){
        AdvcoagentEntity advcoagent = advcoagentService.selectById(id);
        AdvcoagentEntityVo vo = advcoagentServiceImpl.getAdvcoagentEntityVo(advcoagent);
        return R.ok().put("data", vo);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:advcoagent:save")
    public R save(@RequestBody AdvcoagentEntity advcoagent){
        if (advcoagent.getJobId() == null || advcoagent.getJobId().equals("")){
            return R.error("职位不能为空");
        }
        if (advcoagent.getAreaId() == null || advcoagent.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (advcoagent.getPhone().length() != 11){
            return R.error("手机号应该为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            Matcher matcher = compile.matcher(advcoagent.getPhone());
            boolean matches = matcher.matches();
            if (matches){
                String regEx = "(?!<(img).*?>)<.*?>";
                Pattern p_html = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
                Matcher m_html = p_html.matcher(advcoagent.getRemark());
                String str = m_html.replaceAll("");
                advcoagent.setRemark(str.trim());
                Matcher m_html1 = p_html.matcher(advcoagent.getDepict());
                String str1 = m_html1.replaceAll("");
                advcoagent.setDepict(str1.trim());
                advcoagent.setCreateTime(new Date());
                SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                advcoagent.setUserId(sysUserEntity.getUserId());
                advcoagentService.insert(advcoagent);
                return R.ok();
            }else {
                return R.error("请输入正确的手机格式");
            }
        }

    }

    /**
     * 发布招聘
     */
    @PostMapping("/apisave")
    public R save(@RequestBody AdvcoagentEntityVos advcoagent){
        AdvcoagentEntity advcoagentEntity = new AdvcoagentEntity();
        advcoagentEntity.setCreateTime(new Date());
        advcoagentEntity.setDepict(advcoagent.getDepict());
        advcoagentEntity.setAlterTime(advcoagent.getAlterTime());
        advcoagentEntity.setUserId(advcoagent.getUserId());
        advcoagentEntity.setAddress(advcoagent.getAddress());
        advcoagentEntity.setAdvertiseNumber(advcoagent.getAdvertiseNumber());
        advcoagentEntity.setAgeGroup(advcoagent.getAgeGroup());
        AreaEntity areaEntity = areaServiceImpl.queryByName(advcoagent.getAreaName());
        advcoagentEntity.setAreaId(areaEntity.getAreaCode());
        advcoagentEntity.setCompany(advcoagent.getCompany());
        advcoagentEntity.setExperience(advcoagent.getExperience());
        advcoagentEntity.setJobId(advcoagent.getJobId());
        advcoagentEntity.setPhone(advcoagent.getPhone());
        advcoagentEntity.setPrincipal(advcoagent.getPrincipal());
        advcoagentEntity.setRemark(advcoagent.getRemark());
        advcoagentEntity.setProperty(advcoagent.getProperty());
        advcoagentEntity.setSalary(advcoagent.getSalary());
        advcoagentEntity.setSex(advcoagent.getSex());
        advcoagentEntity.setTitle(advcoagent.getTitle());
        advcoagentService.insert(advcoagentEntity);
        return R.ok();
    }


    /**
     * 我的招聘列表
     */
    @RequestMapping("/mylist")
    public R mylist(@RequestParam Map<String, Object> params){
        PageUtils page = advcoagentService.myqueryPage(params);
        List<AdvcoagentEntity> content = (List<AdvcoagentEntity>) page.getContent();
        List<AdvcoagentEntityVo> vos = new ArrayList<>();
        content.stream().forEach(a->vos.add(advcoagentServiceImpl.getVo(a)));
        page.setContent(vos);
        return R.ok().put("page", page);
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:advcoagent:update")
    public R update(@RequestBody AdvcoagentEntity advcoagent){
        if (advcoagent.getJobId() == null || advcoagent.getJobId().equals("")){
            return R.error("职位不能为空");
        }
        if (advcoagent.getAreaId() == null || advcoagent.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (advcoagent.getPhone().length() != 11){
            return R.error("手机号应该为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            Matcher matcher = compile.matcher(advcoagent.getPhone());
            boolean matches = matcher.matches();
            if (!matches){
                return R.error("请输入正确的手机格式");
            }else {
                advcoagent.setRemark(advcoagent.getRemark().replaceAll("<([^>]*)>", "$1"));
                advcoagent.setDepict(advcoagent.getDepict().replaceAll("<([^>]*)>","$1"));
                advcoagent.setAlterTime(new Date());
                SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                advcoagent.setUserId(sysUserEntity.getUserId());
                advcoagentService.updateById(advcoagent);
                return R.ok();
            }
        }

    }



    /**
     * 更新招聘信息
     */
    @RequestMapping("/myupdate")
    public R myupdate(@RequestBody AdvcoagentEntity advcoagent){
        advcoagent.setRemark(advcoagent.getRemark().replaceAll("<([^>]*)>", "$1"));
        advcoagent.setDepict(advcoagent.getDepict().replaceAll("<([^>]*)>","$1"));
        advcoagent.setAlterTime(new Date());
        advcoagentService.updateById(advcoagent);
        return R.ok("更新成功！");
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:advcoagent:delete")
    public R delete(@RequestBody Long[] ids){
			advcoagentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     *根据用户id和招聘id删除招聘信息
     */
    @DeleteMapping("/deleteByUserId")
    public R selectUserId(@RequestParam Map<String, Object> params){
        advcoagentServiceImpl.deleteByUserId(params);
        return R.ok();
    }

}
