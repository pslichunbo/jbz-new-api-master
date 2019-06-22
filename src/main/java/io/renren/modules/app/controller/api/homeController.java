package io.renren.modules.app.controller.api;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.MachineEntity;
import io.renren.modules.app.service.*;
import io.renren.modules.app.vo.MachineEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/machine")
public class homeController {

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
            vo.setWorkingLife(s.getWorkingLife());
            vo.setTonnage(s.getTonnage());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }

}
