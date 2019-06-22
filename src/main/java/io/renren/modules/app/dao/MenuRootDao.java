package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MenuRootEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 一级分类表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@Mapper
public interface MenuRootDao extends BaseMapper<MenuRootEntity> {
    List<MenuRootEntity> allquery();
	
}
