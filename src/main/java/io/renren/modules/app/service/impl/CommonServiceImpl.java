package io.renren.modules.app.service.impl;

import com.google.gson.Gson;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.app.service.CommonService;
import io.renren.modules.oss.entity.SysOssEntity;
import io.renren.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import java.io.IOException;

@Service
public class CommonServiceImpl implements CommonService {

    //七牛云相关参数
    public static final String ACCESS_KEY = "AsoVjc0GEWtZ5tHkxW9jSJNczFzj7N1MG02FIjgm";
    public static final String SECRET_KEY = "iGMcQAaXJ4HSNlnIQ6ScA6cqeJ1Uw9Uk1aVb9MUV";
    public static final String BUCKET_NAME = "jbzdemo";
    public static final String QNURL = "http://www.jbzyn.club/";


    @Autowired
    private SysConfigService sysConfigService;
    /**
     * 文件上传
     *
     * @param multipartFile 文件
     * @return 返回的文件地址
     */
    public R fileUpload(MultipartFile multipartFile) {


        String result =null;
        if (multipartFile.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }

            Configuration cfg = new Configuration(Zone.zone2());
            UploadManager uploadManager = new UploadManager(cfg);
            String key = null;
            String url = null;
            try {
                byte[] uploadBytes = multipartFile.getBytes();
                Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
                String upToken = auth.uploadToken(BUCKET_NAME);
                try {
                    Response response = uploadManager.put(uploadBytes, key, upToken);
                    //解析上传成功结果
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    url = QNURL + putRet.key;

                } catch (QiniuException ex) {
                    Response r = ex.response;
                    System.err.println(r.toString());
                    try {
                        System.err.println(r.bodyString());
                    } catch (Exception ex2) {
                        return R.error("Exception 异常");
                    }
                }
            } catch (IOException ex) {
                return R.error("IOException 异常");
            }
            result = url;

        return R.ok().put("data",result);
    }

}
