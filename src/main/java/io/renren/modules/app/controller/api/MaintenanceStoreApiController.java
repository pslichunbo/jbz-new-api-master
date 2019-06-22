package io.renren.modules.app.controller.api;

import java.util.*;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.Query;
import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.MaintenancePersonEntity;
import io.renren.modules.app.entity.MaintenanceStoreTypeEntity;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.MaintenancePersonServiceImpl;
import io.renren.modules.app.service.impl.MaintenanceStoreServiceImpl;
import io.renren.modules.app.service.impl.MaintenanceStoreTypeServiceImpl;
import io.renren.modules.app.vo.MaintenanceStoreVo;
import io.renren.modules.app.vo.PersonVos;
import io.renren.modules.app.vo.StoreVo;
import io.renren.modules.app.vo.StoreVos;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MaintenanceStoreEntity;
import io.renren.modules.app.service.MaintenanceStoreService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 维修店
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@RestController
@RequestMapping("api/maintenancestore")
public class MaintenanceStoreApiController {
    @Autowired
    private MaintenanceStoreService maintenanceStoreService;
    @Autowired
    private MaintenanceStoreServiceImpl maintenanceStoreServiceImpl;
    @Autowired
    private MaintenancePersonServiceImpl maintenancePersonServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintenanceStoreService.queryPage(params);
        List<MaintenanceStoreEntity> content = (List<MaintenanceStoreEntity>) page.getContent();
        List<StoreVo> list = new ArrayList<>();
        for (MaintenanceStoreEntity m : content){
            list.add(maintenanceStoreServiceImpl.getVo(m));
        }
        page.setContent(list);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MaintenanceStoreEntity maintenanceStore = maintenanceStoreService.selectById(id);
        StoreVo vo = maintenanceStoreServiceImpl.getVo(maintenanceStore);
        return R.ok().put("data", vo);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			maintenanceStoreService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/index")
    public R selectByIndex(){
        //维修铺推荐,根据创建时间查询出维修铺列表取最前面三条
        List<StoreVos> vosList = maintenanceStoreServiceImpl.queryByIndex();
        //维修人推荐
        List<PersonVos> list = maintenancePersonServiceImpl.queryByIndex();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("store",vosList);
        map.put("person",list);
        return R.ok().put("data",map);
    }

    /**
     * 我的维修店
     */
    @GetMapping("/getByUserId/{userId}")
    public R getByUserId(@PathVariable("userId") Long userId){
        MaintenanceStoreEntity entity = maintenanceStoreServiceImpl.getByUserId(userId);
        if (entity == null){
            return R.error("该用户还未登记维修店");
        }
        StoreVo vo = maintenanceStoreServiceImpl.getVo(entity);
        return R.ok().put("data",vo);
    }
}
