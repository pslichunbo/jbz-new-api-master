package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CommodityBrandTypeDao;
import io.renren.modules.app.entity.CommodityBrandTypeEntity;
import io.renren.modules.app.service.CommodityBrandTypeService;


@Service("commodityBrandTypeService")
public class CommodityBrandTypeServiceImpl extends ServiceImpl<CommodityBrandTypeDao, CommodityBrandTypeEntity> implements CommodityBrandTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommodityBrandTypeEntity> page = this.selectPage(
                new Query<CommodityBrandTypeEntity>(params).getPage(),
                new EntityWrapper<CommodityBrandTypeEntity>()
        );

        return new PageUtils(page);
    }
    public List<CommodityBrandTypeEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new CommodityBrandTypeEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }
}
