package com.lihuanyu.controllers;

import com.lihuanyu.dto.CourseDetailDto;
import com.lihuanyu.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/2.
 */
@RestController
public class CourseDetailController {

    @Autowired
    private CourseDetailService courseDetailService;

    @RequestMapping(value = "/course_detail", method = RequestMethod.GET)
    public CourseDetailDto getCourseDetail(long courseId) {
        return courseDetailService.getCourseInfo(courseId);
    }
}
