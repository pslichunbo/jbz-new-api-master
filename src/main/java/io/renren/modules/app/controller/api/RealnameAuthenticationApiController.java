package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.modules.app.service.impl.RealnameAuthenticationServiceImpl;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import io.renren.modules.app.service.RealnameAuthenticationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 实名认证表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 15:27:28
 */
@RestController
@RequestMapping("app/Adminrealnameauthentication")
public class RealnameAuthenticationApiController {
    @Autowired
    private RealnameAuthenticationService realnameAuthenticationService;
    @Autowired
    private RealnameAuthenticationServiceImpl realnameAuthenticationServiceImpl;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = realnameAuthenticationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			RealnameAuthenticationEntity realnameAuthentication = realnameAuthenticationService.selectById(id);

        return R.ok().put("data", realnameAuthentication);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody RealnameAuthenticationEntity realnameAuthentication){
        RealnameAuthenticationEntity entity = realnameAuthenticationServiceImpl.getByUserId(realnameAuthentication.getUserId());
        if (entity != null){
            if (entity.getStatus().equals("0")){
                return R.error("实名认证审核中，请耐心等待");
            }
            if (entity.getStatus().equals("2")){
                RealnameAuthenticationEntity byUserId = realnameAuthenticationServiceImpl.getByUserId(realnameAuthentication.getUserId());
                realnameAuthenticationService.deleteById(byUserId);
                realnameAuthentication.setCreateTime(new Date());
                realnameAuthentication.setStatus("0");
                realnameAuthenticationService.insert(realnameAuthentication);
            }
        }else {
            realnameAuthentication.setCreateTime(new Date());
            realnameAuthentication.setStatus("0");
            realnameAuthenticationService.insert(realnameAuthentication);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody RealnameAuthenticationEntity realnameAuthentication){
        realnameAuthentication.setAlterTime(new Date());
			realnameAuthenticationService.updateById(realnameAuthentication);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			realnameAuthenticationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
