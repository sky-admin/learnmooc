package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public class NoteDetailDto {

    public ArrayList<NoteDetailInfo> noteDetail;

    public class NoteDetailInfo {
        public long noteId;
        public String time;
        public String content;
    }
}
