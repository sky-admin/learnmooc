package com.lihuanyu.service;

import com.lihuanyu.model.User;
import com.lihuanyu.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skyADMIN on 16/1/28.
 */
@Service("UserService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public Iterable<User> findAll(){
        return userDao.findAll();
    }
}
