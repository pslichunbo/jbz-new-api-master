package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.LabelTypeDao;
import io.renren.modules.app.entity.LabelTypeEntity;
import io.renren.modules.app.service.LabelTypeService;


@Service("labelTypeService")
public class LabelTypeServiceImpl extends ServiceImpl<LabelTypeDao, LabelTypeEntity> implements LabelTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LabelTypeEntity> page = this.selectPage(
                new Query<LabelTypeEntity>(params).getPage(),
                new EntityWrapper<LabelTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<LabelTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new LabelTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
