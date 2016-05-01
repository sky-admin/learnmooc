package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/1.
 */
public class MainCourseJson {
    public String more;
    public ArrayList<ListCourse> listCourse;
    public ArrayList<TopCourse> topCourse;

    public class ListCourse {
        public int courseId;
        public String courseName;
        public int num;
        public String pubdate;
        public String thumbnailUrl;
    }

    public class TopCourse {
        public int courseId;
        public String pubdate;
        public String topCourseImgUrl;
    }
}
