package com.oauth2.sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@CrossOrigin    // 跨域问题
@Controller
public class IndexController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/access",method = RequestMethod.GET)
    public String index() {
        return "access";
    }

}

