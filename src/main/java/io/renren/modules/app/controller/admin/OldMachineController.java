package io.renren.modules.app.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.OldMachineEntityVo;
import io.renren.modules.app.vo.propertyAdmin;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.OldMachineEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 二手机械表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("app/oldmachine")
public class OldMachineController {
    @Autowired
    private OldMachineService oldMachineService;



    @Autowired
    private SourceGoodsListService sourceGoodsListService;

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

    @Autowired
    private AreaService areaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:oldmachine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oldMachineService.queryPage(params);
        List<OldMachineEntity> content = (List<OldMachineEntity>) page.getContent();
        List<OldMachineEntityVo> vos = new ArrayList<>();
        for(OldMachineEntity s : content){
            OldMachineEntityVo vo = new OldMachineEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setImage(s.getImage().replaceAll("[\\[\\]\\\"]","").split(","));
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
            vo.setModel(s.getModel());
            vo.setDeliveryTime(s.getDeliveryTime());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setLinkMan(s.getLinkMan());
            vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
            vo.setTonnage(s.getTonnage());
            vo.setUseDay(s.getUseDay());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }

    /**
     * 根据一级ID查询二级列表
     */
    @RequestMapping("/next/{id}")
    public R querylist(@PathVariable("id") Long id){
        List<MenuNextEntity> menuNextEntities = oldMachineService.queryNext(id);
        return R.ok().put("data", menuNextEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:oldmachine:info")
    public R info(@PathVariable("id") Long id){
        OldMachineEntity s = oldMachineService.selectById(id);
        OldMachineEntityVo vo = new OldMachineEntityVo();
        vo.setId(s.getId());
        vo.setTitle(s.getTitle());
        vo.setImage(s.getImage().replaceAll("[\\[\\]\\\"]","").split(","));
        vo.setInfo(s.getInfo());
        vo.setCreateTime(s.getCreateTime());
        vo.setAlterTime(s.getAlterTime());
        vo.setDeleteTime(s.getDeleteTime());
        String[] split = s.getPropertyId().replaceAll("[\\[\\]\\\"]", "").split(",");
        List<propertyAdmin> er = new ArrayList<>();
        for(int i = 0; i<split.length;i++){
            propertyAdmin propertyAdmin = new propertyAdmin();
            propertyAdmin.setKey(Integer.parseInt(split[i]));
            propertyAdmin.setLabel(propertyService.selectById(Integer.parseInt(split[i])).getName());
            er.add(propertyAdmin);
        }
        vo.setPropertyId(er);
        vo.setPrice(s.getPrice());
        vo.setLinkPhone(s.getLinkPhone());
        vo.setModel(s.getModel());
        vo.setDeliveryTime(s.getDeliveryTime());
        vo.setWorkingLife(s.getWorkingLife());
        vo.setLinkMan(s.getLinkMan());
        vo.setTonnage(s.getTonnage());
        vo.setUserId(s.getUserId());
        vo.setAreaId(s.getAreaId());
        vo.setCityId(Long.parseLong(areaService.selectById(s.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        vo.setMenuNextId(s.getMenuNextId());
        vo.setMenuRootId(s.getMenuRootId());
        vo.setBrandId(s.getBrandId());
        vo.setUseDay(s.getUseDay());
        return R.ok().put("oldmachine", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:oldmachine:save")
    public R save(@RequestBody OldMachineEntity oldMachine){
        if (oldMachine.getMenuNextId() == null || oldMachine.getMenuNextId().equals("["+"]")){
            return R.error("列表不能为空");
        }
        if (oldMachine.getBrandId() == null || oldMachine.getBrandId().equals("")){
            return R.error("品牌不能为空");
        }
        if (oldMachine.getAreaId() == null || oldMachine.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (oldMachine.getMenuRootId() == null || oldMachine.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(oldMachine.getMenuNextId());
        if (menuNextEntity == null || menuNextEntity.getMenuRootId() != oldMachine.getMenuRootId() || !menuNextEntity.getMenuRootId().equals(oldMachine.getMenuRootId())){
            return R.error("请选择对应的列表");
        }
        if (oldMachine.getUserId() == null || oldMachine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (oldMachine.getImage() == null || oldMachine.getImage().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (oldMachine.getLinkPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(oldMachine.getLinkPhone()).matches();
            if (matches){
                oldMachine.setImage(oldMachine.getImage().replaceAll("[\\[\\]\\\"]",""));
                oldMachine.setCreateTime(new Date());
                SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
                int start = 0;
                try {
                    start = Integer.parseInt(yyyy.format(yyyy.parse(oldMachine.getDeliveryTime())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int end = Integer.parseInt(yyyy.format(new Date()));
                String eo = null;
                if((end-start)>5){
                    eo = "5年以上";
                }else if((end-start)>3){
                    eo = "3-5年";
                }else if((end-start)>1){
                    eo = "1-3年";
                }else {
                    eo = "1年以内";
                }
                oldMachine.setWorkingLife(eo);
                oldMachine.setPropertyId("["+"1"+","+"2"+"]");
                oldMachineService.insert(oldMachine);
                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:oldmachine:update")
    public R update(@RequestBody OldMachineEntity oldMachine){
        if (oldMachine.getMenuNextId() == null || oldMachine.getMenuNextId().equals("["+"]")){
            return R.error("列表不能为空");
        }
        if (oldMachine.getBrandId() == null || oldMachine.getBrandId().equals("")){
            return R.error("品牌不能为空");
        }
        if (oldMachine.getAreaId() == null || oldMachine.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (oldMachine.getMenuRootId() == null || oldMachine.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(oldMachine.getMenuNextId());
        if (menuNextEntity == null || menuNextEntity.getMenuRootId() != oldMachine.getMenuRootId() || !menuNextEntity.getMenuRootId().equals(oldMachine.getMenuRootId())){
            return R.error("请选择对应的列表");
        }
        if (oldMachine.getUserId() == null || oldMachine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (oldMachine.getImage() == null || oldMachine.getImage().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (oldMachine.getLinkPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(oldMachine.getLinkPhone()).matches();
            if (matches){
                oldMachine.setImage(oldMachine.getImage().replaceAll("[\\[\\]\\\"]",""));
                oldMachine.setAlterTime(new Date());
                oldMachine.setPropertyId("["+"1"+","+"2"+"]");
                oldMachineService.updateById(oldMachine);
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
//    @RequiresPermissions("app:oldmachine:delete")
    public R delete(@RequestBody Long[] ids){
			oldMachineService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
