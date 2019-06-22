package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.GoldRecordTypeEntity;
import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.app.service.GoldRecordTypeService;
import io.renren.modules.app.service.PresentService;
import io.renren.modules.app.service.impl.GoldRecordTypeServiceImpl;
import io.renren.modules.app.service.impl.PresentServiceImpl;
import io.renren.modules.app.vo.GoldRecordVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.GoldRecordEntity;
import io.renren.modules.app.service.GoldRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 金币记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("app/goldrecord")
public class GoldRecordController {
    @Autowired
    private GoldRecordService goldRecordService;


    @Autowired
    private GoldRecordTypeService goldRecordTypeService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PresentService presentService;

    @Autowired
    private GoldRecordTypeServiceImpl goldRecordTypeServiceImpl;

    @Autowired
    private PresentServiceImpl presentServiceImpl;


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:goldrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goldRecordService.queryPage(params);
        List<GoldRecordEntity> content = (List<GoldRecordEntity>) page.getContent();
        List<GoldRecordVo> list = new ArrayList<>();
        for(GoldRecordEntity s : content){
            GoldRecordVo vo = new GoldRecordVo();
            GoldRecordTypeEntity goldRecordTypeEntity = goldRecordTypeService.selectById(s.getTypeId());
            if (goldRecordTypeEntity == null) {
                return R.error("金币类型信息有误");
            }
            SysUserEntity sysUserEntity = sysUserService.selectById(s.getUserId());
            if (sysUserEntity == null) {
                return R.error("用户信息有误");
            }
            PresentEntity presentEntity = presentService.selectById(s.getRellId());
            if (presentEntity == null) {
                return R.error("礼品信息有误");
            }
            vo.setId(s.getId());
            vo.setGoldAmount(s.getGoldAmount());
            vo.setChangeCause(s.getChangeCause());
            vo.setName(goldRecordTypeEntity.getName());
            vo.setUserName(sysUserEntity.getUsername());
            vo.setRellName(presentEntity.getTitle());
            vo.setDelSign(s.getDelSign());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTime(s.getDeleteTime());
            list.add(vo);
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:goldrecord:info")
    public R info(@PathVariable("id") Long id){
			GoldRecordEntity goldRecord = goldRecordService.selectById(id);

        return R.ok().put("data", goldRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:goldrecord:save")
    public R save(@RequestBody GoldRecordEntity goldRecord){
            goldRecord.setCreateTime(new Date());
            SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
            goldRecord.setUserId(userEntity.getUserId());
			goldRecordService.insert(goldRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:goldrecord:update")
    public R update(@RequestBody GoldRecordEntity goldRecord){
            goldRecord.setAlterTime(new Date());
			goldRecordService.updateById(goldRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:goldrecord:delete")
    public R delete(@RequestBody Long[] ids){
			goldRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *获取所有金币类型lyj
     */
    @GetMapping("/allType")
    public R selectAllType(){
        List<GoldRecordTypeEntity> list = goldRecordTypeServiceImpl.queryAll();
        return R.ok().put("data",list);
    }

    /**
     *查询所有礼品lyj
     */
    @GetMapping("/allPresent")
    public R selectAllPresent(){
        List<PresentEntity> list = presentServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
