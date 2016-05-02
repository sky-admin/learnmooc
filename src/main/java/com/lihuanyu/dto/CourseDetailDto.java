package com.lihuanyu.dto;

/**
 * Created by Explorer on 2016/5/2.
 */
public class CourseDetailDto {
    public String courseName;
    public String detail;
    public TeacherInfo teacherInfo;

    public class TeacherInfo {
        public String name;
        public String introduction;
    }
}
