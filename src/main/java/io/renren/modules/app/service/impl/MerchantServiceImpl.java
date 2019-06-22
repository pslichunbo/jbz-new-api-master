package io.renren.modules.app.service.impl;

import io.renren.modules.app.entity.LabelEntity;
import io.renren.modules.app.vo.MerVo;
import io.renren.modules.app.vo.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MerchantDao;
import io.renren.modules.app.entity.MerchantEntity;
import io.renren.modules.app.service.MerchantService;

import javax.annotation.Resource;


@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, MerchantEntity> implements MerchantService {
    @Autowired
    private LabelServiceImpl labelServiceImpl;
    @Autowired
    private MerchantTypeServiceImpl merchantTypeServiceImpl;
    @Resource
    private MerchantDao merchantDao;
    @Override

    public PageUtils queryPage(Map<String, Object> params) {
            Page<MerchantEntity> page = this.selectPage(
                    new Query<MerchantEntity>(params).getPage(),
                    new EntityWrapper<MerchantEntity>()
            );
            return new PageUtils(page);
        }

    @Override
    public PageUtils queryPageOne(Map<String, Object> params) {
        String type = (String)params.get("type_id");
        if("".equals(type) || type ==null){
            Page<MerchantEntity> page = this.selectPage(
                    new Query<MerchantEntity>(params).getPage(),
                    new EntityWrapper<MerchantEntity>()
            );
            return new PageUtils(page);
        }else{
            Long t = Long.parseLong(type);
            Page<MerchantEntity> page = this.selectPage(
                    new Query<MerchantEntity>(params).getPage(),
                    new EntityWrapper<MerchantEntity>().where("type_id = {0}",t)
            );
            return new PageUtils(page);
        }
    }

    @Override
    public Boolean removeById(Long id, Long userId) {
        MerchantEntity merchantEntity= new MerchantEntity();
        merchantEntity.setId(id);
        merchantEntity.setUserId(userId);
        return merchantDao.removeById(merchantEntity);
    }

    public PageUtils queryById(Map<String, Object> params){
        String sort = (String) params.get("sort");
        String[] s = sort.split(",");
        Boolean tag;
        if("asc".equals(s[1])){
            tag = true;
        }else {
            tag = false;
        }
        String area = params.get("area").toString();
        String label = params.get("label").toString();
        Page<MerchantEntity> page = this.selectPage(
               new Query<MerchantEntity>(params).getPage(),
               new EntityWrapper<>(new MerchantEntity())
               .where("del_sign = 0 and state = 0 and area_sign = {0} and label_id = {1}",area,label)
                .orderBy(s[0],tag)
       );
        List<MerchantEntity> records = page.getRecords();
        List<MerchantVo> list = new ArrayList<>();
        for (MerchantEntity m : records){
            MerchantVo vo = new MerchantVo();
            vo.setAddress(m.getAddress());
            vo.setArea(m.getArea());
            vo.setCountNum(m.getCountNum());
            vo.setDistance(m.getDistance());
            vo.setId(m.getId());
            String[] split = m.getImageUrl().split(",");
            List<String> strings = Arrays.asList(split);
            vo.setImageUrl(strings);
            Long labelId = m.getLabelId();
            LabelEntity labelEntity = labelServiceImpl.selectById(labelId);
            vo.setLabelSet(labelEntity);
            vo.setLat(m.getLat());
            vo.setLinkMan(m.getLinkMan());
            vo.setLinkTel(m.getLinkTel());
            vo.setLng(m.getLng());
            vo.setMoney(m.getMoney());
            list.add(vo);
        }
        Page<MerchantVo> page1 = new Query<MerchantVo>(params).getPage();
        page1.setRecords(list);
        return new PageUtils(page1);
    }

    public PageUtils queryAll(Map<String, Object> params){
        Page<MerchantEntity> page = this.selectPage(
                new Query<MerchantEntity>(params).getPage(),
                new EntityWrapper<>(new MerchantEntity())
        );
        List<MerchantEntity> records = page.getRecords();
        List<MerVo> list = new ArrayList<>();
        for (MerchantEntity m : records){
            MerVo vo = new MerVo();
            vo.setAddress(m.getAddress());
            vo.setArea(m.getArea());
            vo.setCountNum(m.getCountNum());
            vo.setDistance(m.getDistance());
            vo.setId(m.getId());
            String[] split = m.getImageUrl().split(",");
            List<String> strings = Arrays.asList(split);
            vo.setImageUrl(strings);
            Long labelId = m.getLabelId();
            LabelEntity labelEntity = labelServiceImpl.selectById(labelId);
            vo.setLabelSet(labelEntity);
            vo.setLat(m.getLat());
            vo.setLinkMan(m.getLinkMan());
            vo.setLinkTel(m.getLinkTel());
            vo.setLng(m.getLng());
            vo.setMoney(m.getMoney());
            vo.setName(m.getName());
            vo.setPost(m.getPost());
            vo.setRemark(m.getRemark());
            vo.setStataDate(m.getStataDate());
            list.add(vo);
        }
        Page<MerVo> page1 = new Query<MerVo>(params).getPage();
        page1.setRecords(list);
        return new PageUtils(page1);
    }

    public List<MerchantEntity> queryAll(){
        EntityWrapper ew = new EntityWrapper(new MerchantEntity());
        ew.where("state = 0");
        return this.selectList(ew);
    }

}
