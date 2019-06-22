package io.renren.modules.app.controller.api;


import com.aliyuncs.exceptions.ClientException;
import io.renren.common.utils.Const;
import io.renren.common.utils.R;
import io.renren.common.utils.SmsUtil;
import io.renren.modules.app.entity.CodeEntity;
import io.renren.modules.app.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created on 2017/4/10.
 */
@RestController
@RequestMapping("/api/verify-codes")
public class VerifyCodeApiController {

    @Autowired
    private CodeService codeService;

    @GetMapping("/code")
    public R sendMsg(@RequestParam("phone") String phone) throws ClientException, InterruptedException {
        if (!Pattern.compile(Const.Patterns.PHONE).matcher(phone).matches()) {
            return R.error("请输入正确的电话号码！");
        }
        String sms = SmsUtil.Send(phone);
        HashMap data = new HashMap<String, String>();
        data.put("phone",phone);
        data.put("code",sms);
        CodeEntity codeEntity = new CodeEntity();
        codeEntity.setPhone(phone);
        codeEntity.setCreateTime(new Date());
        codeEntity.setCode(sms);
        codeService.insert(codeEntity);
        return R.ok().put("data", data);
    }
}


