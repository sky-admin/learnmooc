package com.lihuanyu.service;

import com.lihuanyu.dao.CustomUserDao;
import com.lihuanyu.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Explorer on 2016/5/4.
 */
@Service
public class FileUploadService {
    @Autowired
    private CustomUserDao customUserDao;

    @Autowired
    HttpServletRequest httpServletRequest;

    public String saveAvatar(long userId, String avatar) {
        // 获取文件类型 .**
        String type = ".png";
        // 取当前时间戳为文件名
        String filename = System.currentTimeMillis() + type;
        // 存放位置
        String path1 = httpServletRequest.getSession().getServletContext()
                .getRealPath("/upload/" + filename);
        String path = "/home/wwwroot/default" + "/avatar/" + filename;
        BASE64Decoder decoder = new BASE64Decoder();
        FileOutputStream write = null;
        try {
            File destFile = new File(path);
            write = new FileOutputStream(destFile);
            byte[] decoderBytes = decoder.decodeBuffer(avatar);
            write.write(decoderBytes);

            CustomUser userInfo = customUserDao.findById(userId);
            userInfo.setAvatar("http://120.27.47.134" + destFile.getAbsolutePath().replace("/home/wwwroot/default",""));
            customUserDao.save(userInfo);
            return userInfo.getAvatar();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return "failed";

        return path1;
    }

}
