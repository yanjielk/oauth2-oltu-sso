package com.oauth2.sso.service;

import com.oauth2.sso.common.mybatis.entity.SsoUser;

import java.util.Map;

public interface UserService {

    String userList();

    boolean userCreate();

    boolean userDelete();

    boolean userUpdate();

    Map selectByMap();

    SsoUser selectById(String username);

    boolean checkUser(SsoUser user ,String password);
}
