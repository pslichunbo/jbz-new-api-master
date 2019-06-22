package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.MerchantTypeEntity;
import io.renren.modules.app.vo.LabelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.LabelDao;
import io.renren.modules.app.entity.LabelEntity;
import io.renren.modules.app.service.LabelService;


@Service("labelService")
public class LabelServiceImpl extends ServiceImpl<LabelDao, LabelEntity> implements LabelService {
    @Autowired
    private MerchantTypeServiceImpl merchantTypeServiceImpl;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LabelEntity> page = this.selectPage(
                new Query<LabelEntity>(params).getPage(),
                new EntityWrapper<LabelEntity>()
        );

        return new PageUtils(page);
    }
    public List<LabelVo> selectAll(){
        EntityWrapper ew = new EntityWrapper(new LabelEntity());
        ew.where("del_sign = 'false' and state = 'ENABLE'");
        List<LabelVo> objects = new ArrayList<>();

        List<LabelEntity> list = this.selectList(ew);

        for (LabelEntity l : list){
            Long typeId = l.getTypeId();
            MerchantTypeEntity entity = merchantTypeServiceImpl.selectById(typeId);
            LabelVo vo = new LabelVo();
            vo.setId(l.getId());
            vo.setName(l.getName());
            vo.setDescription(l.getDescription());
            vo.setType(entity.getKey());
            vo.setDelSign(l.getDelSign());
            vo.setCreateTime(l.getCreateTime());
            vo.setAlterTime(l.getAlterTime());
            vo.setDeleteTime(l.getDeleteTime());
            vo.setState(l.getState());
            vo.setSortIndex(l.getSortIndex());
            objects.add(vo);
        }
       return objects;
    }

    public List<LabelEntity> queryById(Long id){
        EntityWrapper ew = new EntityWrapper(new LabelEntity());
        ew.where("id ="+id);
        return this.selectList(ew);
    }
    public List<LabelEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new LabelEntity());
        ew.where("state = 'ENABLE'");
        return this.selectList(ew);
    }
}
