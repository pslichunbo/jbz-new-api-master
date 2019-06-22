package io.renren.modules.app.dao;

import io.renren.modules.app.entity.MenuNextEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 二级分类表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@Mapper
public interface MenuNextDao extends BaseMapper<MenuNextEntity> {
    List<MenuNextEntity> allquery();
    List<MenuNextEntity> queryNext(@Param("id") Long id);
	
}
