package com.lihuanyu.controllers;

import com.lihuanyu.model.User;
import com.lihuanyu.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/list")
    @ResponseBody
    public Iterator<User> list(){
        Iterable<User> users = userDao.findAll();
        return users.iterator();

    }

    @RequestMapping("/user")
    @ResponseBody
    public User find(long id){
        User user = null;
        try {
            user = userDao.findById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String password) {
        User user = null;
        try {
            user = new User(name, password);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }
}
