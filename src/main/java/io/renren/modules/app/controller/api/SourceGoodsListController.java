package io.renren.modules.app.controller.api;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.SourceGoodsListService;
import io.renren.modules.app.service.SourceGoodsService;
import io.renren.modules.app.service.impl.QualificationsAuthenticateServiceImpl;
import io.renren.modules.app.service.impl.SourceGoodsServiceImpl;
import io.renren.modules.app.vo.ApiSourceVo;
import io.renren.modules.sys.dao.SysUserTokenDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import io.renren.modules.sys.service.SysUserTokenService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AuLogin")
public class SourceGoodsListController {

    @Autowired
    private SourceGoodsService sourceGoodsService;

    @Autowired
    private SourceGoodsListService sourceGoodsListService;


    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    private QualificationsAuthenticateServiceImpl qualificationsAuthenticateServiceImpl;

    @Resource
    private SysUserTokenDao tokenDao;

    @Autowired
    private SourceGoodsServiceImpl sourceGoodsServiceImpl;

    /**
     *货车找货[jin]
     *
     */
    @GetMapping("/allGoods")
    public R selectAllGoods(@RequestParam Map<String, Object> params){
                    //查询货源列表进行展示
        PageUtils pageUtils = sourceGoodsService.selectPage(params);
        List<SourceGoodsEntity> content = (List<SourceGoodsEntity>) pageUtils.getContent();
        List<ApiSourceVo> list = new ArrayList<>();
        for (SourceGoodsEntity s : content) {
            list.add(sourceGoodsServiceImpl.getVo(s));
        }
        pageUtils.setContent(list);
        return R.ok().put("data",pageUtils);
    }


    /**
     * 判断是否实名认证接口{金海涛}
     *
    **/
    @GetMapping("/realName/{token}")
    public R realName(@PathVariable("token") String token){
        SysUserTokenEntity sysUserTokenEntity = tokenDao.queryByToken(token);
        if (sysUserTokenEntity == null){
            return R.error("token已过期，请重新登录");
        }
        int issuedqualification = sourceGoodsListService.issuedqualification(sysUserTokenEntity.getUserId());
        return R.ok().put("code",issuedqualification);
    }


    /**
     * 判断是否已经资格认证接口{金海涛}
     *
     **/
    @GetMapping("/quAUName/{token}")
    public R AuRealName(@PathVariable("token") String token){
        SysUserTokenEntity sysUserTokenEntity = tokenDao.queryByToken(token);
        if (sysUserTokenEntity == null){
            return R.error("token已过期，请重新登录");
        }
        int issuedqualification = sourceGoodsListService.Auissuedqualification(sysUserTokenEntity.getUserId());
        return R.ok().put("code",issuedqualification);
    }


}

