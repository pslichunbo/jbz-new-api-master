package io.renren.modules.app.controller.api;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.renren.modules.app.entity.AreaEntity;
import io.renren.modules.app.entity.PostEntity;
import io.renren.modules.app.service.PostService;
import io.renren.modules.app.service.impl.AreaServiceImpl;
import io.renren.modules.app.service.impl.PostServiceImpl;
import io.renren.modules.app.service.impl.SeekerServiceImpl;
import io.renren.modules.app.vo.SeekerEntityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.app.entity.SeekerEntity;
import io.renren.modules.app.service.SeekerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 求职者简历----找帮手
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:55
 */
@RestController
@RequestMapping("api/seeker")
public class SeekerApiController {
    @Autowired
    private SeekerService seekerService;

    @Autowired
    private SeekerServiceImpl seekerServiceImpl;

    @Autowired
    private AreaServiceImpl areaServiceImpl;

    @Autowired
    private PostServiceImpl postServiceImpl;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = seekerServiceImpl.queryByAll(params);
        List<SeekerEntityVo> list = new ArrayList<>();
        List<SeekerEntity> content = (List<SeekerEntity>) pageUtils.getContent();
        content.stream().forEach(s->list.add(seekerServiceImpl.getSeekerEntityVo(s)));
        pageUtils.setContent(list);
        return R.ok().put("page", pageUtils);
    }


    /**
     * 信息
     * 简历详情
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SeekerEntity seeker = seekerService.selectById(id);
        SeekerEntityVo vo = new SeekerEntityVo();
        vo.setAlterTime(seeker.getAlterTime());
        AreaEntity areaEntity = areaServiceImpl.selectById(seeker.getAreaId());
        vo.setAreaName(areaEntity.getAreaName());
        vo.setBirthday(seeker.getBirthday());
        vo.setCreateTime(seeker.getCreateTime());
        String depict = seeker.getDepict();
        Pattern compile = Pattern.compile("<p.*?><.*?></p>");
        Matcher matcher = compile.matcher(depict);
        while (matcher.find()){
            String group = matcher.group(1);
            vo.setDepict(group);
        }
        vo.setExperience(seeker.getExperience());
        vo.setId(seeker.getId());
        PostEntity postEntity = postServiceImpl.selectById(seeker.getJobId());
        vo.setJob(postEntity.getName());
        vo.setName(seeker.getName());
        String[] split = seeker.getPortrait()
                .replaceAll("[\\[\\]\\\"]", "")
                .split(",");
        vo.setPortrait(split[0]);
        vo.setPhone(seeker.getPhone());
        String[] split1 = seeker.getPhoto()
                .replaceAll("[\\[\\]\\\"]", "")
                .split(",");
        vo.setPhoto(split1);
        vo.setSalary(seeker.getSalary());
        vo.setSex(seeker.getSex());
        vo.setSpecialty(seeker.getSpecialty());
		return R.ok().put("data", vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SeekerEntity seeker){
            seeker.setPhoto(seeker.getPhoto().replaceAll("[\\[\\]\\\"]",""));
            seeker.setCreateTime(new Date());
			seekerService.insert(seeker);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody SeekerEntity seeker){
            seeker.setAlterTime(new Date());
			seekerService.updateById(seeker);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
			seekerService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 查询所有职位
     */
    @GetMapping("/allJob")
    public R allJob(){
        List<PostEntity> postEntities = postServiceImpl.queryAll();
        postEntities.stream().forEach(p->{
            p.setCreateTime(null);
            p.setAlterTime(null);
        });
        return R.ok().put("data",postEntities);
    }

}
