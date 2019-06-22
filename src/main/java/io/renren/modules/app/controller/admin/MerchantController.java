package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.LabelEntity;
import io.renren.modules.app.entity.MerchantTypeEntity;
import io.renren.modules.app.service.LabelService;
import io.renren.modules.app.service.MerchantTypeService;
import io.renren.modules.app.service.impl.LabelServiceImpl;
import io.renren.modules.app.service.impl.MerchantServiceImpl;
import io.renren.modules.app.service.impl.MerchantTypeServiceImpl;
import io.renren.modules.app.vo.MerchantEntityVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MerchantEntity;
import io.renren.modules.app.service.MerchantService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 信息对象表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;


    @Autowired
    private MerchantTypeService merchantTypeService;

    @Autowired
    private MerchantTypeServiceImpl merchantTypeServiceImpl;

    @Autowired
    private LabelService labelService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MerchantServiceImpl merchantServiceImpl;

    @Autowired
    private LabelServiceImpl labelServiceImpl;


    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = merchantService.queryPage(params);
        List<MerchantEntity> content = (List<MerchantEntity>) page.getContent();
        List<MerchantEntityVo> list = new ArrayList<>();
        for(MerchantEntity s : content){
            MerchantEntityVo vo = new MerchantEntityVo();
            SysUserEntity userEntity = sysUserService.selectById(s.getUserId());
            if(userEntity == null){
                return R.error("数据查询错误！");
            }
            MerchantTypeEntity merchantTypeEntity = merchantTypeService.selectById(s.getTypeId());
            if(merchantTypeEntity == null){
                return R.error("数据查询错误！");
            }
            LabelEntity labelEntity = labelService.selectById(s.getLabelId());
            if(labelEntity == null){
                return R.error("数据查询错误！");
            }
            vo.setId(s.getId());
            vo.setTitle(s.getTitle());
            vo.setName(s.getName());
            vo.setLinkMan(s.getLinkMan());
            vo.setLinkTel(s.getLinkTel());
            vo.setMoney(s.getMoney());
            vo.setAreaSign(s.getAreaSign());
            vo.setArea(s.getArea());
            vo.setAddress(s.getAddress());
            vo.setRemark(s.getRemark());
            vo.setStataDate(s.getStataDate());
            vo.setPost(s.getPost());
            vo.setImageUrl(s.getImageUrl());
            vo.setTypeName(merchantTypeEntity.getName());
            vo.setCountNum(s.getCountNum());
            vo.setState(s.getState());
            vo.setUserName(userEntity.getUsername());
            vo.setLng(s.getLng());
            vo.setLat(s.getLat());
            vo.setDistance(s.getDistance());
            vo.setDelSign(s.getDelSign());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            vo.setLabelName(labelEntity.getName());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/listOne")
//    @RequiresPermissions("app:merchant:list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = merchantService.queryPageOne(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:merchant:info")
    public R info(@PathVariable("id") Long id){
			MerchantEntity merchant = merchantService.selectById(id);

        return R.ok().put("data", merchant);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:merchant:save")
    public R save(@RequestBody MerchantEntity merchant){
            merchant.setCreateTime(new Date());
            merchant.setStataDate(new Date());
            SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
            merchant.setUserId(userEntity.getUserId());
			merchantService.insert(merchant);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:merchant:update")
    public R update(@RequestBody MerchantEntity merchant){
            merchant.setAlterTime(new Date());
			merchantService.updateById(merchant);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:merchant:delete")
    public R delete(@RequestBody Long[] ids){
			merchantService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查询所有信息
     */
    @GetMapping("/all")
    public R selectAll(){
        List<MerchantEntity> merchantEntities = merchantServiceImpl.queryAll();
        return R.ok().put("data",merchantEntities);
    }
    /**
     *查询所有信息类型lyj
     */
    @GetMapping("/allType")
    public R selectAllType(){
        List<MerchantTypeEntity> list = merchantTypeServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
    /**
     *查询所有标签lyj
     */
    @GetMapping("/allLabel")
    public R selectAllLabel(){
        List<LabelEntity> list = labelServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
