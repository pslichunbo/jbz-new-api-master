package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.FileDao;
import io.renren.modules.app.entity.FileEntity;
import io.renren.modules.app.service.FileService;


@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FileEntity> page = this.selectPage(
                new Query<FileEntity>(params).getPage(),
                new EntityWrapper<FileEntity>()
        );

        return new PageUtils(page);
    }

}
