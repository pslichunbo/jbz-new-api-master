package io.renren.modules.app.controller.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import io.renren.modules.app.service.ArticleService;
import io.renren.modules.app.service.impl.IndustryInfoServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.IndustryInfoEntity;
import io.renren.modules.app.service.IndustryInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 行业信息表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/apiindustryinfo")
public class IndustryInfoApiController {
    @Autowired
    private IndustryInfoService industryInfoService;
    @Autowired
    private IndustryInfoServiceImpl industryInfoServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/apilist")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = industryInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/apiinfo/{id}")
    public R info(@PathVariable("id") Long id){
			IndustryInfoEntity industryInfo = industryInfoService.selectById(id);
        return R.ok().put("data", industryInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/apisave")
    public R save(@RequestBody IndustryInfoEntity industryInfo){
			industryInfoService.insert(industryInfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/apiupdate")
    public R update(@RequestBody IndustryInfoEntity industryInfo){
			industryInfoService.updateById(industryInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/apidelete")
    public R delete(@RequestBody Long[] ids){
			industryInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *获取所有行业动态接口lyj
     */
    @GetMapping("/apiall")
    public R queryAll(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = industryInfoServiceImpl.queryAll(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     *行业动态  动态推荐lyj
     * 取最新三条数据
     */
    @GetMapping("/apihost")
    public R selectHost(){
        List<IndustryInfoEntity> industryInfoEntities = industryInfoServiceImpl.queryByHost();
        return R.ok().put("data",industryInfoEntities);
    }
    //会员故事lyj
    @GetMapping("/apibyVip")
    public R selectByVip(@RequestParam Map<String, Object> params){
        PageUtils page = industryInfoServiceImpl.queryByVip(params);
        return R.ok().put("data",page);

    }
    /**
     *会员故事获取更多
     */
    @GetMapping("/apibyAll")
    public R selectAll(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = industryInfoServiceImpl.queryByAll(params);
        return R.ok().put("data",pageUtils);
    }
}
