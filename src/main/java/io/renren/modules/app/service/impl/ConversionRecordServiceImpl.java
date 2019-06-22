package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.PartsEntity;
import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ConversionRecordDao;
import io.renren.modules.app.entity.ConversionRecordEntity;
import io.renren.modules.app.service.ConversionRecordService;


@Service("conversionRecordService")
public class ConversionRecordServiceImpl extends ServiceImpl<ConversionRecordDao, ConversionRecordEntity> implements ConversionRecordService {
    @Autowired
    private PresentServiceImpl presentServiceImpl;
    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConversionRecordEntity> page = this.selectPage(
                new Query<ConversionRecordEntity>(params).getPage(),
                new EntityWrapper<ConversionRecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        Page<ConversionRecordEntity> page = this.selectPage(
                new Query<ConversionRecordEntity>(params).getPage(),
                new EntityWrapper<ConversionRecordEntity>()
                        .where("dell_sign = 0")
        );

        return new PageUtils(page);
    }

    public PageUtils queryByUserId(Map<String, Object> params){
        String userId = params.get("userId").toString();
        Page<ConversionRecordEntity> page = this.selectPage(
                new Query<ConversionRecordEntity>(params).getPage(),
                new EntityWrapper<>(new ConversionRecordEntity())
                .where("user_id = {0} and dell_sign = 0",userId)
        );
        List<ConversionRecordEntity> records = page.getRecords();
        List<PresentEntity> list = new ArrayList<>();
        for (ConversionRecordEntity c : records){
            PresentEntity partsEntity = presentServiceImpl.selectById(c.getPresentId());
            list.add(partsEntity);
        }
        Page<PresentEntity> page1 = new Query<PresentEntity>(params).getPage();
        page1.setRecords(list);
        return new PageUtils(page1);
    }

    public PageUtils queryAll(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<ConversionRecordEntity> page = this.selectPage(
                new Query<ConversionRecordEntity>(params).getPage(),
                new EntityWrapper<>(new ConversionRecordEntity())
                .where("dell_sign = 0")
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public boolean removeById(Map<String, Object> params){
        long userId = Long.parseLong(params.get("userId").toString());
        long id = Long.parseLong(params.get("id").toString());
        EntityWrapper ew = new EntityWrapper(new ConversionRecordEntity());
        ew.where("`id` = {0} and user_id = {1} and dell_sign = 0",id,userId);
        return this.delete(ew);
    }

    public PageUtils queryByUserPhone(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        SysUserEntity userEntity = sysUserServiceImpl.queryByPhone(params.get("phone").toString());
        Page<ConversionRecordEntity> page = this.selectPage(
                new Query<ConversionRecordEntity>(params).getPage(),
                new EntityWrapper<>(new ConversionRecordEntity())
                .where("user_id = {0} and dell_sign = 0",userEntity.getUserId())
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }
}
