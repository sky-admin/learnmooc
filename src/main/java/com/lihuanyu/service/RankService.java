package com.lihuanyu.service;

import com.lihuanyu.dao.CustomUserDao;
import com.lihuanyu.dto.RankDto;
import com.lihuanyu.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

/**
 * Created by skyADMIN on 16/5/4.
 */
@Service
public class RankService {

    @Autowired
    private CustomUserDao customUserDao;

    private Sort sortByExpDesc() {
        return new Sort(Sort.Direction.DESC, "exp");
    }

    public RankDto getRankList() {
        RankDto rankDto = new RankDto();
        rankDto.rankData = new ArrayList<>();
        Iterable<CustomUser> customUsers = customUserDao.findAll(sortByExpDesc());
        for (CustomUser customUser : customUsers) {
            RankDto.RankDataJson rankDataJson = new RankDto().new RankDataJson();
            rankDataJson.id = customUser.getId();
            rankDataJson.avatar = customUser.getAvatar();
            rankDataJson.nickname = customUser.getNickname();
            rankDataJson.score = (int) customUser.getExp();
            rankDto.rankData.add(rankDataJson);
        }
        return rankDto;
    }
}
