package io.renren.modules.app.controller.admin;

import java.util.*;

import com.alibaba.fastjson.JSON;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.vo.CityAdminVo;
import io.renren.modules.app.vo.ProvinceVo;
import io.renren.modules.app.vo.countyAdminVo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 全国行政区域
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-30 14:49:23
 */
@RestController
@RequestMapping("app/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private RedisUtils redisUtils;






    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:area:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = areaService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/list/{id}")
    public R list(@PathVariable("id") String id) {
        List<AreaEntity> list = areaService.getAreaList(id);
        return R.ok().put("data", list);
    }



    /**
     * 获取所有省市区
     */
    @RequestMapping("/all")
    public R all(){
        List<ProvinceVo> provinceVos=null;
        String area = redisUtils.get("area");
        if(StringUtils.isNotBlank(area)){
            provinceVos= JSON.parseArray(area, ProvinceVo.class);
        }else{
            List<AreaEntity> list = areaService.getAreaList("0");
            provinceVos = new ArrayList<>();
            for(AreaEntity province :list){
                ProvinceVo ProvinceAdminVo = new ProvinceVo();
                List<AreaEntity> list1 = areaService.getAreaList(province.getAreaCode());
                List<CityAdminVo> d1 = new ArrayList<>();
                for(AreaEntity city: list1){
                    CityAdminVo cityAdminVo = new CityAdminVo();
                    List<AreaEntity> list2 = areaService.getAreaList(city.getAreaCode());
                    List<countyAdminVo> d = new ArrayList<>();
                    for(AreaEntity s : list2){
                        countyAdminVo countyAdminVo = new countyAdminVo();
                        countyAdminVo.setLabel(s.getAreaName());
                        countyAdminVo.setValue(s.getAreaCode());
                        d.add(countyAdminVo);
                    }
                    cityAdminVo.setLabel(city.getAreaName());
                    cityAdminVo.setValue(city.getAreaCode());
                    cityAdminVo.setChildren(d);
                    d1.add(cityAdminVo);
                }
                ProvinceAdminVo.setChildren(d1);
                ProvinceAdminVo.setLabel(province.getAreaName());
                ProvinceAdminVo.setValue(province.getAreaCode());
                provinceVos.add(ProvinceAdminVo);
            }
            redisUtils.set("area", JSON.toJSONString(provinceVos),-1);
        }
        return R.ok().put("options",provinceVos);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{areaCode}")
//    @RequiresPermissions("app:area:info")
    public R info(@PathVariable("areaCode") String areaCode){
			AreaEntity area = areaService.selectById(areaCode);

        return R.ok().put("area", area);
    }

    @RequestMapping("/infoTo/{areaCode}")
    public R infoTo(@PathVariable("areaCode") String areaCode){
        AreaEntity area = areaService.selectById(areaCode);

        return R.ok().put("area", area);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:area:save")
    public R save(@RequestBody AreaEntity area){
			areaService.insert(area);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:area:update")
    public R update(@RequestBody AreaEntity area){
			areaService.updateById(area);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:area:delete")
    public R delete(@RequestBody String[] areaCodes){
			areaService.deleteBatchIds(Arrays.asList(areaCodes));

        return R.ok();
    }

   @GetMapping("/allArea")
    public R selectAllArea(){
        return areaServiceImpl.getAllArea();
   }


}
