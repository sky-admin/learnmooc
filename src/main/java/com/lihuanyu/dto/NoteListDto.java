package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public class NoteListDto {
    public ArrayList<NoteInfo> listCourse;

    public class NoteInfo {
        public long courseId;
        public String courseName;
        public int noteNum;
        public String thumbnailUrl;
    }
}
