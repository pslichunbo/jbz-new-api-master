package io.renren.modules.app.controller.admin;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.ResumeTypeEntity;
import io.renren.modules.app.service.ResumeTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@RestController
@RequestMapping("app/resumetype")
public class ResumeTypeController {
    @Autowired
    private ResumeTypeService resumeTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("app:resumetype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("app:resumetype:info")
    public R info(@PathVariable("id") Long id){
			ResumeTypeEntity resumeType = resumeTypeService.selectById(id);

        return R.ok().put("data", resumeType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("app:resumetype:save")
    public R save(@RequestBody ResumeTypeEntity resumeType){
            resumeType.setCreateTime(new Date());
			resumeTypeService.insert(resumeType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("app:resumetype:update")
    public R update(@RequestBody ResumeTypeEntity resumeType){
			resumeTypeService.updateById(resumeType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("app:resumetype:delete")
    public R delete(@RequestBody Long[] ids){
			resumeTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
