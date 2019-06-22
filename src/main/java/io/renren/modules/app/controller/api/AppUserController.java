package io.renren.modules.app.controller.api;


import io.renren.common.utils.R;
import io.renren.modules.app.service.CodeService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("au/user")
public class AppUserController  {

    @Autowired
    private CodeService codeService;

    @Autowired
    private SysUserService sysUserService;

    @PutMapping("update")
    public R updateUser(@RequestBody SysUserEntity user){
        if (user.getUserId() == null){
            return R.error("必须提供用户ID");
        }
        boolean b = sysUserService.updateById(user);
        if(b){
            return R.ok("修改成功！");
        }else {
            return R.ok("修改失败！");
        }
    }


    @GetMapping("/messages")
    public R findPasswd(@RequestParam Map<String, Object> params){
        String phone = (String) params.get("phone");
        String code = (String) params.get("code");
        String password = (String) params.get("password");
        String c = codeService.code(phone);
        if(c.equals(code)){
            SysUserEntity pw = sysUserService.queryByMobile(phone);
            pw.setPassword(DigestUtils.sha256Hex(password));
            boolean b = sysUserService.updateById(pw);
            if(b){
                return R.ok("修改成功！");
            }else {
                return R.ok("修改失败！");
            }
        }
        else {
            return R.error(400,"验证码错误！");
        }
    }

    /**
     * 修改密码
     * @param params
     * @return
     */
    @GetMapping("/pw")
    public R upPasswd(@RequestParam Map<String, Object> params){
        String password = (String) params.get("password");
        String userid = (String) params.get("userId");
        SysUserEntity sysUserEntity = sysUserService.selectById(userid);
        sysUserEntity.setPassword(DigestUtils.sha256Hex(password));
        sysUserService.updateById(sysUserEntity);
            return R.ok("修改成功！");
        }


    @GetMapping("/info/{id}")
    public R infoUser(@PathVariable("id") String id){
        SysUserEntity userinfo = sysUserService.selectById(id);
        userinfo.setPassword(null);
        return R.ok().put("data",userinfo);
    }

    @GetMapping("/sign/{id}")
    public R sign(@PathVariable("id") Long userId) throws Exception{

        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
        Date lastSignTime = sysUserEntity.getLastSignTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parse = formatter.format(lastSignTime);
        String  parse1 = formatter.format(new Date());
        if(!(parse1.equals(parse))){
            if("".equals(sysUserEntity.getSignNumber()) || sysUserEntity.getSignNumber() == null){
                sysUserEntity.setSignNumber("0");
            }
            int number = Integer.parseInt(sysUserEntity.getSignNumber());
            number++;

            SysUserEntity sysUser = new SysUserEntity();
            sysUser.setUserId(userId);
            sysUser.setLastSignTime(new Date());
            sysUser.setSignNumber(String.valueOf(number));
            sysUserService.updateById(sysUser);
            return R.ok("签到成功！");
        }
        return R.error(400,"今天已经签到！");

    }


}
