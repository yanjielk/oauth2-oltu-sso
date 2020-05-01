package com.oauth2.sso.controller;

import com.oauth2.sso.service.UserService;
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
        return userService.userList();
    }

    /**
     *  {
     *     "username": "admin",
     *     "password": "123456"
     *  }
     */
    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    public String userCreate(){
        if (!userService.userCreate()){
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
        if (!userService.userDelete()){
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
        if (!userService.userUpdate()){
            return "用户修改失败";
        }
        return "用户修改成功";
    }
}
