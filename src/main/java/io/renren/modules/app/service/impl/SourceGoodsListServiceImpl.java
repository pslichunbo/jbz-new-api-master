package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.QualificationsAuthenticateService;
import io.renren.modules.app.service.RealnameAuthenticationService;
import io.renren.modules.app.service.SourceGoodsListService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SourceGoodsListServiceImpl implements SourceGoodsListService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RealnameAuthenticationService realnameAuthenticationService;

    @Autowired
    private QualificationsAuthenticateService qualificationsAuthenticateService;

    @Autowired
    private SourceGoodsListService sourceGoodsListService;





    @Override
    public int issuedqualification(Long userId) {
        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
        if(sysUserEntity.getRealnameId() == null || "".equals(sysUserEntity.getRealnameId())){
            return 3;
        }
        RealnameAuthenticationEntity realnameAuthenticationEntity = realnameAuthenticationService.selectById(sysUserEntity.getRealnameId());
        if("1".equals(realnameAuthenticationEntity.getStatus())){
            return 1;
        }
        else if("0".equals(realnameAuthenticationEntity.getStatus())) {
            return 0;
        }else if("2".equals(realnameAuthenticationEntity.getStatus())){
            return 2;
        }else {
            return 3;
        }
    }

    @Override
    public int Auissuedqualification(Long userId) {
        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
        if(sysUserEntity.getIdentityAttestationId() == null || "".equals(sysUserEntity.getIdentityAttestationId())){
            return 3;
        }
        QualificationsAuthenticateEntity qualificationsAuthenticateEntity = qualificationsAuthenticateService.selectById(sysUserEntity.getIdentityAttestationId());
        if(qualificationsAuthenticateEntity.getState() == 1 ){
            return 1;
        }else if (qualificationsAuthenticateEntity.getState() == 0){
            return 0;
        }else if (qualificationsAuthenticateEntity.getState() == 2){
            return 2;
        }else {
            return 3;
        }
    }



}
