package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MachineEntityVo;
import io.renren.modules.app.vo.propertyAdmin;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.MachineEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 新机表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("app/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private CommodityBrandService commodityBrandService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private MenuRootService menuRootService;

    @Autowired
    private MenuNextService menuNextService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = machineService.queryPage(params);
        List<MachineEntity> content = (List<MachineEntity>) page.getContent();
        List<MachineEntityVo> vos = new ArrayList<>();
        for(MachineEntity s : content){
            MachineEntityVo vo = new MachineEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setImage(s.getImage().split(","));
            vo.setInfo(s.getInfo());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
            vo.setBrandName(commodityBrandService.selectById(s.getBrandId()).getBrandName());
            String[] p = s.getPropertyId().replaceAll("[\\[\\]\\\"]","").split(",");
            StringBuffer sb = new StringBuffer();
            for(String p1 :p){
                sb.append(propertyService.selectById(p1).getName()+"-");
            }
            vo.setProperty(sb.toString());
            vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
            vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
            vo.setPrice(s.getPrice());
            vo.setLinkPhone(s.getLinkPhone());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setTonnage(s.getTonnage());
            vo.setUserId(s.getUserId());
            vo.setBrandId(s.getBrandId());
            vo.setMenuNextId(s.getMenuNextId());
            vo.setMenuRootId(s.getMenuRootId());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MachineEntity s = machineService.selectById(id);
        MachineEntityVo vo = new MachineEntityVo();
        vo.setId(s.getId());
        vo.setTitle(s.getTitle());
        vo.setImage(s.getImage().split(","));
        vo.setInfo(s.getInfo());
        vo.setCreateTime(s.getCreateTime());
        vo.setAlterTime(s.getAlterTime());
        vo.setDeleteTime(s.getDeleteTime());
        vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
        vo.setBrandName(commodityBrandService.selectById(s.getBrandId()).getBrandName());
        vo.setBrandId(s.getBrandId());
        String[] p = s.getPropertyId().replaceAll("[\\[\\]\\\"]","").split(",");
        List<propertyAdmin> er = new ArrayList<>();
        for(int i = 0; i<p.length;i++){
            propertyAdmin propertyAdmin = new propertyAdmin();
            propertyAdmin.setKey(Integer.parseInt(p[i]));
            propertyAdmin.setLabel(propertyService.selectById(Integer.parseInt(p[i])).getName());
            er.add(propertyAdmin);
        }
        vo.setPropertyId(er);
        vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
        vo.setMenuNextId(s.getMenuNextId());
        vo.setMenuRootId(s.getMenuRootId());
        vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
        vo.setPrice(s.getPrice());
        vo.setLinkPhone(s.getLinkPhone());
        vo.setWorkingLife(s.getWorkingLife());
        vo.setTonnage(s.getTonnage());
        vo.setUserId(s.getUserId());
        return R.ok().put("machine", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MachineEntity machine){
        //根据二级列表判断一二级列表是否对应
        if (machine.getBrandId() == null ||machine.getBrandId().equals("")){
            return R.error("品牌id不能为空");
        }
        if (machine.getMenuNextId() == null || machine.getMenuNextId().equals("")){
            return R.error("列表不能为空");
        }
        if (machine.getMenuRootId() == null || machine.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(machine.getMenuNextId());
        if (menuNextEntity == null || menuNextEntity.getMenuRootId() != machine.getMenuRootId() || !menuNextEntity.getMenuRootId().equals(machine.getMenuRootId())){
            return R.error("请选择对应的列表");
        }
        if (machine.getUserId() == null || machine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (machine.getPropertyId() == null || machine.getPropertyId().equals("["+"]")){
            return R.error("属性不能为空");
        }
        if (machine.getImage() == null || machine.getImage().equals("") || machine.getImage().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (machine.getLinkPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            boolean matches = compile.matcher(machine.getLinkPhone()).matches();
            if (matches) {
                machine.setImage(machine.getImage().replaceAll("[\\[\\]\\\"]", ""));
                machine.setCreateTime(new Date());
                machineService.insert(machine);
                return R.ok();
            }
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MachineEntity machine){
        if (machine.getBrandId() == null ||machine.getBrandId().equals("")){
            return R.error("品牌id不能为空");
        }
        if (machine.getMenuNextId() == null || machine.getMenuNextId().equals("")){
            return R.error("列表不能为空");
        }
        if (machine.getMenuRootId() == null || machine.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(machine.getMenuNextId());
        if (menuNextEntity == null || menuNextEntity.getMenuRootId() != machine.getMenuRootId() || !menuNextEntity.getMenuRootId().equals(machine.getMenuRootId())){
            return R.error("请选择对应的列表");
        }
        if (machine.getUserId() == null || machine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (machine.getPropertyId() == null || machine.getPropertyId().equals("["+"]")){
            return R.error("属性不能为空");
        }
        if (machine.getImage() == null || machine.getImage().equals("") || machine.getImage().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (machine.getLinkPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            boolean matches = compile.matcher(machine.getLinkPhone()).matches();
            if (matches) {
                machine.setImage(machine.getImage().replaceAll("[\\[\\]\\\"]", ""));
                machine.setAlterTime(new Date());
                machineService.updateById(machine);
                return R.ok();
            }
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			machineService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
