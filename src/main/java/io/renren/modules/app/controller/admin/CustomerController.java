package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("app/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
			CustomerEntity customer = customerService.selectById(id);

        return R.ok().put("customer", customer);
    }

    /**
     * 上班
     */
    @RequestMapping("/up")
    public R up(@RequestBody CustomerEntity customer){
            CustomerEntity cust = customerService.selectById(customer.getId().toString());
            cust.setStatus("1");
            customerService.updateById(cust);
        return R.ok();
    }


    /**
     * 下班
     */
    @RequestMapping("/down")
    public R down(@RequestBody CustomerEntity customer){
        CustomerEntity cust = customerService.selectById(customer.getId().toString());
        cust.setStatus("0");
        customerService.updateById(cust);
        return R.ok();
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CustomerEntity customer) {
        if (customer.getPhone().length() != 11) {
            return R.error("手机号必须为11位");
        } else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(customer.getPhone()).matches();
            if (matches) {
                customer.setCreateTime(new Date());
                customer.setStatus("0");
                customerService.insert(customer);
                return R.ok();
            }else {
                return R.error("手机号码格式不正确");
            }
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CustomerEntity customer){
        if (customer.getPhone().length() != 11) {
            return R.error("手机号必须为11位");
    }else {
            boolean matches = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(customer.getPhone()).matches();
            if (matches) {
                customerService.updateById(customer);

                return R.ok();
            }else {
                return R.error("手机格式不正确");
            }
        }

    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			customerService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
