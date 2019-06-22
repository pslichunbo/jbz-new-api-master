package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.service.impl.PropertyServiceImpl;
import io.renren.modules.app.vo.PropertyEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.PropertyEntity;
import io.renren.modules.app.service.PropertyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 属性
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@RestController
@RequestMapping("app/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyServiceImpl propertyServiceimpl;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:property:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = propertyService.queryPage(params);
        List<PropertyEntity> content = (List<PropertyEntity>) page.getContent();
        List<PropertyEntityVo> vos = new ArrayList<>();
        for(PropertyEntity s : content){
            PropertyEntityVo Vo = new PropertyEntityVo();
            Vo.setId(s.getId());
            Vo.setCreateTime(s.getCreateTime());
            Vo.setAlterTime(s.getAlterTime());
            Vo.setDeleteTime(s.getDeleteTime());
            Vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
            Vo.setName(s.getName());
            vos.add(Vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:property:info")
    public R info(@PathVariable("id") Long id){
        PropertyEntity s = propertyService.selectById(id);
        PropertyEntityVo Vo = new PropertyEntityVo();
        Vo.setId(s.getId());
        Vo.setCreateTime(s.getCreateTime());
        Vo.setAlterTime(s.getAlterTime());
        Vo.setDeleteTime(s.getDeleteTime());
        Vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
        Vo.setUserId(s.getUserId());
        Vo.setName(s.getName());
        return R.ok().put("property", Vo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:property:save")
    public R save(@RequestBody PropertyEntity property){
        property.setCreateTime(new Date());
			propertyService.insert(property);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:property:update")
    public R update(@RequestBody PropertyEntity property){
        property.setAlterTime(new Date());
			propertyService.updateById(property);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:property:delete")
    public R delete(@RequestBody Long[] ids){
			propertyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
