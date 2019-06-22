package io.renren.modules.app.controller.api;

import java.util.*;

import io.renren.modules.app.entity.MechanicalLeaseEntity;
import io.renren.modules.app.service.SourceGoodsListService;
import io.renren.modules.app.service.impl.EntrustMachineServiceImpl;
import io.renren.modules.app.vo.EntrustMachineEntityVo;
import io.renren.modules.app.vo.MechanicalLeaseEntityVo;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.EntrustMachineEntity;
import io.renren.modules.app.service.EntrustMachineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:51:31
 */
@RestController
@RequestMapping("au/entrustmachine")
public class EntrustMachineApiController {
    @Autowired
    private EntrustMachineService entrustMachineService;
    @Autowired
    private SourceGoodsListService sourceGoodsListService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private EntrustMachineServiceImpl entrustMachineServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/mylist")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = entrustMachineService.MyqueryPage(params);
        List<EntrustMachineEntity> content = (List<EntrustMachineEntity>) page.getContent();
        List<EntrustMachineEntityVo> vos = new ArrayList<>();
        content.stream().forEach(e->vos.add(entrustMachineServiceImpl.getEntrustMachineEntityVo(e)));
        page.setContent(vos);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        EntrustMachineEntity s = entrustMachineService.selectById(id);
        EntrustMachineEntityVo vo = entrustMachineServiceImpl.getEntrustMachineEntityVo(s);
        return R.ok().put("entrustMachine", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody EntrustMachineEntity entrustMachine) {
            entrustMachine.setCreateTime(new Date());
            entrustMachineService.insert(entrustMachine);
        return R.ok();
    }

        /**
         * 修改
         */
        @PutMapping("/update")
        public R update (@RequestBody EntrustMachineEntity entrustMachine){
            entrustMachineService.updateById(entrustMachine);

            return R.ok();
        }

        /**
         * 删除
         */
        @DeleteMapping("/delete")
        public R delete (@RequestBody Integer[]ids){
            entrustMachineService.deleteBatchIds(Arrays.asList(ids));

            return R.ok();
        }
    }

