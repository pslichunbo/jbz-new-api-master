package io.renren.modules.app.controller.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.CustomerEntity;
import io.renren.modules.app.service.CustomerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-18 09:51:11
 */
@RestController
@RequestMapping("api/customer")
public class CustomerApiController {
    @Autowired
    private CustomerService customerService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @GetMapping("/query")
    public R query(){
        List<CustomerEntity> query = customerService.query();
        Random random = new Random();
        int n = random.nextInt(query.size());
        CustomerEntity customerEntity = query.get(n);
        return R.ok().put("data", customerEntity);
    }



    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			CustomerEntity customer = customerService.selectById(id);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CustomerEntity customer){
			customerService.insert(customer);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody CustomerEntity customer){
			customerService.updateById(customer);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			customerService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
