package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dto.CourseDetailDto;
import com.lihuanyu.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Explorer on 2016/5/2.
 */
@Service
public class CourseDetailService {

    @Autowired
    private CourseDao courseDao;

    public CourseDetailDto getCourseInfo(long id) {
        Course course = courseDao.findById(id);
        CourseDetailDto courseDetailDto = new CourseDetailDto();
        courseDetailDto.courseName = course.getCoursename();
        courseDetailDto.detail = course.getDescription();
        CourseDetailDto.TeacherInfo teacherInfo = new CourseDetailDto().new TeacherInfo();
        teacherInfo.name = course.getUser_name();
        courseDetailDto.teacherInfo = teacherInfo;
        return courseDetailDto;
    }
}
