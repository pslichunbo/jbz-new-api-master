package io.renren.modules.app.controller.api;

import java.util.*;

import io.renren.modules.app.entity.OldMachineEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.OldMachineEntityVo;
import io.renren.modules.app.vo.PartsEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("au/parts")
public class PartsApiController {
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
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = partsService.queryPage(params);

        return R.ok().put("page", page);
    }



    /**
     *
     * 热门机型推荐
     *
     * **/
    @GetMapping("/hot")
    public R hot(){
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage","1");
        parms.put("pageSize","30");
        PageUtils pageUtils = partsService.queryPage1(parms);
        List<PartsEntity> content = (List<PartsEntity>) pageUtils.getContent();
        Set<Object> arr = new LinkedHashSet<>();
        for(PartsEntity s: content){
            Map<String,Object> r = new HashMap();
            r.put("title",menuNextService.selectById(s.getMenuNextId()).getMenuName());
            r.put("MenuNextId",menuNextService.selectById(s.getMenuNextId()).getId());
            r.put("MenuRootId",menuRootService.selectById(menuNextService.selectById(s.getMenuNextId()).getMenuRootId()).getId());
            arr.add(r);
        }
        return R.ok().put("data",arr);
    }


    /**
     *
     * 热门品牌推荐
     *
     * **/
    @GetMapping("/brandhot")
    public R hotbrand(){
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage","1");
        parms.put("pageSize","30");
        PageUtils pageUtils = partsService.queryPage1(parms);
        List<PartsEntity> content = (List<PartsEntity>) pageUtils.getContent();
        Set<Object> arr = new LinkedHashSet<>();
        for(PartsEntity s: content){
            Map<String,Object> r = new HashMap();
            r.put("title",commodityBrandService.selectById(s.getBrandId()).getBrandName());
            r.put("id",commodityBrandService.selectById(s.getBrandId()).getId());
            arr.add(r);
        }
        return R.ok().put("data",arr);
    }
    /**
     * 列表
     */
    @GetMapping("/hotlist")
    public R hotlist(){
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage","1");
        parms.put("pageSize","3");
        PageUtils page = partsService.queryPage1(parms);
        List<PartsEntity> content = (List<PartsEntity>) page.getContent();
        List<PartsEntityVo> vos = new ArrayList<>();
        for(PartsEntity s : content){
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
            vo.setPartsArea(areaService.selectById(s.getPartsArea()).getTreeNames());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }

    @GetMapping("/query")
    public R querylist(@RequestParam Map<String, Object> params){
        PageUtils page = partsService.query(params);
        List<PartsEntity> content = (List<PartsEntity>) page.getContent();
        List<PartsEntityVo> vos = new ArrayList<>();
        for(PartsEntity s : content){
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
            vo.setPartsArea(areaService.selectById(s.getPartsArea()).getTreeNames());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @GetMapping("/mylist")
    public R mylist(@RequestParam Map<String, Object> params){
        PageUtils page = partsService.MyqueryPage(params);
        List<PartsEntity> content = (List<PartsEntity>) page.getContent();
        List<PartsEntityVo> vos = new ArrayList<>();
        for(PartsEntity s : content){
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
            vo.setPartsArea(areaService.selectById(s.getPartsArea()).getTreeNames());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }





    /**
     * 信息
     */
    @GetMapping("/info/{id}")
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
        vo.setPartsArea(areaService.selectById(s.getPartsArea()).getTreeNames());
        return R.ok().put("parts", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody PartsEntity parts){
            parts.setPartsPhoto(parts.getPartsPhoto().replaceAll("[\\[\\]\\\"]",""));
            parts.setCreateTime(new Date());
            partsService.insert(parts);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody PartsEntity parts){
			partsService.updateById(parts);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			partsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
