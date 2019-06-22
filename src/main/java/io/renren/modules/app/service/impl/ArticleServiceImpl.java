package io.renren.modules.app.service.impl;

import io.renren.modules.app.vo.ArticleVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.ArticleDao;
import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;

import javax.annotation.Resource;


@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {
    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;

    @Resource
    private ArticleDao articleDao;
    @Override
    public PageUtils queryPageID(Map<String, Object> params) {
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<ArticleEntity>().orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    @Override
    public List<ArticleEntity> selectAll() {
        return articleDao.Select();
    }

    @Override
    public PageUtils
    queryPage(Map<String, Object> params) {
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<ArticleEntity>()
                .orderBy("create_time",false)
        );
        return new PageUtils(page);

    }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<>(new ArticleEntity())
        );
        return new PageUtils(page);
    }


    //查询所有审核通过的文章
    public PageUtils queryAll(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<>(new ArticleEntity())
                .where(" `type` = 0 and del_sign = 0")
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public PageUtils queryByType(Map<String, Object> params){
        String sort = (String) params.get("sort");
        long type = Long.parseLong(params.get("type").toString());
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<>(new ArticleEntity())
                .where(" `type` = {0} and del_sign = 0",type)
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public PageUtils selectByPhone(Map<String, Object> params){
        String sort = (String) params.get("sort");
        Boolean tag;
        String[] s = sort.split(",");
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        SysUserEntity userEntity = sysUserServiceImpl.queryByPhone(params.get("phone").toString());
        Long userId = userEntity.getUserId();
        Page<ArticleEntity> page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<>(new ArticleEntity())
                .where("del_sign = 0 and user_id ="+userId)
                .orderBy(s[0],tag)
        );
        return new PageUtils(page);
    }

    public boolean deleteByUserId(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long userId = Long.parseLong(params.get("userId").toString());
        EntityWrapper ew = new EntityWrapper(new ArticleEntity());
        ew.where("`id` = {0} and user_id = {1} and del_sign = 0",id,userId);
        return this.delete(ew);
    }

    public boolean setById(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long type = Long.parseLong(params.get("type").toString());
        ArticleEntity articleEntity = this.selectById(id);
        articleEntity.setType(type);
       return this.updateById(articleEntity);
    }

    public ArticleVo getvo(ArticleEntity entity){
        ArticleVo vo = new ArticleVo();
        vo.setAlterTime(entity.getAlterTime());
        vo.setContent(entity.getContent());
        vo.setCreateTime(entity.getCreateTime());
        vo.setId(entity.getId());
        vo.setImageLinks(entity.getImageLinks());
        vo.setName(sysUserServiceImpl.selectById(entity.getUserId()).getUsername());
        vo.setTitle(entity.getTitle());
        vo.setType(entity.getType());
        vo.setUserId(entity.getUserId());
        return vo;
    }
}
