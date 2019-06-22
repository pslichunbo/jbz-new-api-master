package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.MaintenancePersonTypeService;
import io.renren.modules.app.vo.MaintenancePersonVo;
import io.renren.modules.app.vo.PersonVo;
import io.renren.modules.app.vo.PersonVos;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MaintenancePersonDao;
import io.renren.modules.app.entity.MaintenancePersonEntity;
import io.renren.modules.app.service.MaintenancePersonService;


@Service("maintenancePersonService")
public class MaintenancePersonServiceImpl extends ServiceImpl<MaintenancePersonDao, MaintenancePersonEntity> implements MaintenancePersonService {

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private AreaService areaService;

    @Autowired
    private MaintenancePersonTypeService maintenancePersonTypeService;

    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper<MaintenancePersonEntity> wrapper = new EntityWrapper<>(new MaintenancePersonEntity());
        if (params.get("areaId") != null){
            wrapper.eq("area_id",params.get("areaId"));
        }
        if (params.get("typeId") != null){
            wrapper.eq("type_id",params.get("typeId"));
        }
        wrapper.orderBy("create_time",false);
        Page<MaintenancePersonEntity> page = this.selectPage(
                new Query<MaintenancePersonEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        Page<MaintenancePersonEntity> page = this.selectPage(
                new Query<MaintenancePersonEntity>(params).getPage(),
                new EntityWrapper<MaintenancePersonEntity>()
                .orderBy("create_time",false)
        );
        return new PageUtils(page);
    }

    public PageUtils queryAll(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<MaintenancePersonEntity> page = this.selectPage(
                new Query<MaintenancePersonEntity>(params).getPage(),
                new EntityWrapper<>(new MaintenancePersonEntity())
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public PageUtils queryAllByArea(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String area = params.get("area").toString();
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<MaintenancePersonEntity> page = this.selectPage(
                new Query<MaintenancePersonEntity>(params).getPage(),
                new EntityWrapper<>(new MaintenancePersonEntity())
                .like("address",area)
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public PageUtils queryByPhone(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String phone = params.get("phone").toString();
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<MaintenancePersonEntity> page = this.selectPage(
                new Query<MaintenancePersonEntity>(params).getPage(),
                new EntityWrapper<>(new MaintenancePersonEntity())
                .where("phone ="+phone)
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public boolean removeById(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long userId = Long.parseLong(params.get("userId").toString());
        EntityWrapper ew = new EntityWrapper(new MaintenancePersonEntity());
        ew.where("user_id = {0} and `id` = {1}",userId,id);

        return this.delete(ew);
    }

    public List<PersonVos> queryByIndex(){
        EntityWrapper ew = new EntityWrapper(new MaintenancePersonEntity());
        ew.orderBy("create_time",false);
        List<MaintenancePersonEntity> collect = (List<MaintenancePersonEntity>) this.selectList(ew).stream().limit(3).collect(Collectors.toList());
        List<PersonVos> list = new ArrayList<>();
        for (MaintenancePersonEntity m : collect){
            PersonVos vos = new PersonVos();
            AreaEntity areaEntity = areaServiceImpl.selectById(m.getAreaId());
            vos.setAreaName(areaEntity.getTreeNames());
            vos.setName(m.getName());
            vos.setSkillScope(m.getSkillScope());
            String[] split = m.getHeadPortrait()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            vos.setHeadPortrait(split[0]);
            Long sex = m.getSex();
            if (sex == 0){
                vos.setSex("男");
            }
            if (sex == 1){
                vos.setSex("女");
            }

            list.add(vos);
        }
        return list;
    }
    /**
     * 封装视图对象
     */
    public PersonVo getVo(MaintenancePersonEntity entity){
        PersonVo vo = new PersonVo();
        vo.setHeadPortrait(entity.getHeadPortrait());
        vo.setAddress(areaServiceImpl.selectById(entity.getAreaId()).getTreeNames());
        vo.setAddressInf(entity.getAddressInf());
        vo.setCreateTime(entity.getCreateTime());
        vo.setDeleteTime(entity.getDeleteTime());
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setPhone(entity.getPhone());
        vo.setSex(entity.getSex());
        vo.setSkillScope(entity.getSkillScope());
        vo.setTypeName(maintenancePersonTypeService.selectById(entity.getTypeId()).getName());
        vo.setUserName(sysUserService.selectById(entity.getUserId()).getUsername());
        if (entity.getWorkPortrait() != null){
            vo.setWorkPortrait(
                    entity.getWorkPortrait()
                            .replaceAll("[\\[\\]\\\"]","")
                            .split(",")
            );
        }else {
            vo.setWorkPortrait(null);
        }
        vo.setAlterTime(entity.getAlterTime());
        return vo;
    }

    public PersonVo getPersionVo(MaintenancePersonEntity entity){
        PersonVo vo = new PersonVo();
        if (entity.getAddressInf() == null || entity.getAddressInf().equals("")){
            vo.setAddressInf(null);
        }else {
            vo.setAddressInf(entity.getAddressInf());
        }

        vo.setAddress(areaServiceImpl.selectById(entity.getAreaId()).getTreeNames());
        vo.setHeadPortrait(entity.getHeadPortrait());
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setPhone(entity.getPhone());
        vo.setSex(entity.getSex());
        vo.setWorkPortrait(entity.getWorkPortrait().split(","));
        vo.setAlterTime(entity.getAlterTime());
        vo.setUserName(sysUserService.selectById(entity.getUserId()).getUsername());
        vo.setTypeName(maintenancePersonTypeService.selectById(entity.getTypeId()).getName());
        vo.setSkillScope(entity.getSkillScope());
        vo.setId(entity.getId());
        vo.setDeleteTime(entity.getDeleteTime());
        vo.setCreateTime(entity.getCreateTime());
        vo.setHeadPortrait(entity.getHeadPortrait());
        vo.setTypeId(entity.getTypeId());
        vo.setUserId(entity.getUserId().toString());
        vo.setAreaId(Long.parseLong(entity.getAreaId()));
        vo.setCityId(Long.parseLong(areaService.selectById(vo.getAreaId()).getParentCode()));
        vo.setProviceId(Long.parseLong(areaService.selectById(vo.getCityId()).getParentCode()));
        return vo;
    }

    public MaintenancePersonEntity selectByUserId(Long userId){
        EntityWrapper<MaintenancePersonEntity> wrapper = new EntityWrapper<>(new MaintenancePersonEntity());
        wrapper.eq("user_id",userId);
        return this.selectOne(wrapper);
    }
}
