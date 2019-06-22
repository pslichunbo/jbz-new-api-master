package io.renren.modules.app.controller.api;

import java.util.*;

import io.renren.common.utils.GetOrderId;
import io.renren.modules.app.entity.QualificationsAuthenticateEntity;
import io.renren.modules.app.service.OrderFormService;
import io.renren.modules.app.service.QualificationsAuthenticateService;
import io.renren.modules.app.service.impl.QualificationsAuthenticateServiceImpl;
import io.renren.modules.app.service.impl.SourceGoodsServiceImpl;
import io.renren.modules.app.vo.ApiSourceVo;
import io.renren.modules.sys.dao.SysUserTokenDao;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import io.renren.modules.sys.service.SysUserTokenService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("app/sourcegoods")
public class SourceGoodsApiController {
    @Autowired
    private SourceGoodsService sourceGoodsService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Autowired
    private QualificationsAuthenticateServiceImpl qualificationsAuthenticateServiceImpl;

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private SourceGoodsServiceImpl sourceGoodsServiceImpl;

    /**
     * 我的货源列表(根据state查询)[金]
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sourceGoodsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SourceGoodsEntity sourceGoods = sourceGoodsService.selectById(id);
        int i = orderFormService.proposerNum(sourceGoods.getId());
        sourceGoods.setClerkOrderingNum(i);
        return R.ok().put("sourceGoods", sourceGoods);
    }

    /**
     * 发布货源（jin）
     */
    @PostMapping("/save")
    public R save(@RequestBody SourceGoodsEntity sourceGoods){
        sourceGoods.setImages(sourceGoods.getImages().replaceAll("[\\[\\]\\\"]",""));
        sourceGoods.setCreateTime(new Date());
        sourceGoods.setState(0L);
        String orderIdNumber = GetOrderId.getOrderIdByTime();
        sourceGoods.setGoodsNumber(orderIdNumber);
        sourceGoodsService.insert(sourceGoods);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody SourceGoodsEntity sourceGoods){
			sourceGoodsService.updateById(sourceGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestParam Map<String, Object> params){
        boolean b = sourceGoodsServiceImpl.deleteByUserIdWithId(params);
        if (b){
            return R.ok("撤销成功");
        }
        return R.ok("撤销失败");
    }
    /**
     * 查询我的所有货源
     */
    @GetMapping("/allMyGoods/{userId}")
    public R getAllMyGoods(@PathVariable("userId") Long userId){

        List<SourceGoodsEntity> sourceGoodsEntities = sourceGoodsServiceImpl.selectAll(userId);
        List<ApiSourceVo> list = new ArrayList<>();
        sourceGoodsEntities.stream().forEach(s->list.add(sourceGoodsServiceImpl.getVo(s)));
        return R.ok().put("data",list);
    }

}
