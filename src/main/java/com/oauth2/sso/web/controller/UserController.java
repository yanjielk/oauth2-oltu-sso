package com.oauth2.sso.web.controller;

import com.oauth2.sso.web.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String userList(){
        return userService.userlist();
    }

    /**
     *  {
     *     "username": "admin",
     *     "password": "123456"
     *  }
     */
    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    public String userCreate(){
        if (!userService.usercreate()){
            return "用户创建失败";
        }
        return "用户创建成功";
    }

    /**
     *  {
     *     "username": "admin",
     *  }
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String userDelete(){
        if (!userService.userdelete()){
            return "用户删除失败";
        }
        return "用户删除成功";
    }

    /**
     *  {
     *     "username": "admin",
     *     "password": "123456"
     *     "newPassword": "123456"
     *  }
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String userUpdate(){
        if (!userService.userupdate()){
            return "用户修改失败";
        }
        return "用户修改成功";
    }
}
