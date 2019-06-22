package io.renren.modules.app.controller.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.app.entity.MachineEntity;
import io.renren.modules.app.entity.PartsEntity;
import io.renren.modules.app.entity.PropertyEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MachineEntityVo;
import io.renren.modules.app.vo.OldMachineEntityVo;
import io.renren.modules.app.vo.propertyAdmin;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("au/oldmachine")
public class OldMachineApiController {
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
     *
     * 热门机型推荐
     *
     * **/
    @GetMapping("/hot")
    public R hot(){
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage","1");
        parms.put("pageSize","30");
        PageUtils pageUtils = oldMachineService.queryPage1(parms);
        List<OldMachineEntity> content = (List<OldMachineEntity>) pageUtils.getContent();
        Set<Object> arr = new LinkedHashSet<>();
        for(OldMachineEntity s: content){
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
        PageUtils pageUtils = oldMachineService.queryPage1(parms);
        List<OldMachineEntity> content = (List<OldMachineEntity>) pageUtils.getContent();
        Set<Object> arr = new LinkedHashSet<>();
        for(OldMachineEntity s: content){
            Map<String,Object> r = new HashMap();
            r.put("title",commodityBrandService.selectById(s.getBrandId()).getBrandName());
            r.put("id",commodityBrandService.selectById(s.getBrandId()).getId());
            arr.add(r);
        }
        return R.ok().put("data",arr);
    }




    /**
     *
     * 查询全部品牌
     *
     * **/
    @GetMapping("/commodityBrand")
    public R commodityBrandlist(){
        return R.ok().put("data",commodityBrandService.allquery());
    }


    /**
     * 查询所有的一级列表
     *
     * **/
    @GetMapping("/menuroot")
    public R menurootlist(){
        return R.ok().put("data",menuRootService.allquery());
    }


    /**
     * 查询所有的二级列表
     *
     * **/
    @GetMapping("/menunext")
    public R menunextlist(){
        return R.ok().put("data",menuNextService.allquery());
    }


    /**
     * 查询所有的属性
     *
     * **/
    @GetMapping("/property")
    public R propertylist(){

        return R.ok().put("data",propertyService.allquery());
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oldMachineService.queryPage(params);


        return R.ok().put("page", page);
    }


    /**
     * 列表
     * @param params
     * @return
     */
    @GetMapping("/query")
    public R querylist(@RequestParam Map<String, Object> params){
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
//            String[] p = s.getPropertyId().replaceAll("[\\[\\]\\\"]","").split(",");
//            StringBuffer sb = new StringBuffer();
//            for(String p1 :p){
//                sb.append(propertyService.selectById(p1).getName()+"-");
//            }
            vo.setProperty(s.getPropertyId());
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
     * 列表
     */
    @GetMapping("/hotlist")
    public R hotlist(){
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage","1");
        parms.put("pageSize","3");
        PageUtils page = oldMachineService.queryPage1(parms);
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
     * 列表
     */
    @GetMapping("/mylist")
    public R mylist(@RequestParam Map<String, Object> params){
        PageUtils page = oldMachineService.MyqueryPage(params);
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
//            String[] p = s.getPropertyId().replaceAll("[\\[\\]\\\"]","").split(",");
//            StringBuffer sb = new StringBuffer();
//            for(String p1 :p){
//                sb.append(propertyService.selectById(p1).getName()+"-");
//            }
            vo.setProperty(s.getPropertyId());
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
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OldMachineEntity s = oldMachineService.selectById(id);
		if (s == null){
		    return R.error("未查询到数据");
        }
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
        vo.setUseDay(s.getUseDay());
        vo.setTonnage(s.getTonnage());
        return R.ok().put("oldMachine", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody OldMachineEntity oldMachine){
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
        oldMachine.setPropertyId("[1,2]");
        oldMachineService.insert(oldMachine);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody OldMachineEntity oldMachine){
			oldMachineService.updateById(oldMachine);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			oldMachineService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 根据id和用户id删除二手
     */
    @DeleteMapping("/deleteByIdWithUserId")
    public R deleteByIdWithUserId(@RequestParam Map<String, Object> params){
        if (params.get("id") == null){
            return R.error("必须提供ID");
        }
        if (params.get("userId") == null){
            return R.error("必须提供用户ID");
        }
        oldMachineService.deleteByUserId(params);
        return R.ok();
    }

}
