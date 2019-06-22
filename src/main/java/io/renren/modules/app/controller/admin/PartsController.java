package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Pattern;

import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.PartsEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.PartsEntity;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 配件表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("app/parts")
public class PartsController {
    @Autowired
    private PartsService partsService;



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
//    @RequiresPermissions("app:parts:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = partsService.queryPage(params);
        List<PartsEntity> content = (List<PartsEntity>) page.getContent();
        List<PartsEntityVo> vos = new ArrayList<>();
        for(PartsEntity s : content){
            PartsEntityVo vo = new PartsEntityVo();
            vo.setId(s.getId());
            vo.setPartsName(s.getPartsName());
            if (s.getPartsPhoto() != null){
                vo.setPartsPhoto(s.getPartsPhoto().replaceAll("[\\[\\]\\\"]","").split(","));
            }else {
                vo.setPartsPhoto(null);
            }
            vo.setPartsInfo(s.getPartsInfo());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
            vo.setBrandName(commodityBrandService.selectById(s.getBrandId()).getBrandName());
            vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
            vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
            vo.setPartsPrice(s.getPartsPrice());
            vo.setPartsPhone(s.getPartsPhone());
            vo.setPartsModel(s.getPartsModel());
            vo.setLinkMan(s.getLinkMan());
            if (s.getPartsArea() == null){
                vo.setPartsArea(null);
            }else {
                vo.setPartsArea(areaService.selectById(s.getPartsArea()).getTreeNames());
            }
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:parts:info")
    public R info(@PathVariable("id") Long id){
			PartsEntity s = partsService.selectById(id);
        PartsEntityVo vo = new PartsEntityVo();
        vo.setId(s.getId());
        vo.setPartsName(s.getPartsName());
        vo.setPartsPhoto(s.getPartsPhoto().replaceAll("[\\[\\]\\\"]","").split(","));
        vo.setPartsInfo(s.getPartsInfo());
        vo.setCreateTime(s.getCreateTime());
        vo.setAlterTime(s.getAlterTime());
        vo.setDeleteTime(s.getDeleteTime());
        vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
        vo.setBrandName(commodityBrandService.selectById(s.getBrandId()).getBrandName());
        vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
        vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
        vo.setPartsPrice(s.getPartsPrice());
        vo.setPartsPhone(s.getPartsPhone());
        vo.setPartsModel(s.getPartsModel());
        vo.setLinkMan(s.getLinkMan());
        vo.setAreaId(Long.parseLong(s.getPartsArea()));
        vo.setCityId(Long.parseLong(areaService.selectById(vo.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        vo.setUserId(s.getUserId());
        vo.setBrandId(s.getBrandId());
        vo.setMenuNextId(s.getMenuNextId());
        vo.setMenuRootId(s.getMenuRootId());
        return R.ok().put("parts", vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:parts:save")
    public R save(@RequestBody PartsEntity parts){
        if (parts.getPartsArea() == null || parts.getPartsArea().equals("")){
            return R.error("地区不能为空");
        }
        if (parts.getPartsPhoto() == null || parts.getPartsPhoto().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (parts.getMenuNextId() == null || parts.getMenuNextId().equals("")){
            return R.error("列表不能为空");
        }
        if (parts.getMenuRootId() == null || parts.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        if (parts.getBrandId() == null || parts.getBrandId().equals("")){
            return R.error("品牌不能为空");
        }
        if (parts.getUserId() == null || parts.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (parts.getPartsPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(parts.getPartsPhone()).matches();
            if (matches){
                parts.setPartsPhoto(parts.getPartsPhoto().replaceAll("[\\[\\]\\\"]",""));
                parts.setCreateTime(new Date());
                partsService.insert(parts);
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
//    @RequiresPermissions("app:parts:update")
    public R update(@RequestBody PartsEntity parts){
        if (parts.getPartsArea() == null || parts.getPartsArea().equals("")){
            return R.error("地区不能为空");
        }
        if (parts.getPartsPhoto() == null || parts.getPartsPhoto().equals("\"\"")){
            return R.error("图片不能为空");
        }
        if (parts.getMenuNextId() == null || parts.getMenuNextId().equals("")){
            return R.error("列表不能为空");
        }
        if (parts.getMenuRootId() == null || parts.getMenuRootId().equals("")){
            return R.error("列表不能为空");
        }
        if (parts.getBrandId() == null || parts.getBrandId().equals("")){
            return R.error("品牌不能为空");
        }
        if (parts.getUserId() == null || parts.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (parts.getPartsPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(parts.getPartsPhone()).matches();
            if (matches){
                parts.setPartsPhoto(parts.getPartsPhoto().replaceAll("[\\[\\]\\\"]",""));
                parts.setAlterTime(new Date());
                partsService.updateById(parts);
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
//    @RequiresPermissions("app:parts:delete")
    public R delete(@RequestBody Long[] ids){
			partsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
