package io.renren.modules.app.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.renren.common.utils.GetOrderId;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.RealnameAuthenticationService;
import io.renren.modules.app.service.impl.SourceGoodsServiceImpl;
import io.renren.modules.app.vo.AdminSourceVo;
import io.renren.modules.app.vo.SourceGoodsEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.app.service.SourceGoodsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 货源表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
@RestController
@RequestMapping("app/AdminSourceGoods")
public class SourceGoodsController {
    @Autowired
    private SourceGoodsService sourceGoodsService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private SourceGoodsServiceImpl sourceGoodsServiceImpl;


    @Autowired
    private RealnameAuthenticationService realnameAuthenticationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:sourcegoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sourceGoodsService.queryPage1(params);
        List<SourceGoodsEntity> content = (List<SourceGoodsEntity>) page.getContent();
        List<SourceGoodsEntityVo> vos = new ArrayList<>();
        content.stream().forEach(s->vos.add(sourceGoodsServiceImpl.getSourceGoodsEntityVo(s)));
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:sourcegoods:info")
    public R info(@PathVariable("id") Long id){
		SourceGoodsEntity sourceGoods = sourceGoodsService.selectById(id);
        AdminSourceVo vo = new AdminSourceVo();
        vo.setAlterTime(sourceGoods.getAlterTime());
        vo.setCargoDescription(sourceGoods.getCargoDescription());
        vo.setClerkOrderingNum(sourceGoods.getClerkOrderingNum());
        vo.setCreateTime(sourceGoods.getCreateTime());
        vo.setEndAddress(sourceGoods.getEndAddress());
        vo.setEndCounty(sourceGoods.getEndCounty());
        vo.setEndCity(areaService.selectById(Long.parseLong(sourceGoods.getEndCounty())).getParentCode());
        vo.setEndProvince(areaService.selectById(vo.getEndCity()).getParentCode());
        vo.setClerkOrderingNum(sourceGoods.getClerkOrderingNum());
        vo.setCargoDescription(sourceGoods.getCargoDescription());
        vo.setGoodsNumber(sourceGoods.getGoodsNumber());
        vo.setId(sourceGoods.getId());
        vo.setImages(sourceGoods.getImages());
        vo.setLinkName(sourceGoods.getLinkName());
        vo.setStartCity(areaService.selectById(sourceGoods.getStartCounty()).getParentCode());
        vo.setStartCounty(sourceGoods.getStartCounty());
        vo.setStartProvince(areaService.selectById(sourceGoods.getStartCity()).getParentCode());
        vo.setStartPointAddr(sourceGoods.getStartPointAddr());
        vo.setState(sourceGoods.getState());
        vo.setStartAddress(sourceGoods.getStartAddress());
        vo.setTel(sourceGoods.getTel());
        vo.setUrgent(sourceGoods.getUrgent());
        vo.setUserId(sourceGoods.getUserId());
        vo.setWeight(sourceGoods.getWeight());
        return R.ok().put("data", vo);
    }

    /**
     * 筛选一认证的用户
     */
    @RequestMapping("realName")
    public R RealNameInfo(){
        List<SysUserEntity> sysUserEntities = sysUserService.realName();
        List<SysUserEntity> user = new ArrayList<>();
        for(SysUserEntity s : sysUserEntities){
            if("".equals(s.getRealnameId()) || s.getRealnameId() == null){
                continue;
            }
            if("1".equals(realnameAuthenticationService.selectById(s.getRealnameId()).getStatus())){
                user.add(s);
            }
        }
        return R.ok().put("data", user);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SourceGoodsEntity sourceGoods){
        sourceGoods.setImages(sourceGoods.getImages().replaceAll("[\\[\\]\\\"]",""));
        sourceGoods.setGoodsNumber(GetOrderId.getOrderIdByTime());
        sourceGoods.setState(0L);
        sourceGoods.setClerkOrderingNum(0);
		sourceGoodsService.insert(sourceGoods);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SourceGoodsEntity sourceGoods){
			sourceGoodsService.updateById(sourceGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			sourceGoodsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
