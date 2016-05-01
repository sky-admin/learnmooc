package com.lihuanyu.controllers;

import com.lihuanyu.dto.UpdateMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/5/1.
 */
@RestController
public class UpdateAppController {

    @RequestMapping("/checkupdate")
    public UpdateMessage getUpdateMessage(){
        UpdateMessage updateMessage = new UpdateMessage();
        updateMessage.description = "测试版本更新功能";
        updateMessage.downloadUrl = "http://120.27.47.134/update/update.apk";
        updateMessage.versionCode = 2;
        updateMessage.versionName = "2.0";
        updateMessage.apkName = "update.apk";
        return updateMessage;
    }
}
