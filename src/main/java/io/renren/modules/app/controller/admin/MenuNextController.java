package io.renren.modules.app.controller.admin;
import java.util.*;
import io.renren.modules.app.entity.MenuRootEntity;
import io.renren.modules.app.service.MenuRootService;
import io.renren.modules.app.service.impl.MenuNextServiceImpl;
import io.renren.modules.app.vo.MenuNextVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.MenuNextService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 二级分类表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("app/menunext")
public class MenuNextController {
    @Autowired
    private MenuNextService menuNextService;
    @Autowired
    private MenuNextServiceImpl menuNextServiceImpl;
    @Autowired
    private MenuRootService menuRootService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:menunext:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuNextService.queryPage(params);
        List<MenuNextEntity> content = (List<MenuNextEntity>) page.getContent();

        List<MenuNextVo> list = new ArrayList<>();
        for(MenuNextEntity s : content){
            MenuNextVo vo = new MenuNextVo();
            SysUserEntity sysUserEntity = sysUserService.selectById(s.getUserId());
            if(sysUserEntity == null){
                return R.error("数据查询错误！");
            }
            MenuRootEntity menuRootEntity = menuRootService.selectById(s.getMenuRootId());
            if(menuRootEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setMenuName(s.getMenuName());
            vo.setState(s.getState());
            vo.setSortIndex(s.getSortIndex());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setMenuRootName(menuRootEntity.getMenuName());
            vo.setName(sysUserEntity.getUsername());
            vo.setImageUrl(s.getImageUrl());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:menunext:info")
    public R info(@PathVariable("id") Long id){
			MenuNextEntity menuNext = menuNextService.selectById(id);

        return R.ok().put("data", menuNext);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:menunext:save")
    public R save(@RequestBody MenuNextEntity menuNext){
        if (menuNext.getMenuRootId() == null || menuNext.getMenuRootId().equals("")){
            return R.error("一级列表不能为空");
        }
        if (menuNext.getUserId() == null || menuNext.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        menuNext.setCreateTime(new Date());
        SysUserEntity user  = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        menuNext.setUserId(user.getUserId());
		menuNextService.insert(menuNext);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:menunext:update")
    public R update(@RequestBody MenuNextEntity menuNext){
        if (menuNext.getMenuRootId() == null || menuNext.getMenuRootId().equals("")){
            return R.error("一级列表不能为空");
        }
        if (menuNext.getUserId() == null || menuNext.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        menuNext.setAlterTime(new Date());
        menuNextService.updateById(menuNext);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:menunext:delete")
    public R delete(@RequestBody Long[] ids){
			menuNextService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *根据一级列表id查询对应的二级列表接口lyj
     */
    @GetMapping("/queryByRootId/{rootId}")
    public R selectByRootId(@PathVariable("rootId") Long rootId){
        List<MenuNextEntity> list = menuNextServiceImpl.queryByRoot(rootId);
        return R.ok().put("data",list);
    }
    /**
     *查询所有二级列表
     */
    @GetMapping("/all")
    public R selectAll(){
        List<MenuNextEntity> list = menuNextServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
