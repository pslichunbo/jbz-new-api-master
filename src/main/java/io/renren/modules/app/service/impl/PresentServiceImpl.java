package io.renren.modules.app.service.impl;

import io.renren.modules.app.dao.PresentTypeDao;
import io.renren.modules.app.entity.PresentTypeEntity;
import io.renren.modules.app.entity.VideoEntity;
import io.renren.modules.app.vo.PresentEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.PresentDao;
import io.renren.modules.app.entity.PresentEntity;
import io.renren.modules.app.service.PresentService;

import javax.annotation.Resource;


@Service("presentService")
public class PresentServiceImpl extends ServiceImpl<PresentDao, PresentEntity> implements PresentService {

    @Resource
    private PresentTypeDao presentTypeDao;

    @Resource
    private PresentDao presentDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PresentEntity> page = this.selectPage(
                new Query<PresentEntity>(params).getPage(),
                new EntityWrapper<PresentEntity>()
                .where("del_sign = 0")
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageAll(Map<String, Object> params) {
        String sort = (String) params.get("sort");
        Long type = Long.parseLong((String)params.get("type"));
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<PresentEntity> page = this.selectPage(
                new Query<PresentEntity>(params).getPage(),
                new EntityWrapper<PresentEntity>().orderBy(s[0],tag)
                .where("type_id = {0} and del_sign = 0",type)
        );
        return new PageUtils(page);
    }
    public List<PresentEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new PresentEntity());
        ew.where("del_sign = 0");
        return this.selectList(ew);
    }
}
