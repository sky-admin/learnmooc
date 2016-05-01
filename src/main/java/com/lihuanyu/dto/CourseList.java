package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/1.
 */
public class CourseList {

    public String more;
    public ArrayList<ListCourse> listCourse;

    public class ListCourse {
        public long courseId;
        public String courseName;
        public int num;
        public String pubdate;
        public String thumbnailUrl;
    }
}
