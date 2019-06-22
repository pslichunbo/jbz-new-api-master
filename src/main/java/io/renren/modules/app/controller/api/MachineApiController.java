package io.renren.modules.app.controller.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.CommodityBrandEntity;
import io.renren.modules.app.entity.PropertyEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MachineEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("au/machine")
public class MachineApiController {
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
    @GetMapping("/list")
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
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 首页列表
     */
    @GetMapping("/query")
    public R querylist(@RequestParam Map<String, Object> params){
        PageUtils page = machineService.queryPage1(params);
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
        return R.ok().put("data", vo);
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MachineEntity machine){
			machineService.insert(machine);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MachineEntity machine){
			machineService.updateById(machine);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			machineService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
