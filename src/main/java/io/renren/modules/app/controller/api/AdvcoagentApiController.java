package io.renren.modules.app.controller.api;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.entity.SeekerEntity;
import io.renren.modules.app.service.PostService;
import io.renren.modules.app.service.impl.AdvcoagentServiceImpl;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.vo.AdvcoagentEntityVo;
import io.renren.modules.app.vo.AdvcoagentEntityVos;
import io.renren.modules.app.vo.SeekerEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.AdvcoagentEntity;
import io.renren.modules.app.service.AdvcoagentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 发布招聘-----找帮手
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:54
 */
@RestController
@RequestMapping("api/advcoagent")
public class AdvcoagentApiController {
    @Autowired
    private AdvcoagentService advcoagentService;

    @Autowired
    private AdvcoagentServiceImpl advcoagentServiceImpl;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    private PostService postService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = advcoagentService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AdvcoagentEntity advcoagent = advcoagentService.selectById(id);
		AdvcoagentEntityVo vo = new AdvcoagentEntityVo();
        SysUserEntity userEntity = sysUserServiceImpl.selectById(advcoagent.getUserId());
        vo.setUserName(userEntity.getUsername());
        vo.setTitle(advcoagent.getTitle());
        vo.setSex(advcoagent.getSex());
        vo.setSalary(advcoagent.getSalary());
        vo.setProperty(advcoagent.getProperty());
        vo.setPrincipal(advcoagent.getPrincipal());
        vo.setPhone(advcoagent.getPhone());
        PostEntity postEntity = postService.selectById(advcoagent.getJobId());
        vo.setJob(postEntity.getName());
        vo.setId(advcoagent.getId());
        vo.setExperience(advcoagent.getExperience());
        vo.setCreateTime(advcoagent.getCreateTime());
        vo.setCompany(advcoagent.getCompany());
        AreaEntity areaEntity = areaServiceImpl.selectById(advcoagent.getAreaId());
        vo.setAreaName(areaEntity.getTreeNames());
        vo.setAlterTime(advcoagent.getAlterTime());
        vo.setAgeGroup(advcoagent.getAgeGroup());
        vo.setAdvertiseNumber(advcoagent.getAdvertiseNumber());
        vo.setAddress(advcoagent.getAddress());
        String remark = advcoagent.getRemark();
        String depict = advcoagent.getDepict();
        Pattern compile = Pattern.compile("<p.*?>(.*?)</p>");
        Matcher matcher1 = compile.matcher(remark);
        while (matcher1.find()){
            String group = matcher1.group(1);
            vo.setRemark(group);
        }
        Matcher matcher = compile.matcher(depict);
        while (matcher.find()){
            String group = matcher.group(1);
            vo.setDepict(group);
        }
        return R.ok().put("data", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AdvcoagentEntity advcoagentEntity){
        if (advcoagentEntity.getAreaId() == null || advcoagentEntity.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (advcoagentEntity.getJobId() == null || advcoagentEntity.getAreaId().equals("")){
            return R.error("职位不能为空");
        }
        if (advcoagentEntity.getUserId() == null || advcoagentEntity.getAreaId().equals("")){
            return R.error("必须提供用户id");
        }
        if (advcoagentEntity.getPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8,6,7,8,9][0-9]{9}$");
            Matcher matcher = compile.matcher(advcoagentEntity.getPhone());
            boolean matches = matcher.matches();
            if (!matches){
                return R.error("请输入正确的手机号");
            }else {
                advcoagentEntity.setCreateTime(new Date());
                advcoagentService.insert(advcoagentEntity);
                return R.ok();
            }
        }
    }
    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AdvcoagentEntity advcoagent){
        if (advcoagent.getAreaId() == null || advcoagent.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (advcoagent.getJobId() == null || advcoagent.getAreaId().equals("")){
            return R.error("职位不能为空");
        }
        if (advcoagent.getUserId() == null || advcoagent.getAreaId().equals("")){
            return R.error("必须提供用户id");
        }
        if (advcoagent.getPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8,6,7,8,9][0-9]{9}$");
            Matcher matcher = compile.matcher(advcoagent.getPhone());
            boolean matches = matcher.matches();
            if (!matches){
                return R.error("请输入正确的手机号");
            }else {
                advcoagent.setAlterTime(new Date());
                advcoagentService.updateById(advcoagent);
                return R.ok();
            }
        }
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			advcoagentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     *职位推荐和列表
     */
    @GetMapping("/byHost")
    public R queryByHost(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = advcoagentServiceImpl.queryAll(params);
        List<AdvcoagentEntity> advcoagentEntityList = (List<AdvcoagentEntity>) pageUtils.getContent();
        List<AdvcoagentEntityVo> list = new ArrayList<>();
        advcoagentEntityList.stream().filter(a->list.add(advcoagentServiceImpl.getAdvcoagentEntityVo(a))).collect(Collectors.toList());
        pageUtils.setContent(list);
        return R.ok().put("data",pageUtils);
    }


}
