package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ContentColumnEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-20 15:02:48
 */
@Mapper
public interface ContentColumnDao extends BaseMapper<ContentColumnEntity> {

    List<ContentColumnEntity> select();
    List<ContentColumnEntity> selectNext(String id);



}
