package com.lihuanyu.controllers;

import com.lihuanyu.dto.CollectedCourseDto;
import com.lihuanyu.dto.CourseClassify;
import com.lihuanyu.dto.CourseList;
import com.lihuanyu.dto.MainCourseJson;
import com.lihuanyu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/5/1.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/classify")
    public CourseClassify getClassify() {
        return courseService.getCourseClassify();
    }

    @RequestMapping("/maincourse")
    public MainCourseJson getMainCourse() {
        return courseService.getMainCourse();
    }

    @RequestMapping("/courselist")
    public CourseList getAllCourse(int page) {
        return courseService.getCouseListByPage(page);
    }


    @RequestMapping("/course_collection")
    public String setCollection(long userId, long courseId) {
        courseService.saveCollection(userId, courseId);
        return "success";
    }

    @RequestMapping("/rm_course_collection")
    public String removeCollection(long userId, long courseId) {
        courseService.removeCollection(userId, courseId);
        return "success";
    }

    @RequestMapping(value = "/has_collected_course", method = RequestMethod.GET)
    public CollectedCourseDto getHasCollectedCourse(long userId) {
        CollectedCourseDto collectedCourse = courseService.getCollectedCourse(userId);
        return collectedCourse;
    }
}
