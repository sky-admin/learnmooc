package com.lihuanyu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skyADMIN on 16/2/1.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }
}
