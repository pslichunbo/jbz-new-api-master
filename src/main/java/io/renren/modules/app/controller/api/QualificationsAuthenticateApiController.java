package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.modules.app.service.impl.QualificationsAuthenticateServiceImpl;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.service.QualificationsAuthenticateService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;






/**
 * 身份
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 14:59:42
 */
@RestController
@RequestMapping("app/qualificationsauthenticate")
public class QualificationsAuthenticateApiController {
    @Autowired
    private QualificationsAuthenticateService qualificationsAuthenticateService;
    @Autowired
    private QualificationsAuthenticateServiceImpl qualificationsAuthenticateServiceImpl;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qualificationsAuthenticateService.queryPage(params);

        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
			QualificationsAuthenticateEntity qualificationsAuthenticate = qualificationsAuthenticateService.selectById(id);

        return R.ok().put("data", qualificationsAuthenticate);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody QualificationsAuthenticateEntity qualificationsAuthenticate){
        QualificationsAuthenticateEntity qualificationsAuthenticateEntity = qualificationsAuthenticateServiceImpl.getByUserId(qualificationsAuthenticate.getUserId());
        if (qualificationsAuthenticateEntity != null){
            if (qualificationsAuthenticateEntity.getState() == 0){
                return R.error("你的驾驶资格认证审核中，请耐心等待");
            }
            if (qualificationsAuthenticateEntity.getState() == 2){
                QualificationsAuthenticateEntity byUserId = qualificationsAuthenticateServiceImpl.getByUserId(qualificationsAuthenticateEntity.getUserId());
                qualificationsAuthenticateService.deleteById(byUserId);
                qualificationsAuthenticate.setCreateTime(new Date());
                qualificationsAuthenticate.setState(0L);
                qualificationsAuthenticateService.insert(qualificationsAuthenticate);
            }
        }else {
            qualificationsAuthenticate.setCreateTime(new Date());
            qualificationsAuthenticate.setState(0L);
            qualificationsAuthenticateService.insert(qualificationsAuthenticate);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody QualificationsAuthenticateEntity qualificationsAuthenticate){
        qualificationsAuthenticate.setAlterTime(new Date());
			qualificationsAuthenticateService.updateById(qualificationsAuthenticate);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
			qualificationsAuthenticateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
