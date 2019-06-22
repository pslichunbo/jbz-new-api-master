package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.PostService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.SeekerServiceImpl;
import io.renren.modules.app.vo.AdvcoagentEntityVo;
import io.renren.modules.app.vo.AppSeekerEntityVo;
import io.renren.modules.app.vo.SeekerEntityAppVo;
import io.renren.modules.app.vo.SeekerEntityVo;
import io.renren.modules.sys.dao.SysUserTokenDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.SeekerEntity;
import io.renren.modules.app.service.SeekerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.annotation.Resource;


/**
 * 求职者简历----找帮手
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:55
 */
@RestController
@RequestMapping("app/seeker")
public class SeekerController {
    @Autowired
    private SeekerService seekerService;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Resource
    private SysUserTokenDao tokenDao;


    @Autowired
    private SeekerServiceImpl seekerServiceImpl;

    @Autowired
    private PostService postService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AreaService areaService;



    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:seeker:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seekerService.queryPage(params);
        List<SeekerEntity> content = (List<SeekerEntity>) page.getContent();
        List<SeekerEntityAppVo> list = new ArrayList<>();
        for (SeekerEntity s : content){
            SeekerEntityAppVo vo = new SeekerEntityAppVo();
            vo.setSalary(s.getSalary());
            vo.setSex(s.getSex());
            vo.setPhoto(s.getPhoto());
            vo.setPhone(s.getPhone());
            String[] split1 = s.getPortrait().replaceAll("[\\[\\]\\\"]", "").split(",");
            vo.setPortrait(split1[0]);
            vo.setName(s.getName());
            PostEntity postEntity = postService.selectById(s.getJobId());
            vo.setJob(postEntity.getName());
            vo.setId(s.getId());
            vo.setExperience(s.getExperience());
            String depict = s.getDepict();
            Pattern compile = Pattern.compile("<p.*?>(.*?)</p>");
            Matcher matcher = compile.matcher(depict);
            while (matcher.find()){
                String group = matcher.group(1);
                vo.setDepict(group);
            }
            vo.setCreateTime(s.getCreateTime());
            vo.setBirthday(s.getBirthday());
            Long areaId = s.getAreaId();
            AreaEntity areaEntity = areaServiceImpl.selectById(areaId);
            vo.setAreaName(areaEntity.getTreeNames());
            vo.setAlterTime(s.getAlterTime());
            vo.setSpecialty(s.getSpecialty());
            list.add(vo);
        }
        page.setContent(list);


        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:seeker:info")
    public R info(@PathVariable("id") Long id){
		SeekerEntity seeker = seekerService.selectById(id);
        SeekerEntityVo vo = new SeekerEntityVo();
        vo.setAlterTime(seeker.getAlterTime());
        AreaEntity areaEntity = areaServiceImpl.selectById(seeker.getAreaId());
        vo.setAreaName(areaEntity.getAreaName());
        vo.setBirthday(seeker.getBirthday());
        vo.setCreateTime(seeker.getCreateTime());
        vo.setDepict(seeker.getDepict());
        vo.setExperience(seeker.getExperience());
        vo.setId(seeker.getId());
        PostEntity postEntity = postService.selectById(seeker.getJobId());
        vo.setJob(postEntity.getName());
        vo.setName(seeker.getName());
        vo.setPhone(seeker.getPhone());
        String[] split = seeker.getPhoto()
                .replaceAll("[\\[\\]\\\"]", "")
                .split(",");
        vo.setPhoto(split);
        vo.setPortrait(seeker.getPortrait());
        vo.setSalary(seeker.getSalary());
        vo.setSex(seeker.getSex());
        vo.setSpecialty(seeker.getSpecialty());
        vo.setJobId(seeker.getJobId());
        vo.setAreaId(seeker.getAreaId());
        vo.setCityId(Long.parseLong(areaService.selectById(vo.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        return R.ok().put("data", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:seeker:save")
    public R save(@RequestBody SeekerEntity seeker){
            if (seeker.getAreaId() == null || seeker.getAreaId().equals("")){
                return R.error("地区不能为空");
            }
            if (seeker.getJobId() == null || seeker.getJobId().equals("")){
                return R.error("职位不能为空");
            }
            if (seeker.getPhoto() == null || seeker.getPhoto().equals("\"\"")){
                return R.error("证书不能为空");
            }
            if (seeker.getPortrait() == null || seeker.getPortrait().equals("")){
                return R.error("头像不能为空");
            }
            if (seeker.getPhone().length() != 11){
                return R.error("手机号必须为11位");
            }else {
                boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(seeker.getPhone()).matches();
                if (matches){
                    SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                    seeker.setUserId(userEntity.getUserId());
                    seeker.setPhoto(seeker.getPhoto().replaceAll("[\\[\\]\\\"]",""));
                    seeker.setPortrait(seeker.getPortrait().replaceAll("[\\[\\]\\\"]",""));
                    seeker.setDepict(seeker.getDepict().replaceAll("<([^>]*)>",""));
                    seeker.setCreateTime(new Date());
                    seekerService.insert(seeker);
                    return R.ok();
                }else {
                    return R.error("手机号格式不正确");
                }
            }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:seeker:update")
    public R update(@RequestBody SeekerEntity seeker){
        if (seeker.getAreaId() == null || seeker.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (seeker.getJobId() == null || seeker.getJobId().equals("")){
            return R.error("职位不能为空");
        }
        if (seeker.getPhoto() == null || seeker.getPhoto().equals("\"\"")){
            return R.error("证书不能为空");
        }
        if (seeker.getPortrait() == null || seeker.getPortrait().equals("")){
            return R.error("头像不能为空");
        }
        if (seeker.getPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(seeker.getPhone()).matches();
            if (matches){
                seeker.setPhoto(seeker.getPhoto().replaceAll("[\\[\\]\\\"]",""));
                seeker.setPortrait(seeker.getPortrait().replaceAll("[\\[\\]\\\"]",""));
                seeker.setDepict(seeker.getDepict().replaceAll("<([^>]*)>",""));
                seeker.setAlterTime(new Date());
                SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                seeker.setUserId(sysUserEntity.getUserId());
                seekerService.updateById(seeker);
                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:seeker:delete")
    public R delete(@RequestBody Long[] ids){
			seekerService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 发布简历(更新)
     */
    @PostMapping("/apisave")
    public R apisave(@RequestBody SeekerEntity seeker){
        SeekerEntity s = seekerService.selectByuserId(seeker.getUserId());
        if(s == null){
            seeker.setCreateTime(new Date());
            seekerService.insert(seeker);
            return R.ok("发布成功！");
        }else {
            seeker.setAlterTime(new Date());
            seekerServiceImpl.updateBySeekerEntity(seeker);
            return R.ok("更新成功！");
        }
    }

    /**
     * 我的简历
     */
    @RequestMapping("/myinfo")
    public R Myinfo(@RequestParam Map<String, Object> params){
        if (params.get("userId") == null){
            return R.error("你还未登录");
        }
//        SysUserTokenEntity sysUserTokenEntity = tokenDao.queryByToken(token);
        SysUserEntity sysUserEntity = sysUserService.selectById(Long.parseLong(params.get("userId").toString()));
        if (sysUserEntity == null){
            return R.error("用户信息错误");
        }
        SeekerEntity seeker = seekerService.selectByuserId(sysUserEntity.getUserId());
        if (seeker == null){
            return R.error("你还未创建简历");
        }
        AppSeekerEntityVo vo = new AppSeekerEntityVo();
        vo.setAlterTime(seeker.getAlterTime());
        vo.setAreaId(seeker.getAreaId());
        vo.setAreaName(areaServiceImpl.selectById(seeker.getAreaId()).getTreeNames());
        vo.setBirthday(seeker.getBirthday());
        vo.setCreateTime(seeker.getCreateTime());
        vo.setDepict(seeker.getDepict());
        vo.setExperience(seeker.getExperience());
        vo.setId(seeker.getId());
        vo.setJob(postService.selectById(seeker.getJobId()).getName());
        vo.setName(seeker.getName());
        vo.setJobId(seeker.getJobId());
        vo.setPhone(seeker.getPhone());
        String[] split = seeker.getPhoto()
                .split(",");
        vo.setPhoto(split);
        vo.setPortrait(seeker.getPortrait().replaceAll("[\\[\\]\\\"]",""));
        vo.setSalary(seeker.getSalary());
        vo.setSex(seeker.getSex());
        vo.setSpecialty(seeker.getSpecialty());
        return R.ok().put("data", vo);
    }

}
