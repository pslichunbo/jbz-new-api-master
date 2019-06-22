package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/area")
public class AreaApiController {
    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = areaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{areaCode}")
    public R info(@PathVariable("areaCode") String areaCode){
			AreaEntity area = areaService.selectById(areaCode);

        return R.ok().put("area", area);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AreaEntity area){
			areaService.insert(area);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AreaEntity area){
			areaService.updateById(area);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody String[] areaCodes){
			areaService.deleteBatchIds(Arrays.asList(areaCodes));

        return R.ok();
    }
    /**
     *查询所有省
     */
    @GetMapping("/queryByProvide")
    public R selectByProvide(){
        List<AreaEntity> list = areaServiceImpl.selectByProvide();
        return R.ok().put("data",list);
    }
    /**
     *根据省id查询市
     */
    @GetMapping("/selectByCity/{provideId}")
    public R queryByCity(@PathVariable("provideId") long provideId){
        List<AreaEntity> list = areaServiceImpl.queryByProvideId(provideId);
        return R.ok().put("data",list);
    }
    /**
     *根据市id获取地区
     */
    @GetMapping("/selectByCountry/{cityId}")
    public R queryByCountry(@PathVariable("cityId") Long cityId){
        List<AreaEntity> list = areaServiceImpl.selectByCountry(cityId);
        return R.ok().put("data",list);
    }
}
