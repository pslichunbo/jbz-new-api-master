package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.VideoDao;
import io.renren.modules.app.entity.VideoEntity;
import io.renren.modules.app.service.VideoService;


@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, VideoEntity> implements VideoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sort = (String) params.get("sort");
        if("".equals(sort)|| sort == null){
            sort = "id,desc";
        }
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<VideoEntity> page = this.selectPage(
                new Query<VideoEntity>(params).getPage(),
                new EntityWrapper<VideoEntity>().orderBy(s[0],tag)
        );
        List<VideoEntity> records = page.getRecords();
        for (VideoEntity v : records){
            String[] split = v.getVideoUrl()
                    .replaceAll("[\\[\\]\\\"]", "")
                    .split(",");
            v.setVideoUrl(split[0]);
        }
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageid(Map<String, Object> params) {
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        Page<VideoEntity> page = this.selectPage(
                new Query<VideoEntity>(params).getPage(),
                new EntityWrapper<VideoEntity>().orderBy(s[0],tag)
                .where("type_id = {0}",(String)params.get("typeid"))
        );

        return new PageUtils(page);
    }


}
