package io.renren.modules.app.dao;

import io.renren.modules.app.entity.VideoTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 视频类型表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@Mapper
public interface VideoTypeDao extends BaseMapper<VideoTypeEntity> {

    List<VideoTypeEntity> findAll();


}
