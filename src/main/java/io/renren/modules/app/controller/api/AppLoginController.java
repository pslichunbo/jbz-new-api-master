package io.renren.modules.app.controller.api;


import io.renren.common.utils.R;
import io.renren.common.utils.RedisUtils;
import io.renren.common.utils.ShiroUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.form.LoginForm;
import io.renren.modules.app.service.CodeService;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysCaptchaService;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.SysUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * APP登录授权
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
@Api("APP登录接口")
public class AppLoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return R.error("验证码不正确");
        }
        long userId = sysUserService.login(form);
        if(userId == 400L){
            return R.error(400,"该手机号还未注册，请先注册");
        }
        if(userId == 405L){
            return R.error(401,"密码错误！");
        }
        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
//        redisUtils.set(userId+"",sysUserEntity);
//        System.out.println(redisUtils.get(userId+""));
//        //生成token
//        String token = jwtUtils.generateToken(userId);
//        //生成token
        R r = sysUserTokenService.createToken(userId);
        return R.ok().put("token",r.get("token")).put("data",sysUserEntity);
    }
    /**
     *找回密码
     */
    @GetMapping("/find")
    public R findPasswd(@RequestParam Map<String, Object> params) {
        String phone = (String) params.get("phone");
        String code = (String) params.get("code");
        String password = (String) params.get("password");
        String c = codeService.code(phone);
        if (c.equals(code)) {
            SysUserEntity pw = sysUserService.queryByMobile(phone);
            pw.setPassword(DigestUtils.sha256Hex(password));
            boolean b = sysUserService.updateById(pw);
            if (b) {
                return R.ok("找回成功！，请重新登录");
            } else {
                return R.ok("联系管理员！");
            }

        } else {
            return R.error(400, "验证码错误！");
        }

    }
    /**
     *退出
     */
    @GetMapping("/loginOut/{userId}")
    public R logOut(@PathVariable("userId") String userId){
        long aLong = Long.parseLong(userId);
        sysUserTokenService.logout(aLong);
        return R.ok("登出成功！");
    }
}
