package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.CommodityBrandTypeEntity;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.form.CommodityBrandForm;
import io.renren.modules.app.service.CommodityBrandTypeService;
import io.renren.modules.app.service.MenuNextService;
import io.renren.modules.app.service.impl.CommodityBrandServiceImpl;
import io.renren.modules.app.service.impl.CommodityBrandTypeServiceImpl;
import io.renren.modules.app.vo.CommodityBrandVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.CommodityBrandEntity;
import io.renren.modules.app.service.CommodityBrandService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品品牌表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/commoditybrand")
public class CommodityBrandController {
    @Autowired
    private CommodityBrandService commodityBrandService;
    @Autowired
    private CommodityBrandServiceImpl commodityBrandServiceImpl;


    @Autowired
    private CommodityBrandTypeService commodityBrandTypeService;

    @Autowired
    private CommodityBrandTypeServiceImpl commodityBrandTypeServiceImpl;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MenuNextService menuNextService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:commoditybrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commodityBrandService.queryPage(params);
        List<CommodityBrandEntity> content = (List<CommodityBrandEntity>) page.getContent();
        List<CommodityBrandVo> list = new ArrayList<>();
        content.stream().forEach(c->list.add(commodityBrandServiceImpl.getCommodityBrandVo(c)));
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:commoditybrand:info")
    public R info(@PathVariable("id") Long id){
			CommodityBrandEntity commodityBrand = commodityBrandService.selectById(id);
        CommodityBrandVo commodityBrandVo = commodityBrandServiceImpl.getCommodityBrandVo(commodityBrand);
        return R.ok().put("data", commodityBrandVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:commoditybrand:save")
    public R save(@RequestBody CommodityBrandEntity commodityBrand){
            if (commodityBrand.getTypeId() == null || commodityBrand.getTypeId().equals("")){
                return R.error("类型不能为空");
            }
            if (commodityBrand.getUserId() == null || commodityBrand.getUserId().equals("")){
                return R.error("用户不能为空");
            }
			commodityBrand.setCreateTime(new Date());
            commodityBrandService.insert(commodityBrand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:commoditybrand:update")
    public R update(@RequestBody CommodityBrandEntity commodityBrand){
        if (commodityBrand.getTypeId() == null || commodityBrand.getTypeId().equals("")){
            return R.error("类型不能为空");
        }
        if (commodityBrand.getUserId() == null || commodityBrand.getUserId().equals("")){
            return R.error("用户不能为空");
        }
            commodityBrand.setAlterTime(new Date());
			commodityBrandService.updateById(commodityBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:commoditybrand:delete")
    public R delete(@RequestBody Long[] ids){
			commodityBrandService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *获取品牌接口type=0则获取全部lyj
     */
    @GetMapping("/listById")
    public R selectByTypeIds(@RequestParam Map<String, Object> params){
        long typeId = Long.parseLong(params.get("typeId").toString());
       if (typeId == 0){
           PageUtils pageUtils = commodityBrandServiceImpl.queryAll(params);
           return R.ok().put("data",pageUtils);
       }
        PageUtils pageUtils = commodityBrandServiceImpl.queryByTypeId(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     *添加品牌接口lyj
     */
    @PostMapping("/add")
    public R saveCommodity(@RequestBody CommodityBrandForm form){
        CommodityBrandEntity entity = new CommodityBrandEntity();
        entity.setBrandInfo(form.getBrandInfo());
        entity.setBrandLogo(form.getBrandLogo());
        entity.setBrandName(form.getBrandName());
        entity.setCreateTime(form.getCreateTime());
        entity.setStatus(form.getStatus());
        entity.setTypeId(form.getTypeId());
        entity.setMenuNextId(form.getMenuNextId());
        entity.setUserId(form.getUserId());
        commodityBrandServiceImpl.insert(entity);
        return R.ok();
    }
    /**
     *根据用户id和品牌id删除品牌接口lyj
     */
    @DeleteMapping("/remove")
    public R removeById(@RequestParam Map<String, Object> params){
        commodityBrandServiceImpl.removeByTypeId(params);
        return R.ok();
    }
    /**
     *查询所有品牌类型
     */
    @GetMapping("/all")
    public R selectAll(){
        List<CommodityBrandTypeEntity> list = commodityBrandTypeServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
