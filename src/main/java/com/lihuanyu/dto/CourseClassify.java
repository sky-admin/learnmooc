package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/2.
 */
public class CourseClassify {

    public ArrayList<ClassifyData> classifyData;

    public class ClassifyData {
        public String classifyName;
        public ArrayList<CourseInfo> courseInfo;
    }

    public class CourseInfo {
        public long courseId;
        public String courseName;
        public int num;
        public String thumbnail;
    }
}
