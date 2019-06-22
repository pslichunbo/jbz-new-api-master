package io.renren.modules.app.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.common.utils.DateUtils;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.AreaService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.vo.CityAdminVo;
import io.renren.modules.app.vo.ProvinceVo;
import io.renren.modules.app.vo.countyAdminVo;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class query extends QuartzJobBean {



    @Autowired
    private AreaService areaService;

    @Autowired
    private RedisTemplate redisTemplate;




    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    @Transactional
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("开始");
        System.out.println("结束");
    }

}
