package io.renren.modules.app.controller.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import io.renren.modules.app.entity.OldMachineEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MechanicalLeaseEntityVo;
import io.renren.modules.app.vo.OldMachineEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("au/mechanicallease")
public class MechanicalLeaseApiController {
    @Autowired
    private MechanicalLeaseService mechanicalLeaseService;
    @Autowired
    private SysUserService sysUserService;
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
        PageUtils page = mechanicalLeaseService.queryPage(params);

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
        PageUtils pageUtils = mechanicalLeaseService.queryPage1(parms);
        List<MechanicalLeaseEntity> content = (List<MechanicalLeaseEntity>) pageUtils.getContent();
        Set<Object> re = new LinkedHashSet<>();

        for(MechanicalLeaseEntity s: content){
            Map<String,Object> arr =  new HashMap<>();
            arr.put("MenuRootName",menuRootService.selectById(s.getMenuRootId()).getMenuName());
            arr.put("MenuRootId",s.getMenuRootId());
            arr.put("MenuNextName",menuNextService.selectById(s.getMenuNextId()).getMenuName());
            arr.put("MenuNextId",s.getMenuNextId());
            re.add(arr);
        }
        return R.ok().put("data",re);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MechanicalLeaseEntity s = mechanicalLeaseService.selectById(id);
        MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
        vo.setId(s.getId());
        vo.setTitle(s.getTitle());
        vo.setStatus(s.getStatus());
        vo.setImagesUrl(s.getImagesUrl().replaceAll("[\\[\\]\\\"]","").split(","));
        vo.setLeaseholdPrice(s.getLeaseholdPrice());
        vo.setCreateTime(s.getCreateTime());
        vo.setAlterTime(s.getAlterTime());
        vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
        vo.setMenuRootName(menuRootService.selectById(s.getMenuRootId()).getMenuName());
        vo.setMenuNextName(menuNextService.selectById(s.getMenuNextId()).getMenuName());
        vo.setDescriptions(s.getDescriptions());
        vo.setLinkMan(s.getLinkMan());
        vo.setUseDays(s.getUseDays());
        vo.setContactNumber(s.getContactNumber());
        vo.setFactoryTime(s.getFactoryTime());
        vo.setTonnage(s.getTonnage());
        vo.setWorkingLife(s.getWorkingLife());
        vo.setModel(s.getModel());
        vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
        return R.ok().put("mechanicalLease", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MechanicalLeaseEntity mechanicalLease)  {
        mechanicalLease.setImagesUrl(mechanicalLease.getImagesUrl().replaceAll("[\\[\\]\\\"]",""));
        mechanicalLease.setCreateTime(new Date());
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
    }

    /**
     * 列表查询
     * @param params
     * @return
     */
    @GetMapping("/query")
    public R querylist(@RequestParam Map<String, Object> params){
        PageUtils page = mechanicalLeaseService.queryPage(params);
        List<MechanicalLeaseEntity> content = (List<MechanicalLeaseEntity>) page.getContent();
        List<MechanicalLeaseEntityVo> vos = new ArrayList<>();
        for(MechanicalLeaseEntity s : content){
            MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setStatus(s.getStatus());
            vo.setImagesUrl(s.getImagesUrl().replaceAll("[\\[\\]\\\"]","").split(","));
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
            vo.setUseDays(s.getUseDays());
            vo.setTonnage(s.getTonnage());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setModel(s.getModel());
            vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }




    /**
     * 列表
     */
    @GetMapping("/hotlist")
    public R hotlist() {
        HashMap parms = new LinkedHashMap<>();
        parms.put("currentPage", "1");
        parms.put("pageSize", "3");
        PageUtils page = mechanicalLeaseService.queryPage1(parms);
        List<MechanicalLeaseEntity> content = (List<MechanicalLeaseEntity>) page.getContent();
        List<MechanicalLeaseEntityVo> vos = new ArrayList<>();
        for(MechanicalLeaseEntity s : content){
            MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setStatus(s.getStatus());
            vo.setImagesUrl(s.getImagesUrl().replaceAll("[\\[\\]\\\"]","").split(","));
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
            vo.setUseDays(s.getUseDays());
            vo.setTonnage(s.getTonnage());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setModel(s.getModel());
            vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
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
        PageUtils page = mechanicalLeaseService.MyqueryPage(params);
        List<MechanicalLeaseEntity> content = (List<MechanicalLeaseEntity>) page.getContent();
        List<MechanicalLeaseEntityVo> vos = new ArrayList<>();
        for(MechanicalLeaseEntity s : content){
            MechanicalLeaseEntityVo vo = new MechanicalLeaseEntityVo();
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setStatus(s.getStatus());
            vo.setImagesUrl(s.getImagesUrl().replaceAll("[\\[\\]\\\"]","").split(","));
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
            vo.setUseDays(s.getUseDays());
            vo.setTonnage(s.getTonnage());
            vo.setWorkingLife(s.getWorkingLife());
            vo.setModel(s.getModel());
            vo.setAreaName(areaService.selectById(s.getAreaId()).getTreeNames());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MechanicalLeaseEntity mechanicalLease){
			mechanicalLeaseService.updateById(mechanicalLease);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			mechanicalLeaseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 根据用户id和租赁id删除租赁
     */
    @DeleteMapping("/deleteByUserIdWithId")
    public R deleteByUserIdWithId(@RequestParam Map<String, Object> params){
        if (params.get("id") == null){
            return R.error("必须提供ID");
        }
        if (params.get("userId") == null){
            return R.error("必须提供用户ID");
        }
        mechanicalLeaseService.deleteByIdWithUserId(params);
        return R.ok();
    }

}
