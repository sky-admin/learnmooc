package com.lihuanyu.controllers;

import com.lihuanyu.dto.SearchResultDto;
import com.lihuanyu.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/4.
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public SearchResultDto getSearchResult(String courseName) {
//        //SearchResultDto searchResult = searchService.getSearchResult(courseName);
//        //return searchResult;
//
//    }
}
