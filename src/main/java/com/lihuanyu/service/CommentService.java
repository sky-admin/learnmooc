package com.lihuanyu.service;

import com.lihuanyu.dao.CommentDao;
import com.lihuanyu.dao.CustomUserDao;
import com.lihuanyu.dto.CommentDto;
import com.lihuanyu.dto.CommentNumDto;
import com.lihuanyu.model.Comment;
import com.lihuanyu.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by skyADMIN on 16/4/29.
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CustomUserDao customUserDao;

    public CommentDto getComment(long courseid) {
        Iterable<Comment> comments = commentDao.findByCourseId(courseid);
        Iterator<Comment> it = comments.iterator();
        CommentDto commentDto = new CommentDto();
        ArrayList<CommentDto.CommentList> commentLists = new ArrayList<>();
        while (it.hasNext()) {
            Comment comment = it.next();
            CommentDto.CommentList commentList = new CommentDto().new CommentList();
            commentList.commentContent = comment.getCommentContent();

            long userid = comment.getFromUserId();
            CustomUser customUser = customUserDao.findOne(userid);

            commentList.avatarUrl = customUser.getAvatar();
            commentList.nickname = customUser.getNickname();
            commentLists.add(commentList);
        }
        commentDto.comment = commentLists;
        return commentDto;
    }

    /**
     *获取某个用户的评论总数
     */
    public CommentNumDto getOnesCommentNum(long id) {
        List<Comment> commentList = commentDao.findByFromUserId(id);
        CommentNumDto commentNumDto = new CommentNumDto();
        commentNumDto.commentNum = commentList.size();
        return commentNumDto;
    }
}
