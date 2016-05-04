package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dto.VideoInfoDto;
import com.lihuanyu.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Explorer on 2016/5/2.
 */
@Service
public class VideoInfoService {
    @Autowired
    private CourseDao courseDao;


    public VideoInfoDto getCourseVideoInfo(long id) {
        Course course = courseDao.findById(id);
        VideoInfoDto videoInfoDto = new VideoInfoDto();
        videoInfoDto.courseName = course.getCourse_name();
        videoInfoDto.videoUrl = course.getCourse_video_url();
        return videoInfoDto;
    }
}
