package io.renren.modules.app.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MechanicalLeaseEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.MechanicalLeaseEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 机械租赁表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("app/mechanicallease")
public class MechanicalLeaseController {
    @Autowired
    private MechanicalLeaseService mechanicalLeaseService;

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
//    @RequiresPermissions("app:mechanicallease:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mechanicalLeaseService.queryPage(params);
        List<MechanicalLeaseEntity> content = (List<MechanicalLeaseEntity>) page.getContent();
        List<MechanicalLeaseEntityVo> vos = new ArrayList<>();
         for(MechanicalLeaseEntity s : content){
            MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setStatus(s.getStatus());
            vo.setImagesUrl(s.getImagesUrl().split(","));
            vo.setLeaseholdPrice(s.getLeaseholdPrice());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            if(sysUserService.selectById(s.getUserId()) == null){
                continue;
            }else{
                vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
            }
            if (menuRootService.selectById(s.getMenuRootId()) == null){
                continue;
            }else{
                vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
            }
            if (menuNextService.selectById(s.getMenuNextId()) == null){
                continue;
            }else{
                vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
            }
            vo.setDescriptions(s.getDescriptions());
            vo.setLinkMan(s.getLinkMan());
            vo.setContactNumber(s.getContactNumber());
            vo.setFactoryTime(s.getFactoryTime());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setTonnage(s.getTonnage());
            if(areaService.selectById(s.getAreaId()) == null){
                continue;
            }else{
                vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
            }
            vo.setUseDays(s.getUseDays());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:mechanicallease:info")
    public R info(@PathVariable("id") Long id){
			MechanicalLeaseEntity s = mechanicalLeaseService.selectById(id);
        MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
        vo.setId(s.getId());
        vo.setTitle(s.getTitle());
        vo.setStatus(s.getStatus());
        vo.setImagesUrl(s.getImagesUrl().split(","));
        vo.setLeaseholdPrice(s.getLeaseholdPrice());
        vo.setCreateTime(s.getCreateTime());
        vo.setAlterTime(s.getAlterTime());
        vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
        vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
        vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
        vo.setDescriptions(s.getDescriptions());
        vo.setLinkMan(s.getLinkMan());
        vo.setContactNumber(s.getContactNumber());
        vo.setFactoryTime(s.getFactoryTime());
        vo.setWorkingLife(s.getWorkingLife());
        vo.setTonnage(s.getTonnage());
        vo.setAreaId(s.getAreaId());
        vo.setCityId(Long.parseLong(areaService.selectById(vo.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        vo.setAreaCode(Long.toString(s.getAreaId()));
        vo.setMenuNextId(s.getMenuNextId());
        vo.setMenuRoorId(s.getMenuRootId());
        vo.setUserId(s.getUserId());
        vo.setUseDays(s.getUseDays());
        return R.ok().put("mechanicallease", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:mechanicallease:save")
    public R save(@RequestBody MechanicalLeaseEntity mechanicalLease){
        if (mechanicalLease.getMenuNextId() == null || mechanicalLease.getMenuRootId() == null ||
           mechanicalLease.getMenuRootId().equals("") || mechanicalLease.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(mechanicalLease.getMenuNextId());
        if (menuNextEntity == null || !menuNextEntity.getMenuRootId().equals(mechanicalLease.getMenuRootId()) || menuNextEntity.getMenuRootId() != mechanicalLease.getMenuRootId()){
            return R.error("请选择对应的列表");
        }
        if (mechanicalLease.getImagesUrl() == null || mechanicalLease.getImagesUrl().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (mechanicalLease.getAreaId() == null || mechanicalLease.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (mechanicalLease.getUserId() == null || mechanicalLease.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (mechanicalLease.getContactNumber().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(mechanicalLease.getContactNumber()).matches();
            if (matches){
                mechanicalLease.setDescriptions(mechanicalLease.getDescriptions().replaceAll("</?[^<]+>",""));
                mechanicalLease.setImagesUrl(mechanicalLease.getImagesUrl().replaceAll("[\\[\\]\\\"]",""));
                mechanicalLease.setCreateTime(new Date());
                mechanicalLease.setTitle(mechanicalLease.getModel());
                SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
                int start = 0;
                try {
                    start = Integer.parseInt(yyyy.format(yyyy.parse(mechanicalLease.getFactoryTime())));
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
                mechanicalLease.setWorkingLife(eo);
                mechanicalLeaseService.insert(mechanicalLease);
                return R.ok();
            }else {
                return R.error("手机号格式错误");
            }
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:mechanicallease:update")
    public R update(@RequestBody MechanicalLeaseEntity mechanicalLease){
        if (mechanicalLease.getMenuNextId() == null || mechanicalLease.getMenuRootId() == null ||
                mechanicalLease.getMenuRootId().equals("") || mechanicalLease.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        MenuNextEntity menuNextEntity = menuNextService.selectById(mechanicalLease.getMenuNextId());
        if (menuNextEntity == null || !menuNextEntity.getMenuRootId().equals(mechanicalLease.getMenuRootId()) || menuNextEntity.getMenuRootId() != mechanicalLease.getMenuRootId()){
            return R.error("请选择对应的列表");
        }
        if (mechanicalLease.getImagesUrl() == null || mechanicalLease.getImagesUrl().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (mechanicalLease.getAreaId() == null || mechanicalLease.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (mechanicalLease.getUserId() == null || mechanicalLease.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (mechanicalLease.getContactNumber().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(mechanicalLease.getContactNumber()).matches();
            if (matches){
                mechanicalLease.setDescriptions(mechanicalLease.getDescriptions().replaceAll("</?[^<]+>",""));
                mechanicalLease.setImagesUrl(mechanicalLease.getImagesUrl().replaceAll("[\\[\\]\\\"]",""));
                mechanicalLease.setAlterTime(new Date());
                mechanicalLeaseService.updateById(mechanicalLease);
                return R.ok();
            }else {
                return R.error("手机格式错误");
            }
        }

    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:mechanicallease:delete")
    public R delete(@RequestBody Long[] ids){
			mechanicalLeaseService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
