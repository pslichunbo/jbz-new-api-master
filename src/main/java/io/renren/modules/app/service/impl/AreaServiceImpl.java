package io.renren.modules.app.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.app.entity.SeekerEntity;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.AreaDao;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.service.AreaService;


@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaEntity> page = this.selectPage(
                new Query<AreaEntity>(params).getPage(),
                new EntityWrapper<AreaEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<AreaEntity> getAreaList(String id) {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("parent_code = {0}", id);
        return this.selectList(ew);
    }

    @Override
    public AreaEntity getArea(String id) {
        return baseMapper.getArea(id);
    }


    public List<AreaEntity> queryall() {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("status = 0");
        return this.selectList(ew);
    }

    public List<AreaEntity> selectByProvide() {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("tree_level = 0 and status = 0");
        return this.selectList(ew);
    }

    public List<AreaEntity> queryByProvideId(Long provideId) {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("tree_level = 1 and status = 0 and parent_code =" + provideId);
        return this.selectList(ew);
    }

    public List<AreaEntity> selectByCountry(Long cityId) {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("tree_level = 2 and status = 0 and parent_code =" + cityId);
        return this.selectList(ew);
    }

    public AreaEntity queryByName(String areaName) {
        EntityWrapper ew = new EntityWrapper(new AreaEntity());
        ew.where("status = 0");
        ew.like("area_name", areaName);
        List<AreaEntity> list = this.selectList(ew);
        if (list != null && list.size() > 0) {
            AreaEntity areaEntity = list.get(0);
            return areaEntity;
        }
        return null;
    }

    /**
     * 省
     *
     * @return
     */
    public List<AreaEntity> getProvice() {
        EntityWrapper<AreaEntity> wrapper = new EntityWrapper<>(new AreaEntity());
        wrapper.eq("parent_code", 0);
        wrapper.eq("status", 0);
        return this.selectList(wrapper);
    }

    /**
     * 根据省id查询对应的市
     *
     * @param parentCode
     * @return
     */
    public List<AreaEntity> getCity(String parentCode) {
        EntityWrapper<AreaEntity> cityWrapper = new EntityWrapper<>(new AreaEntity());
        cityWrapper.eq("parent_code", parentCode);
        cityWrapper.eq("status", 0);
        return this.selectList(cityWrapper);
    }

    /**
     * 根据市id查询对应的区
     *
     * @param parentCode
     * @return
     */
    public List<AreaEntity> getcountry(String parentCode) {
        EntityWrapper<AreaEntity> countryWrapper = new EntityWrapper<>(new AreaEntity());
        countryWrapper.eq("status", 0);
        countryWrapper.eq("parent_code", parentCode);
        return this.selectList(countryWrapper);
    }

    /**
     * 获取全部的省市区
     * 查询出全部省
     * 根据省code查询省对应的区
     * 根据市code查询市对应的区
     * <p>
     * <p>
     * // select * from area where code in(1,2,3)
     *
     * @return
     */
    public R getAllArea() {

        List<AreaEntity> provinceList = getProvice();

        List<ProvinceVo> voList = new ArrayList<>();
        for (AreaEntity p :provinceList) {
            ProvinceVo vo = new ProvinceVo();
            vo.province = p;

            voList.add(vo);
        }

        return R.ok().put("data", voList);
    }

    public class ProvinceVo {
        public ProvinceVo() {}

        public ProvinceVo(AreaEntity province, List<CityVo> city) {
            this.province = province;
            this.city = city;
        }

        public AreaEntity province;
        public List<CityVo> city;
    }

    public class CityVo {
        public CityVo() {}

        public CityVo(AreaEntity city, List<areaVo> areaList) {
            this.city = city;
            this.areaList = areaList;
        }

        public AreaEntity city;
        public List<areaVo> areaList;
    }

    public class areaVo {
        public areaVo() {}
        public areaVo(AreaEntity city) {
            this.city = city;
        }


        public AreaEntity city;
    }


}
