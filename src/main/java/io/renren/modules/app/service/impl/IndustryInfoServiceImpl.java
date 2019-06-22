package io.renren.modules.app.service.impl;

import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.IndustryInfoDao;
import io.renren.modules.app.entity.IndustryInfoEntity;
import io.renren.modules.app.service.IndustryInfoService;


@Service("industryInfoService")
public class IndustryInfoServiceImpl extends ServiceImpl<IndustryInfoDao, IndustryInfoEntity> implements IndustryInfoService {

    @Autowired
    private SysUserServiceImpl sysUserServiceImpl;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String  s1 = (String)params.get("sort");
        if("".equals(s1) || s1 == null){
            Page<IndustryInfoEntity> page = this.selectPage(
                    new Query<IndustryInfoEntity>(params).getPage(),
                    new EntityWrapper<IndustryInfoEntity>()
            );
//            List<IndustryInfoEntity> records = page.getRecords();
//            for (IndustryInfoEntity entity : records){
//                String[] split = entity.getImageLinks()
//                        .replaceAll("[\\[\\]\\\"]", "")
//                        .split(",");
//                entity.setImageLinks(split[0]);
//                Pattern pattern = Pattern.compile("<p.*?>(.*?)</p>");
//                Matcher matcher = pattern.matcher(entity.getContent());
//                while (matcher.find()){
//                    entity.setContent(matcher.group(1));
//                }
//            }
            return new PageUtils(page);


        }else {
            String sort = (String) params.get("sort");
            Boolean tag;
            String[] s = sort.split(",");
            if("asc".equals(s[1])){
                tag = true;
            }else {
                tag = false;
            }
            Page<IndustryInfoEntity> page = this.selectPage(
                    new Query<IndustryInfoEntity>(params).getPage(),
                    new EntityWrapper<IndustryInfoEntity>()
                            .orderBy(s[0],tag)
            );

            return new PageUtils(page);
        }

    }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        Page<IndustryInfoEntity> page = this.selectPage(
                new Query<IndustryInfoEntity>(params).getPage(),
                new EntityWrapper<IndustryInfoEntity>()
        );
        return new PageUtils(page);
    }

    //行业动态获取更多
    public PageUtils queryAll(Map<String, Object> params){
        Page<IndustryInfoEntity> page = this.selectPage(
                new Query<IndustryInfoEntity>(params).getPage(),
                new EntityWrapper<>(new IndustryInfoEntity())
                .where("del_sign = 0")
                .orderBy("create_time",true)
        );
        return new PageUtils(page);
    }
    public boolean removeByUserId(Map<String, Object> params){
        long id = Long.parseLong(params.get("id").toString());
        long userId = Long.parseLong(params.get("userId").toString());
        IndustryInfoEntity entity = this.selectById(id);
        if (null != entity){
            EntityWrapper ew = new EntityWrapper(new IndustryInfoEntity());
            ew.where(" `id` ={0} and user_id ={1}",id,userId);
            return this.delete(ew);
        }
        return false;
    }
    public List<IndustryInfoEntity> queryByHost(){
        EntityWrapper ew = new EntityWrapper(new IndustryInfoEntity());
        ew.orderBy("create_time",true);
        List<IndustryInfoEntity> list = this.selectList(ew);
        List<IndustryInfoEntity> list1 = list.stream().limit(3).collect(Collectors.toList());
        return list1;
    }
    public PageUtils queryByVip(Map<String, Object> params){

        Page<IndustryInfoEntity> page = this.selectPage(
                new Query<IndustryInfoEntity>(params).getPage(),
                new EntityWrapper<IndustryInfoEntity>()
        );
        return new PageUtils(page);
    }

    public PageUtils queryByAll(Map<String, Object> params){
        Page<IndustryInfoEntity> page = this.selectPage(
                new Query<IndustryInfoEntity>(params).getPage(),
                new EntityWrapper<>(new IndustryInfoEntity())
                        .where("del_sign = 0")
                        .orderBy("create_time",true)
        );
        List<IndustryInfoEntity> records = page.getRecords();
        for (IndustryInfoEntity i : records){
            String[] split = i.getImageLinks()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            i.setImageLinks(split[0]);
            Pattern pattern = Pattern.compile("<p.*?>(.*?)</p>");
            Matcher matcher = pattern.matcher(i.getContent());
            while (matcher.find()){
                i.setContent(matcher.group(1));
            }
        }
        return new PageUtils(page);
    }
}
