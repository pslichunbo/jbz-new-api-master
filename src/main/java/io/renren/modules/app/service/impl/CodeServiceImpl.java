package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.CodeDao;
import io.renren.modules.app.entity.CodeEntity;
import io.renren.modules.app.service.CodeService;

import javax.annotation.Resource;


@Service("codeService")
public class CodeServiceImpl extends ServiceImpl<CodeDao, CodeEntity> implements CodeService {

    @Resource
    private CodeDao codeDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CodeEntity> page = this.selectPage(
                new Query<CodeEntity>(params).getPage(),
                new EntityWrapper<CodeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public String code(String phone) {
        CodeEntity code = codeDao.code(phone);
        return code.getCode();
    }

}
