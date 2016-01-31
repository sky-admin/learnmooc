package com.lihuanyu.controllers;

import com.lihuanyu.model.User;
import com.lihuanyu.model.UserDao;
import com.lihuanyu.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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
    private static final double MODULUS = 2.56;//验证码计算系数

    @RequestMapping("/list")
    @ResponseBody
    public Iterator<User> list() {
        Iterable<User> users = userDao.findAll();
        return users.iterator();

    }

    @RequestMapping("/user")
    @ResponseBody
    public User find(long id) {
        User user = null;
        try {
            user = userDao.findById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }


    /**
     * 验证邮件回执处理
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public String validate(String name, Double validateCode, Date sendDate) throws UnsupportedEncodingException {
        System.out.println("用户名 is" + name);
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (name.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 48) {
            return "验证邮件失效，请重新验证";
        } else {
            User user = userDao.findByName(name.getBytes("UTF-8").toString());
            if (user != null) {
                user.setStatus(1);
                return "验证成功";
            } else {
                return "验证失败  没有次用户 请重新注册";
            }
        }

    }

    /**
     * 注册
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> create(String name, String mail, String password) {
        User user = null;
        Map<String, Object> userInfo = new HashMap<>();
        if (userDao.findByName(name) == null) {
            try {
                user = new User(name, mail, encode(password));
                userDao.save(user);
                userInfo.put("result", "注册成功");
                userInfo.put("id", user.getId());
                userInfo.put("nickname", user.getNickname());
                userInfo.put("avatar", user.getAvatar());
                userInfo.put("password", user.getPassword());
                userInfo.put("roleType", user.getRole_type());
                userInfo.put("mail", user.getMail());

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://localhost:8080/validate?&name=");
                sb.append(name);
                sb.append("&validateCode=");
                Double validateCode = name.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://localhost:8080/validate?&mail=");
                sb.append(name);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return userInfo;
            } catch (Exception ex) {
                userInfo.put("result", "注册失败");
                return userInfo;
            }
        } else {
            userInfo.put("result", "用户已存在");
            return userInfo;
        }

    }
}
