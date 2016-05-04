package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dto.SearchResultDto;
import com.lihuanyu.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/4.
 */
@Service
public class SearchService {
    @Autowired
    private CourseDao courseDao;

    public SearchResultDto getSearchResult(String courseName) {
        Iterable<Course> courseList = courseDao.findByCourse__name(courseName);
        SearchResultDto searchResultDto = new SearchResultDto();
        ArrayList<SearchResultDto.SearchInfo> list = new ArrayList<>();
        for (Course course : courseList) {
            SearchResultDto.SearchInfo searchInfo = new SearchResultDto().new SearchInfo();
            searchInfo.courseId = course.getId();
            searchInfo.courseName = course.getCourse_name();
            searchInfo.num = course.getNum();
            searchInfo.thumbnailUrl = course.getThumbnail();
            searchInfo.pubdate = course.getCreate_date().toString();
            list.add(searchInfo);
        }
        searchResultDto.searchResult = list;
        return searchResultDto;
    }

}
