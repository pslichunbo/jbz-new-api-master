package io.renren.modules.app.controller.api;


import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.MessageEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.CodeService;
import io.renren.modules.app.service.MessageService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/api")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private MessageService messageService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        if(sysUserService.queryByMobile(form.getMobile()) != null){
            return R.error("此手机号已注册!");
        }
        String c = codeService.code(form.getMobile());
        //获取验证码并判断输入的验证码与生成的验证码是否一致
        if(c.equals(form.getVerifyCode())){
            SysUserEntity user = new SysUserEntity();
            user.setMobile(form.getMobile());
            user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
            user.setCreateTime(new Date());
            user.setStatus(1);
            user.setType("general");
            user.setNickname(form.getMobile());
            sysUserService.insert(user);
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setCreateTime(new Date());
            messageEntity.setTitle("【系统消息】");
            messageEntity.setUserId(sysUserService.queryByMobile(form.getMobile()).getUserId());
            messageEntity.setContent("欢迎来到机帮主,实干成就梦想！");
            messageEntity.setDelSign(0L);
            messageEntity.setReadSign(0L);
            messageEntity.setTypeId(0L);
            messageService.insert(messageEntity);
        }else {
            return R.error("验证码错误");
        }
        return R.ok("注册成功");
    }
}
