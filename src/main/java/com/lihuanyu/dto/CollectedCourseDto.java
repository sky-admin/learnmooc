package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public class CollectedCourseDto {

    public ArrayList<ListCourse> listCourse;

    public class ListCourse {
        public long courseId;
        public String courseName;
        public int num;
        public String pubdate;
        public String thumbnailUrl;
    }
}
