package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.MessageEntity;
import io.renren.modules.app.service.MessageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 消息表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 14:35:24
 */
@RestController
@RequestMapping("au/message")
public class MessageApiController {
    @Autowired
    private MessageService messageService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 系统消息列表
     */
    @GetMapping("/syslist")
    public R syslist(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.SysqueryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 订单消息列表
     */
    @GetMapping("/orderlist")
    public R orderlist(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.orderqueryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 货源消息列表
     */
    @GetMapping("/sourcelist")
    public R sourcelist(@RequestParam Map<String, Object> params){
        PageUtils page = messageService.sourcequeryPage(params);
        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			MessageEntity message = messageService.selectById(id);
        return R.ok().put("message", message);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody MessageEntity message){
			messageService.insert(message);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody MessageEntity message){
			messageService.updateById(message);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			messageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
