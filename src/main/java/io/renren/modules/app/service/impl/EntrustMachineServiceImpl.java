package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.MechanicalLeaseEntity;
import io.renren.modules.app.vo.EntrustMachineEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.EntrustMachineDao;
import io.renren.modules.app.entity.EntrustMachineEntity;
import io.renren.modules.app.service.EntrustMachineService;


@Service("entrustMachineService")
public class EntrustMachineServiceImpl extends ServiceImpl<EntrustMachineDao, EntrustMachineEntity> implements EntrustMachineService {

    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntrustMachineEntity> page = this.selectPage(
                new Query<EntrustMachineEntity>(params).getPage(),
                new EntityWrapper<EntrustMachineEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils MyqueryPage(Map<String, Object> params) {
        Page<EntrustMachineEntity> page = this.selectPage(
                new Query<EntrustMachineEntity>(params).getPage(),
                new EntityWrapper<EntrustMachineEntity>().where("user_id = {0}",params.get("userId"))
        );
        return new PageUtils(page);
    }

    public EntrustMachineEntityVo getEntrustMachineEntityVo(EntrustMachineEntity entrustMachineEntity){
        EntrustMachineEntityVo vo = new EntrustMachineEntityVo();
        vo.setId(entrustMachineEntity.getId());
        vo.setLinkPhone(entrustMachineEntity.getLinkPhone());
        vo.setCreateTime(entrustMachineEntity.getCreateTime());
        vo.setRequirements(entrustMachineEntity.getRequirements());
        vo.setUserName(sysUserService.selectById(entrustMachineEntity.getUserId()).getUsername());
        return vo;
    }

}
