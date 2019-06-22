package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ContentColumnDao;
import io.renren.modules.app.entity.ContentColumnEntity;
import io.renren.modules.app.service.ContentColumnService;

import javax.annotation.Resource;


@Service("contentColumnService")
public class ContentColumnServiceImpl extends ServiceImpl<ContentColumnDao, ContentColumnEntity> implements ContentColumnService {

    @Resource
    private ContentColumnDao contentColumnDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ContentColumnEntity> page = this.selectPage(
                new Query<ContentColumnEntity>(params).getPage(),
                new EntityWrapper<ContentColumnEntity>()
        );
        List<ContentColumnEntity> records = page.getRecords();
        for (ContentColumnEntity c : records){
            c.setColumnKey(c.getColumnKey().replaceAll("[\\_]","").toUpperCase());
        }
        return new PageUtils(page);
    }

    @Override
    public List<ContentColumnEntity> select() {
        List<ContentColumnEntity> select = contentColumnDao.select();
        return select;
    }

    @Override
    public List<ContentColumnEntity> queryNext(String id) {
        List<ContentColumnEntity> select = contentColumnDao.selectNext(id);
        return select;
    }
    public List<ContentColumnEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new ContentColumnEntity());
        ew.where("state = 0");
        return this.selectList(ew);
    }
}
