package com.lihuanyu.controllers;

import com.lihuanyu.dao.CommentDao;
import com.lihuanyu.dto.CommentDto;
import com.lihuanyu.dto.CommentNumDto;
import com.lihuanyu.model.Comment;
import com.lihuanyu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by skyADMIN on 16/4/29.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentDao commentDao;

    @RequestMapping("/comment")
    public CommentDto showComment(long courseid) {
        return commentService.getComment(courseid);
    }

    @RequestMapping(value = "/submit_comment", method = RequestMethod.POST)
    public String submitComment(String commentContent, long userId, long courseId) {
        try {
            Comment comment = new Comment(commentContent, userId, courseId, new Date());
            commentDao.save(comment);
            return "发布成功";
        } catch (Exception e) {
            return "发布失败,请重试";
        }

    }

    @RequestMapping(value = "/ones_comments", method = RequestMethod.GET)
    public CommentNumDto getOnesComments(long userId) {
        return commentService.getOnesCommentNum(userId);
    }

}
