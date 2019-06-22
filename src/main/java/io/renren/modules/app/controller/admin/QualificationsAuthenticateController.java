package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.modules.app.entity.MessageEntity;
import io.renren.modules.app.service.MessageService;
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

import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.service.QualificationsAuthenticateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.annotation.Resource;


/**
 * 身份
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 14:59:42
 */
@RestController
@RequestMapping("app/Adminqualificationsauthenticate")
public class QualificationsAuthenticateController {
    @Autowired
    private QualificationsAuthenticateService qualificationsAuthenticateService;

    @Resource
    private SysUserDao sysUserDao;

    @Autowired
    private MessageService messageService;



    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:qualificationsauthenticate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qualificationsAuthenticateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:qualificationsauthenticate:info")
    public R info(@PathVariable("id") Integer id){
			QualificationsAuthenticateEntity qualificationsAuthenticate = qualificationsAuthenticateService.selectById(id);

        return R.ok().put("data", qualificationsAuthenticate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:qualificationsauthenticate:save")
    public R save(@RequestBody QualificationsAuthenticateEntity qualificationsAuthenticate){
			qualificationsAuthenticateService.insert(qualificationsAuthenticate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:qualificationsauthenticate:update")
    public R update(@RequestBody QualificationsAuthenticateEntity qualificationsAuthenticate){
			qualificationsAuthenticateService.updateById(qualificationsAuthenticate);
			if(qualificationsAuthenticate.getState() == 1){
                SysUserEntity user = sysUserDao.selectById(qualificationsAuthenticate.getUserId());
                user.setIdentityAttestationId(qualificationsAuthenticate.getId().toString());
                sysUserDao.updateById(user);
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setCreateTime(new Date());
                messageEntity.setTitle("【系统消息】");
                messageEntity.setUserId(qualificationsAuthenticate.getUserId());
                messageEntity.setContent("恭喜您的驾驶资格认证通过！");
                messageEntity.setDelSign(0L);
                messageEntity.setReadSign(0L);
                messageEntity.setTypeId(0L);
                messageService.insert(messageEntity);


            }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:qualificationsauthenticate:delete")
    public R delete(@RequestBody Integer[] ids){
			qualificationsAuthenticateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
