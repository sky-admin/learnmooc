package com.lihuanyu.controllers;

import com.lihuanyu.dto.ChapterInfo;
import com.lihuanyu.service.ChapterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/4/28.
 */
@RestController
public class ChapterController {

    @Autowired
    private ChapterInfoService chapterInfoService;

    @RequestMapping(value = "/chapterinfo",method = RequestMethod.GET)
    public ChapterInfo showChapterInfo(int courseid){
        return chapterInfoService.getChapterInfo(courseid);
    }
}
