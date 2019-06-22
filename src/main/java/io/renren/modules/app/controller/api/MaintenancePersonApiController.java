package io.renren.modules.app.controller.api;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.Query;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MaintenancePersonTypeEntity;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.MaintenancePersonServiceImpl;
import io.renren.modules.app.service.impl.MaintenancePersonTypeServiceImpl;
import io.renren.modules.app.vo.MaintenancePersonVo;
import io.renren.modules.app.vo.PersonVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenancePersonEntity;
import io.renren.modules.app.service.MaintenancePersonService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修人
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/maintenanceperson")
public class MaintenancePersonApiController {
    @Autowired
    private MaintenancePersonService maintenancePersonService;
    @Autowired
    private MaintenancePersonServiceImpl maintenancePersonServiceImpl;

    /**
     * 维修人列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenancePersonService.queryPage(params);
        List<MaintenancePersonEntity> content = (List<MaintenancePersonEntity>) page.getContent();
        List<PersonVo> list = new ArrayList<>();
        for (MaintenancePersonEntity m : content){
            list.add(maintenancePersonServiceImpl.getPersionVo(m));
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MaintenancePersonEntity maintenancePerson = maintenancePersonService.selectById(id);
        PersonVo persionVo = maintenancePersonServiceImpl.getPersionVo(maintenancePerson);
        return R.ok().put("data", persionVo);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			maintenancePersonService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 我的维修人
     */
    @GetMapping("getByUserId/{userId}")
    public R getByUserId(@PathVariable("userId") Long userId){
        MaintenancePersonEntity maintenancePersonEntities = maintenancePersonServiceImpl.selectByUserId(userId);
        if (maintenancePersonEntities == null){
            return R.error("该用户还没有登记维修人");
        }
        PersonVo persionVo = maintenancePersonServiceImpl.getPersionVo(maintenancePersonEntities);
        return R.ok().put("data",persionVo);
    }

}
