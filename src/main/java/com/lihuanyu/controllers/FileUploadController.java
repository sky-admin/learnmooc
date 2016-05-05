package com.lihuanyu.controllers;

import com.lihuanyu.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Explorer on 2016/5/4.
 */
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/save_avatar", method = RequestMethod.POST)
    public String saveAvatar(long userId, String avatar) {

        return fileUploadService.saveAvatar(userId, avatar);
    }

}
