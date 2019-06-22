package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.MaintenanceStoreServiceImpl;
import io.renren.modules.app.service.impl.MaintenanceStoreTypeServiceImpl;
import io.renren.modules.app.vo.MaintenanceStoreEntityVo;
import io.renren.modules.app.vo.MaintenanceStoreVo;
import io.renren.modules.app.vo.StoreVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenanceStoreEntity;
import io.renren.modules.app.service.MaintenanceStoreService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修店
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/maintenancestore")
public class MaintenanceStoreController {
    @Autowired
    private MaintenanceStoreService maintenanceStoreService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AreaServiceImpl areaServiceImpl;
    @Autowired
    private MaintenanceStoreTypeServiceImpl maintenanceStoreTypeServiceImpl;

    @Autowired
    private MaintenanceStoreServiceImpl maintenanceStoreServiceImpl;



    @Autowired
    private AreaService areaService;

    /**
     * 列表
     */
    @RequestMapping("/listOne")
//    @RequiresPermissions("app:maintenancestore:list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = maintenanceStoreService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list")
//    @RequiresPermissions("app:maintenancestore:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenanceStoreService.queryPageOne(params);
        List<MaintenanceStoreEntity> content = (List<MaintenanceStoreEntity>) page.getContent();
        List<MaintenanceStoreEntityVo> list = new ArrayList<>();
        for (MaintenanceStoreEntity m : content){
            SysUserEntity userEntity = sysUserService.selectById(m.getUserId());
            if(userEntity == null){
                return R.error("数据查询错误！");
            }
            MaintenanceStoreEntityVo vo = new MaintenanceStoreEntityVo();
            vo.setAddress(m.getAddress());
            vo.setAlterTime(m.getAlterTime());
            vo.setBusinessScope(m.getBusinessScope());
            vo.setCreateTime(m.getCreateTime());
            vo.setDeleteTime(m.getDeleteTime());
            vo.setId(m.getId());
            vo.setShopManagerName(m.getShopManagerName());
            vo.setShopManagerPhone(m.getShopManagerPhone());
            AreaEntity areaEntity = areaServiceImpl.selectById(m.getAreaId());
            vo.setAddress(m.getAddress());
            vo.setAreaName(areaEntity.getTreeNames());
            vo.setStoreBeautifulImage(m.getStoreBeautifulImage());
            vo.setStoreImage(m.getStoreImage());
            vo.setStoreInfo(m.getStoreInfo());
            vo.setStoreName(m.getStoreName());
            vo.setUserName(userEntity.getUsername());
            MaintenanceStoreTypeEntity maintenanceStoreTypeEntity = maintenanceStoreTypeServiceImpl.selectById(m.getTypeId());
            vo.setTypeName(maintenanceStoreTypeEntity.getName());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//   @RequiresPermissions("app:maintenancestore:info")
    public R info(@PathVariable("id") Long id){
		MaintenanceStoreEntity maintenanceStore = maintenanceStoreService.selectById(id);
        StoreVo vo = new StoreVo();
        AreaEntity areaEntity = areaServiceImpl.selectById(maintenanceStore.getAreaId());
        vo.setAreaName(areaEntity.getTreeNames());
        vo.setAddress(maintenanceStore.getAddress());
        vo.setBusinessScope(maintenanceStore.getBusinessScope());
        vo.setId(maintenanceStore.getId());
        vo.setShopManagerName(maintenanceStore.getShopManagerName());
        String[] split = maintenanceStore.getStoreBeautifulImage()
                .replaceAll("[\\[\\]\\\"]", "")
                .split(",");
        vo.setStoreBeautifulImage(split);
        vo.setShopManagerPhone(maintenanceStore.getShopManagerPhone());
        String[] split1 = maintenanceStore.getStoreImage()
                .replaceAll("[\\[\\]\\\"]", "")
                .split(",");
        vo.setStoreImage(split1[0]);
        vo.setStoreInfo(maintenanceStore.getStoreInfo());
        vo.setStoreName(maintenanceStore.getStoreName());
        MaintenanceStoreTypeEntity maintenanceStoreTypeEntity = maintenanceStoreTypeServiceImpl.selectById(maintenanceStore.getTypeId());
        vo.setTypeName(maintenanceStoreTypeEntity.getName());
        vo.setTypeId(maintenanceStore.getTypeId());
        SysUserEntity userEntity = sysUserService.selectById(maintenanceStore.getUserId());
        vo.setUserName(userEntity.getUsername());
        vo.setUserId(userEntity.getUserId());
        vo.setAreaId(Long.parseLong(areaEntity.getAreaCode()));
        vo.setCityId(Long.parseLong(areaService.selectById(areaEntity.getAreaCode()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        return R.ok().put("data", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:maintenancestore:save")
    public R save(@RequestBody MaintenanceStoreEntity maintenanceStore){
        if (maintenanceStore.getAreaId() == null || maintenanceStore.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (maintenanceStore.getTypeId() == null || maintenanceStore.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (maintenanceStore.getStoreImage() == null || maintenanceStore.getStoreImage().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (maintenanceStore.getStoreBeautifulImage() == null ||maintenanceStore.getStoreBeautifulImage().equals("\"\"")){
            return R.error("门店秀不能为空");
        }
        if (maintenanceStore.getShopManagerPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(maintenanceStore.getShopManagerPhone()).matches();
            if (matches){
                maintenanceStore.setStoreInfo(maintenanceStore.getStoreInfo().replaceAll("<([^>]*)>",""));
                maintenanceStore.setStoreImage(maintenanceStore.getStoreImage().replaceAll("[\\[\\]\\\"]",""));
                maintenanceStore.setStoreBeautifulImage(maintenanceStore.getStoreBeautifulImage().replaceAll("[\\[\\]\\\"]",""));
                maintenanceStore.setCreateTime(new Date());
                SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
                maintenanceStore.setUserId(userEntity.getUserId());
                maintenanceStoreService.insert(maintenanceStore);
                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }

    }


    /**
     * 保存
     */
    @PostMapping("/apisave")
    public R apisave(@RequestBody MaintenanceStoreEntity maintenanceStore){
        MaintenanceStoreEntity storeEntity = maintenanceStoreServiceImpl.getByUserId(maintenanceStore.getUserId());
        if (storeEntity != null){
            return R.error("你已发布过维修店");
        }
        maintenanceStore.setCreateTime(new Date());
        maintenanceStoreService.insert(maintenanceStore);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:maintenancestore:update")
    public R update(@RequestBody MaintenanceStoreEntity maintenanceStore){
        if (maintenanceStore.getAreaId() == null || maintenanceStore.getAreaId().equals("")){
            return R.error("地区不能为空");
        }
        if (maintenanceStore.getTypeId() == null || maintenanceStore.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
//        if (maintenanceStore.getStoreBeautifulImage() == null || maintenanceStore.getStoreImage() == null
//                || maintenanceStore.getStoreImage().equals("\"\"") || maintenanceStore.getStoreBeautifulImage().equals("\"\"")){
//            return R.error("照片不能为空");
//        }
        if (maintenanceStore.getShopManagerPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(maintenanceStore.getShopManagerPhone()).matches();
            if (matches){
                maintenanceStore.setStoreInfo(maintenanceStore.getStoreInfo().replaceAll("<([^>]*)>",""));
                maintenanceStore.setStoreImage(maintenanceStore.getStoreImage().replaceAll("[\\[\\]\\\"]",""));
                maintenanceStore.setStoreBeautifulImage(maintenanceStore.getStoreBeautifulImage().replaceAll("[\\[\\]\\\"]",""));
                maintenanceStore.setAlterTime(new Date());
                maintenanceStoreService.updateById(maintenanceStore);
                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }

    }

    /**
     * 修改
     */
    @PostMapping("/apiupdate")
    public R apiupdate(@RequestBody MaintenanceStoreEntity maintenanceStore){
        maintenanceStore.setAlterTime(new Date());
        maintenanceStoreService.updateById(maintenanceStore);

        return R.ok();
    }


    /**
     *查看维修铺详情接口
     */
    @GetMapping("/queryById/{id}")
    public R selectById(@PathVariable("id") Long id){
        MaintenanceStoreEntity maintenanceStoreEntity = maintenanceStoreService.selectById(id);
        StoreVo vo = maintenanceStoreServiceImpl.getVo(maintenanceStoreEntity);
        return R.ok().put("data",vo);
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:maintenancestore:delete")
    public R delete(@RequestBody Long[] ids){
			maintenanceStoreService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
