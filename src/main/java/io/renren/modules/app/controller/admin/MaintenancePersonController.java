package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Pattern;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.Query;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MaintenancePersonTypeEntity;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.MaintenancePersonServiceImpl;
import io.renren.modules.app.service.impl.MaintenancePersonTypeServiceImpl;
import io.renren.modules.app.vo.MaintenancePersonEntityVo;
import io.renren.modules.app.vo.MaintenancePersonVo;
import io.renren.modules.app.vo.PersonVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenancePersonEntity;
import io.renren.modules.app.service.MaintenancePersonService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修人
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/maintenanceperson")
public class MaintenancePersonController {
    @Autowired
    private MaintenancePersonService maintenancePersonService;
    @Autowired
    private MaintenancePersonServiceImpl maintenancePersonServiceImpl;
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MaintenancePersonTypeServiceImpl maintenancePersonTypeServiceImpl;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/listOne")
//    @RequiresPermissions("app:maintenanceperson:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenancePersonService.queryPage(params);
        return R.ok().put("data",page);
    }

    @RequestMapping("/list")
//    @RequiresPermissions("app:maintenanceperson:list")
    public R listAdmin(@RequestParam Map<String, Object> params){
        PageUtils page = maintenancePersonService.queryPageOne(params);
        List<MaintenancePersonEntity> content = (List<MaintenancePersonEntity>) page.getContent();
        List<MaintenancePersonEntityVo> list = new ArrayList<>();
        for (MaintenancePersonEntity m : content){
            SysUserEntity userEntity = sysUserService.selectById(m.getUserId());
            if(userEntity == null){
                return R.error("数据查询错误！");
            }
            MaintenancePersonEntityVo vo = new MaintenancePersonEntityVo();
            AreaEntity areaEntity = areaServiceImpl.selectById(m.getAreaId());
            vo.setAddress(areaEntity.getTreeNames());
            vo.setAddressInf(m.getAddressInf());
            vo.setAlterTime(m.getAlterTime());
            vo.setCreateTime(m.getCreateTime());
            vo.setDeleteTime(m.getDeleteTime());
            vo.setHeadPortrait(m.getHeadPortrait());
            vo.setId(m.getId());
            vo.setName(m.getName());
            vo.setPhone(m.getPhone());
            vo.setSkillScope(m.getSkillScope());
            vo.setUserName(userEntity.getUsername());
            vo.setWorkPortrait(m.getWorkPortrait());
            Long typeId = m.getTypeId();
            MaintenancePersonTypeEntity maintenancePersonTypeEntity = maintenancePersonTypeServiceImpl.selectById(typeId);
            vo.setTypeName(maintenancePersonTypeEntity.getName());
            vo.setSex(m.getSex());
            list.add(vo);
        }

        page.setContent(list);
        return R.ok().put("data",page);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:maintenanceperson:save")
    public R save(@RequestBody MaintenancePersonEntity maintenancePerson){
        if (maintenancePerson.getTypeId() == null || maintenancePerson.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (maintenancePerson.getUserId() == null || maintenancePerson.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (maintenancePerson.getAreaId() == null || maintenancePerson.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (maintenancePerson.getHeadPortrait() == null || maintenancePerson.getHeadPortrait().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (maintenancePerson.getWorkPortrait() == null || maintenancePerson.getWorkPortrait().equals("["+"]")){
            return R.error("工作秀不能为空");
        }
        if (maintenancePerson.getPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            boolean matches = compile.matcher(maintenancePerson.getPhone()).matches();
            if (matches){
                maintenancePerson.setWorkPortrait(maintenancePerson.getWorkPortrait().replaceAll("[\\[\\]\\\"]",""));
                maintenancePerson.setHeadPortrait(maintenancePerson.getHeadPortrait().replaceAll("[\\[\\]\\\"]",""));
                maintenancePerson.setCreateTime(new Date());
                maintenancePersonService.insert(maintenancePerson);
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
//    @RequiresPermissions("app:maintenanceperson:update")
    public R update(@RequestBody MaintenancePersonEntity maintenancePerson){
        if (maintenancePerson.getTypeId() == null || maintenancePerson.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (maintenancePerson.getUserId() == null || maintenancePerson.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (maintenancePerson.getAreaId() == null || maintenancePerson.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (maintenancePerson.getHeadPortrait() == null || maintenancePerson.getHeadPortrait().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (maintenancePerson.getWorkPortrait() == null || maintenancePerson.getWorkPortrait().equals("["+"]")){
            return R.error("工作秀不能为空");
        }
        if (maintenancePerson.getPhone().length() != 11){
            return R.error("手机号必须是11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(maintenancePerson.getPhone()).matches();
            if (matches){
                maintenancePerson.setAlterTime(new Date());
                maintenancePersonService.updateById(maintenancePerson);
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
//    @RequiresPermissions("app:maintenanceperson:delete")
    public R delete(@RequestBody Long[] ids){
			maintenancePersonService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     *根据维修人电话获取维修人接口lyj
     */
    @GetMapping("/queryByPhone")
    public R selectByPhone(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = maintenancePersonServiceImpl.queryByPhone(params);
        return R.ok().put("data",pageUtils);
    }

    /**
     *根据用户id和维修人id删除接口lyj
     */
    @DeleteMapping("/removeById")
    public R deleteById(@RequestParam Map<String, Object> params){
        maintenancePersonServiceImpl.removeById(params);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/apiupdate")
    public R apiupdate(@RequestBody MaintenancePersonEntity maintenancePerson){
        maintenancePerson.setAlterTime(new Date());
        maintenancePersonService.updateById(maintenancePerson);
        return R.ok();
    }


    /**
     * 保存
     */
    @PostMapping("/apisave")
    public R apisave(@RequestBody MaintenancePersonEntity maintenancePerson){
        MaintenancePersonEntity maintenancePersonEntity = maintenancePersonServiceImpl.selectByUserId(maintenancePerson.getUserId());
        if (maintenancePersonEntity != null){
            return R.error("你已发布过维修人");
        }
        maintenancePerson.setCreateTime(new Date());
        maintenancePersonService.insert(maintenancePerson);
        return R.ok();
    }

    /**
     *维修人详情
     */
    @GetMapping("/byId/{id}")
    public R selectById(@PathVariable("id") Long id){
        MaintenancePersonEntity maintenancePerson = maintenancePersonService.selectById(id);
        PersonVo vo = maintenancePersonServiceImpl.getPersionVo(maintenancePerson);
        return R.ok().put("data",vo);
    }
}
