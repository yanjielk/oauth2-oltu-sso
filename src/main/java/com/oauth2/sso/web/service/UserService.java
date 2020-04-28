package com.oauth2.sso.web.service;

import com.oauth2.sso.util.mybatis.entity.SsoUser;

import java.util.Map;

public interface UserService {

    String userlist();

    boolean usercreate();

    boolean userdelete();

    boolean userupdate();

    Map selectByMap();

    SsoUser selectById(String username);

    boolean checkUser(SsoUser user ,String password);
}
