package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/4/29.
 */
public class CommentDto {
    public ArrayList<CommentList> comment;
    public class CommentList {
        public String avatarUrl;
        public String nickname;
        public String commentContent;
    }
}
