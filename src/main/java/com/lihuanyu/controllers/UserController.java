package com.lihuanyu.controllers;

import com.lihuanyu.model.CustomUser;
import com.lihuanyu.dao.CustomUserDao;
import com.lihuanyu.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyADMIN on 16/1/27.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CustomUserDao customUserDao;

    private static final double MODULUS = 2.56;//验证码计算系数

    @RequestMapping("/user_info")
    public CustomUser getUserInfo(String nickname){
        CustomUser customUser = null;
        try {
            customUser = customUserDao.findByNickname(nickname);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return customUser;
    }

    @RequestMapping("/login")
    public String doLogin(String email, String password){
        CustomUser customUser = customUserDao.findByMail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password,customUser.getPassword())){
            httpSession.setAttribute("user",customUser);
            return "success";
        }else {
            return "failed";
        }
    }


    /**
     * 验证邮件回执处理
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public String validate(String name, Double validateCode, Date sendDate) throws UnsupportedEncodingException {
        System.out.println("用户名 is " + name);
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (name.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 48) {
            return "验证邮件失效，请重新验证";
        } else {
            CustomUser customUser = customUserDao.findByNickname(name);
            System.out.println(customUser.getNickname());
            if (customUser != null) {
                customUser.setStatus(1);
                customUserDao.save(customUser);
                return "验证成功";
            } else {
                return "验证失败  没有次用户 请重新注册";
            }
        }

    }

    /**
     * 注册
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> create(String name, String mail, String password) {
        System.out.println("name: " + name + "mail " + mail + "password " + password);
        CustomUser customUser = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Map<String, Object> userInfo = new HashMap<>();
        if (customUserDao.findByNickname(name) == null) {
            try {
                customUser = new CustomUser(name, mail, passwordEncoder.encode(password));
                customUserDao.save(customUser);
                userInfo.put("result", "注册成功");
                userInfo.put("id", customUser.getId());
                userInfo.put("nickname", customUser.getNickname());
                userInfo.put("avatar", customUser.getAvatar());
                userInfo.put("password", customUser.getPassword());
                userInfo.put("roleType", customUser.getRole_type());
                userInfo.put("mail", customUser.getMail());

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://localhost:8080/user/validate?&name=");
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
                ex.printStackTrace();
                userInfo.put("result", "注册失败");
                return userInfo;
            }
        } else {
            userInfo.put("result", "用户已存在");
            return userInfo;
        }

    }


    /**
     * 密码重置邮件回执处理
     */
    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    @ResponseBody
    public String resetPassword(String mail, Double validateCode, Date sendDate) throws UnsupportedEncodingException {
        System.out.println("邮箱 is " + mail);
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (mail.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 24) {
            return "验证邮件失效，请重新验证";
        } else {
            CustomUser customUser = customUserDao.findByMail(mail);
            System.out.println(customUser.getMail());
            if (customUser != null) {

                return "验证成功";
            } else {
                return "没有此用户";
            }
        }

    }



    /**
     * 发送重置密码邮件
     */
    @RequestMapping(value = "/reset_mail",method = RequestMethod.POST)
    @ResponseBody
    public boolean create(String mail) {
        System.out.println("mail " + mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (customUserDao.findByMail(mail) != null) {
            try {

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://localhost:8080/validate?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                Double validateCode = mail.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://localhost:8080/validate?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }
}
