package io.renren.modules.app.controller.admin;

import java.util.*;

import io.renren.modules.app.entity.ConversionRecordTypeEntity;
import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.app.service.ConversionRecordTypeService;
import io.renren.modules.app.service.PresentService;
import io.renren.modules.app.service.impl.ConversionRecordServiceImpl;
import io.renren.modules.app.service.impl.ConversionRecordTypeServiceImpl;
import io.renren.modules.app.service.impl.PresentServiceImpl;
import io.renren.modules.app.vo.ConversionRecordVo;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.ConversionRecordEntity;
import io.renren.modules.app.service.ConversionRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 兑换记录表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@RestController
@RequestMapping("app/conversionrecord")
public class ConversionRecordController {
    @Autowired
    private ConversionRecordService conversionRecordService;
    @Autowired
    private ConversionRecordServiceImpl conversionRecordServiceImpl;
    @Autowired
    private PresentServiceImpl presentServiceImpl;


    @Autowired
    private PresentService presentService;

    @Autowired
    private ConversionRecordTypeService conversionRecordTypeService;
    @Autowired
    private ConversionRecordTypeServiceImpl conversionRecordTypeServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:conversionrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordService.queryPage(params);
        List<ConversionRecordEntity> content = (List<ConversionRecordEntity>) page.getContent();
        List<ConversionRecordVo> list = new ArrayList<>();
        for(ConversionRecordEntity s : content){
            ConversionRecordVo vo = new ConversionRecordVo();
            PresentEntity presentEntity = presentService.selectById(s.getPresentId());
            if (presentEntity == null) {
                return R.error("礼品信息有误");
            }
            ConversionRecordTypeEntity conversionRecordTypeEntity = conversionRecordTypeService.selectById(s.getTypeId());
            if (conversionRecordTypeEntity == null) {
                return R.error("兑换记录信息有误");
            }
            vo.setId(s.getId());
            vo.setPresentName(presentEntity.getTitle());
            vo.setStatus(s.getStatus());
            vo.setUserId(s.getUserId());
            vo.setDellSign(s.getDellSign());
            vo.setUserName(s.getUserName());
            vo.setUserTel(s.getUserTel());
            vo.setPostCode(s.getPostCode());
            vo.setAddress(s.getAddress());
            vo.setCreateTime(s.getCreateTime());
            vo.setAlterTime(s.getAlterTime());
            vo.setDeleteTtime(s.getDeleteTtime());
            vo.setTypeName(conversionRecordTypeEntity.getName());
            list.add(vo);

        }
        page.setContent(list);
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/listOne")
//    @RequiresPermissions("app:conversionrecord:list")
    public R listOne(@RequestParam Map<String, Object> params){
        PageUtils page = conversionRecordService.queryPageOne(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:conversionrecord:info")
    public R info(@PathVariable("id") Long id){
			ConversionRecordEntity conversionRecord = conversionRecordService.selectById(id);

        return R.ok().put("data", conversionRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:conversionrecord:save")
    public R save(@RequestBody ConversionRecordEntity conversionRecord){
            conversionRecord.setCreateTime(new Date());
            SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
            if (userEntity == null) {
                return R.error("用户信息有误");
            }
            conversionRecord.setUserId(userEntity.getUserId());
			conversionRecordService.insert(conversionRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:conversionrecord:update")
    public R update(@RequestBody ConversionRecordEntity conversionRecord){
            conversionRecord.setAlterTime(new Date());
			conversionRecordService.updateById(conversionRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:conversionrecord:delete")
    public R delete(@RequestBody Long[] ids){
			conversionRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    /**
     *查看所有礼品兑换记录lyj
     */
    @GetMapping("/queryAll")
    public R selectAll(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = conversionRecordServiceImpl.queryAll(params);
        return R.ok().put("data",pageUtils);
    }

    /**
     *获取兑换记录里某个礼品接口lyj
     */
    @GetMapping("/queryByPid/{pid}")
    public R selectByPresentId(@PathVariable("pid") Long presentId){
        PresentEntity entity = presentServiceImpl.selectById(presentId);
        if (null != entity) {
            return R.ok().put("data",entity);
        }
      return R.ok().put("data","未找到数据");
    }
    /**
     *根据用户id和兑换记录id删除兑换记录lyj
     */
    @DeleteMapping("/remove")
    public R deleteById(@RequestParam Map<String, Object> params){
        conversionRecordServiceImpl.removeById(params);
        return R.ok();
    }
    /**
     *根据用户电话号码查看用户兑换记录接口lyj
     */
    @GetMapping("/selectByPhone")
    public R queryByPhone(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = conversionRecordServiceImpl.queryByUserPhone(params);
        return R.ok().put("data",pageUtils);
    }
    /**
     *查询出所有礼品lyj
     */
    @GetMapping("/all")
    public R selectAll(){
        List<PresentEntity> list = presentServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
    /**
     *查询所有类型lyj
     */
    @GetMapping("/allType")
    public R selectAllType(){
        List<ConversionRecordTypeEntity> list = conversionRecordTypeServiceImpl.queryAll();
        return R.ok().put("data",list);
    }
}
