package io.renren.modules.app.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.RealnameAuthenticationEntity;
import io.renren.modules.app.service.RealnameAuthenticationService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.QualificationsAuthenticateDao;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.service.QualificationsAuthenticateService;


@Service("qualificationsAuthenticateService")
public class QualificationsAuthenticateServiceImpl extends ServiceImpl<QualificationsAuthenticateDao, QualificationsAuthenticateEntity> implements QualificationsAuthenticateService {

@Autowired
private SysUserServiceImpl sysUserServiceImpl;
@Autowired
private QualificationsAuthenticateService qualificationsAuthenticateService;
@Autowired
private RealnameAuthenticationService realnameAuthenticationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        Page<QualificationsAuthenticateEntity> page = this.selectPage(
                new Query<QualificationsAuthenticateEntity>(params).getPage(),
                new EntityWrapper<QualificationsAuthenticateEntity>().like("name",name).and().where("state in (0,1,2)")
        );

        return new PageUtils(page);
    }
    /**
     * 根据用户id获取身份对像
     */
    public QualificationsAuthenticateEntity getByUserId(Long userId){
        EntityWrapper<QualificationsAuthenticateEntity> wrapper = new EntityWrapper<>(new QualificationsAuthenticateEntity());
        wrapper.eq("user_id",userId);
        return this.selectOne(wrapper);
    }

    public R listByDriver(){
        List<SysUserEntity> entityList = sysUserServiceImpl.selectByUser();
        List<SysUserEntity> userEntityList = new ArrayList<>();
        for (SysUserEntity userEntity : entityList){
            if (userEntity.getRealnameId() != null && userEntity.getIdentityAttestationId() != null){
                RealnameAuthenticationEntity realnameAuthenticationEntity = realnameAuthenticationService.selectById(userEntity.getRealnameId());
                QualificationsAuthenticateEntity qualificationsAuthenticateEntity = qualificationsAuthenticateService.selectById(userEntity.getIdentityAttestationId());
                if (realnameAuthenticationEntity != null && realnameAuthenticationEntity.getStatus().equals("1") && qualificationsAuthenticateEntity != null && qualificationsAuthenticateEntity.getState() == 1){
                    userEntityList.add(userEntity);
                }
            }
        }
        return R.ok().put("data",userEntityList);
    }

}
