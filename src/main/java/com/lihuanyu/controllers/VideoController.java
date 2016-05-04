package com.lihuanyu.controllers;

import com.lihuanyu.dto.VideoInfoDto;
import com.lihuanyu.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/2.
 */
@RestController
public class VideoController {

    @Autowired
    private VideoInfoService videoInfoService;


    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public VideoInfoDto getVideoInfo(long courseId) {
        return videoInfoService.getCourseVideoInfo(courseId);
    }
}
