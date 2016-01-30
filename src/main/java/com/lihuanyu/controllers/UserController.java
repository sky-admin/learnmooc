package com.lihuanyu.controllers;

import com.lihuanyu.model.User;
import com.lihuanyu.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.lihuanyu.utils.MD5Utils.encode;

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

    /**
     * 注册
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> create(String name,String mail,String password) {
        User user = null;
        Map<String,Object> userInfo = new HashMap<>();
        if(userDao.findByName(name) == null){
            try {
                user = new User(name, mail,encode(password));
                userDao.save(user);
                userInfo.put("result","注册成功");
                userInfo.put("id",user.getId());
                userInfo.put("nickname",user.getNickname());
                userInfo.put("avatar",user.getAvatar());
                userInfo.put("password",user.getPassword());
                userInfo.put("roleType",user.getRole_type());
                userInfo.put("mail",user.getMail());
                return userInfo;
            }
            catch (Exception ex) {
                userInfo.put("result","注册失败");
                return userInfo;
            }
        }else {
            userInfo.put("result","用户已存在");
            return userInfo;
        }

    }
}
