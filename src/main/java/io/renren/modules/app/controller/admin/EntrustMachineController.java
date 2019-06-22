package io.renren.modules.app.controller.admin;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.renren.modules.app.service.SourceGoodsListService;
import io.renren.modules.app.vo.EntrustMachineEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.EntrustMachineEntity;
import io.renren.modules.app.service.EntrustMachineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:51:31
 */
@RestController
@RequestMapping("app/entrustmachine")
public class EntrustMachineController {
    @Autowired
    private EntrustMachineService entrustMachineService;

    @Autowired
    private SourceGoodsListService sourceGoodsListService;

    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:entrustmachine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entrustMachineService.queryPage(params);
        List<EntrustMachineEntity> content = (List<EntrustMachineEntity>) page.getContent();
        List<EntrustMachineEntityVo> vos = new ArrayList<>();
        for(EntrustMachineEntity s : content){
            EntrustMachineEntityVo vo = new EntrustMachineEntityVo();
            vo.setId(s.getId());
            vo.setLinkPhone(s.getLinkPhone());
            vo.setCreateTime(s.getCreateTime());
            vo.setRequirements(s.getRequirements().replaceAll("<([^>]*)>",""));
            vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());
            vos.add(vo);
        }
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:entrustmachine:info")
    public R info(@PathVariable("id") Integer id){
        EntrustMachineEntity s = entrustMachineService.selectById(id);
        EntrustMachineEntityVo vo = new EntrustMachineEntityVo();
        vo.setId(s.getId());
        vo.setLinkPhone(s.getLinkPhone());
        vo.setCreateTime(s.getCreateTime());
        vo.setRequirements(s.getRequirements().replaceAll("<([^>]*)>",""));
        vo.setUserName(sysUserService.selectById(s.getUserId()).getUsername());

        return R.ok().put("entrustmachine", s);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:entrustmachine:save")
    public R save(@RequestBody EntrustMachineEntity entrustMachine){
        if (entrustMachine.getUserId() == null || entrustMachine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (entrustMachine.getLinkPhone().length() != 11){
            return R.error("手机号必须为11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            boolean matches = compile.matcher(entrustMachine.getLinkPhone()).matches();
            if (matches){
                entrustMachine.setCreateTime(new Date());
                entrustMachine.setRequirements(entrustMachine.getRequirements().replaceAll("<([^>]*)>",""));
                entrustMachineService.insert(entrustMachine);
                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:entrustmachine:update")
    public R update(@RequestBody EntrustMachineEntity entrustMachine){
        if (entrustMachine.getUserId() == null || entrustMachine.getUserId().equals("")){
            return R.error("用户不能为空");
        }
        if (entrustMachine.getLinkPhone().length() != 11){
            return R.error("手机号必须是11位");
        }else {
            Pattern compile = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
            Matcher matcher = compile.matcher(entrustMachine.getLinkPhone());
            boolean matches = matcher.matches();
            if (matches){
                entrustMachine.setRequirements(entrustMachine.getRequirements().replaceAll("<([^>]*)>",""));
                entrustMachineService.updateById(entrustMachine);
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
//    @RequiresPermissions("app:entrustmachine:delete")
    public R delete(@RequestBody Integer[] ids){
			entrustMachineService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
