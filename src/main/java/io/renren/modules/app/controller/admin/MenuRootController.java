package io.renren.modules.app.controller.admin;

import java.util.*;

import com.alibaba.fastjson.JSON;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.app.entity.MenuNextEntity;
import io.renren.modules.app.service.impl.MenuNextServiceImpl;
import io.renren.modules.app.service.impl.MenuRootServiceImpl;
import io.renren.modules.app.vo.MenuNextVo;
import io.renren.modules.app.vo.MenuRootVo;
import io.renren.modules.app.vo.menuAllVo;
import io.renren.modules.app.vo.menuallNextVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MenuRootEntity;
import io.renren.modules.app.service.MenuRootService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 一级分类表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("app/menuroot")
public class MenuRootController {
    @Autowired
    private MenuRootService menuRootService;
    @Autowired
    private MenuRootServiceImpl menuRootServiceImpl;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MenuNextServiceImpl menuNextServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:menuroot:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuRootService.queryPage(params);
        List<MenuRootEntity> content = (List<MenuRootEntity>) page.getContent();
        List<MenuRootVo> list = new ArrayList<>();
        for (MenuRootEntity s : content){
            MenuRootVo vo = new MenuRootVo();
            SysUserEntity sysUserEntity = sysUserService.selectById(s.getUserId());
            if(sysUserEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setMenuName(s.getMenuName());
            vo.setState(s.getState());
            vo.setSortIndex(s.getSortIndex());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
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
//    @RequiresPermissions("app:menuroot:info")
    public R info(@PathVariable("id") Long id){
			MenuRootEntity menuRoot = menuRootService.selectById(id);
        return R.ok().put("data", menuRoot);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:menuroot:save")
    public R save(@RequestBody MenuRootEntity menuRoot){
        if (menuRoot.getUserId() == null || menuRoot.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        menuRoot.setCreateTime(new Date());
        menuRoot.setCreateTime(new Date());
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        menuRoot.setUserId(sysUserEntity.getUserId());
        menuRootService.insert(menuRoot);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:menuroot:update")
    public R update(@RequestBody MenuRootEntity menuRoot){
        if (menuRoot.getUserId() == null || menuRoot.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        menuRoot.setAlterTime(new Date());
        menuRootService.updateById(menuRoot);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:menuroot:delete")
    public R delete(@RequestBody Long[] ids){
			menuRootService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查出所有的一级与二级列表
     */
    @GetMapping("/all")
    public R queryAll(){
        List<menuAllVo> menuAllVos=null;
        String menu = redisUtils.get("menu");
        if(StringUtils.isNotBlank(menu)){
            menuAllVos= JSON.parseArray(menu, menuAllVo.class);
        }else{
            List<MenuRootEntity> list = menuRootServiceImpl.All();
            menuAllVos = new ArrayList<>();
            for(MenuRootEntity m :list){
                menuAllVo ProvinceAdminVo = new menuAllVo();
                List<MenuNextEntity> list1 = menuNextServiceImpl.queryByRoot(m.getId());
                List<menuallNextVo>  vo = new ArrayList<>();
                for(MenuNextEntity d:list1){
                    menuallNextVo  n =  new menuallNextVo();
                    n.setLabel(d.getMenuName());
                    n.setValue(d.getId().toString());
                    vo.add(n);
                }
                ProvinceAdminVo.setChildren(vo);
                ProvinceAdminVo.setLabel(m.getMenuName());
                ProvinceAdminVo.setValue(m.getId().toString());
                menuAllVos.add(ProvinceAdminVo);
            }
            redisUtils.set("menu", JSON.toJSONString(menuAllVos),-1);
        }

        return R.ok().put("options",menuAllVos);
    }
}
