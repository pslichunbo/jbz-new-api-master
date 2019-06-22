package io.renren.modules.app.controller.api;

import io.renren.common.utils.R;
import io.renren.modules.app.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonClontroller {

    @Autowired
    private CommonService commonServiceImpl;

    @PostMapping("/file")
    public R fileUpLoad(@RequestParam("file") MultipartFile[] file){
        List<String> arr = new ArrayList<>();
        for(MultipartFile s : file){
            String suffix = s.getOriginalFilename().substring(s.getOriginalFilename().lastIndexOf("."));
            R url = commonServiceImpl.fileUpload(s);
            String r = (String)url.get("data");
            arr.add(r);
        }
            return R.ok().put("data",arr);
    }

}
