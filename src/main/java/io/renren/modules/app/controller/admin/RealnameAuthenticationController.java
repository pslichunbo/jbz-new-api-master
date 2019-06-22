package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.app.entity.MessageEntity;
import io.renren.modules.app.service.MessageService;
import io.renren.modules.app.service.impl.RealnameAuthenticationServiceImpl;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import io.renren.modules.app.service.RealnameAuthenticationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.annotation.Resource;


/**
 * 实名认证表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 15:27:28
 */
@RestController
@RequestMapping("app/Adminrealnameauthentication")
public class RealnameAuthenticationController {
    @Autowired
    private RealnameAuthenticationService realnameAuthenticationService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MessageService messageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:realnameauthentication:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = realnameAuthenticationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:realnameauthentication:info")
    public R info(@PathVariable("id") Integer id){
			RealnameAuthenticationEntity realnameAuthentication = realnameAuthenticationService.selectById(id);


        return R.ok().put("data", realnameAuthentication);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:realnameauthentication:save")
    public R save(@RequestBody RealnameAuthenticationEntity realnameAuthentication){
		realnameAuthenticationService.insert(realnameAuthentication);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:realnameauthentication:update")
    public R update(@RequestBody RealnameAuthenticationEntity realnameAuthentication){
			realnameAuthenticationService.updateById(realnameAuthentication);
                SysUserEntity sysUserEntity = sysUserService.selectById(realnameAuthentication.getUserId());
                sysUserEntity.setRealName(realnameAuthentication.getName());
                sysUserEntity.setRealnameId(realnameAuthentication.getId().toString());
                sysUserService.updateById(sysUserEntity);
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setCreateTime(new Date());
                messageEntity.setTitle("【系统消息】");
                messageEntity.setUserId(realnameAuthentication.getUserId());
                messageEntity.setContent("恭喜您实名认证通过！");
                messageEntity.setDelSign(0L);
                messageEntity.setReadSign(0L);
                messageEntity.setTypeId(0L);
                messageService.insert(messageEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:realnameauthentication:delete")
    public R delete(@RequestBody Integer[] ids){
			realnameAuthenticationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
