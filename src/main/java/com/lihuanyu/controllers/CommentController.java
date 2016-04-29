package com.lihuanyu.controllers;

import com.lihuanyu.dto.CommentDto;
import com.lihuanyu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/4/29.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment")
    public CommentDto showComment(long courseid){
        return commentService.getComment(courseid);
    }
}
