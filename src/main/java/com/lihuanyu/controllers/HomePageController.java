package com.lihuanyu.controllers;


import com.lihuanyu.model.TopCourse;
import com.lihuanyu.model.TopCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/1/27.
 */
@RestController
public class HomePageController {
    @RequestMapping("/homepage")
    @ResponseBody
    public Iterable<TopCourse> homePage(){
        Iterable<TopCourse> topCourses = topCourseDao.findAll();
        return topCourses;
    }

    @Autowired
    TopCourseDao topCourseDao;
}
