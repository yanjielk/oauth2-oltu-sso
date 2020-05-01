package com.oauth2.sso.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oauth2.sso.common.ShiroUtils;
import com.oauth2.sso.common.mybatis.entity.SsoUser;
import com.oauth2.sso.common.mybatis.service.SsoUserService;
import com.oauth2.sso.common.BamboocloudUtils;
import com.oauth2.sso.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    SsoUserService userService;

    @Override
    public String userList() {
        List<SsoUser> ss = userService.selectList(null);
        JSONArray user = new JSONArray();
        Map<String, Object> map = new HashMap<>();
        for (SsoUser entity : ss){
            map.put("id",entity.getId());
            map.put("name",entity.getName());
            user.add(new JSONObject(map));
        }
        return user.toString();
    }

    /**
     *  创建用户
     * */
    @Override
    public boolean userCreate() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        JSONObject json = JSON.parseObject(bodyparam);
        String name = json.getString("username");
        String oldPassword = json.getString("password");
        Map<String, Integer> map = selectByMap();
        if (map.containsKey(name)) {
            return false;
        }
        SsoUser user = new SsoUser();
        user.setId(1);
        user.setName(name);
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        String newPassword = ShiroUtils.sha256(oldPassword, salt);
        user.setPassword(newPassword);
        userService.insert(user);
        return true;
    }

    /**
     *  删除用户
     *
     * */
    @Override
    public boolean userDelete() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        JSONObject json = JSON.parseObject(bodyparam);
        Map<String, Integer> map = selectByMap();
        Integer id = map.get(json.getString("username"));
        userService.deleteById(id);
        return true;
    }

    /**
     *  更新用户(密码)
     *
     * */
    @Override
    public boolean userUpdate() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        JSONObject json = JSON.parseObject(bodyparam);
        String name = json.getString("username");
        Map<String, Integer> map = selectByMap();
        SsoUser olduser = userService.selectById(map.get(name));
        String Password = json.getString("password");
        String newPassword = json.getString("newPassword");
        String oldPassword = ShiroUtils.sha256(Password,olduser.getSalt());
        if (olduser.getPassword() != oldPassword){
            return false;
        }
        olduser.setPassword(ShiroUtils.sha256(newPassword,olduser.getSalt()));
        userService.updateById(olduser);
        return true;
    }

    @Override
    public Map selectByMap() {
        List<SsoUser> ss = userService.selectList(null);
        Map<String, Integer> map = new HashMap<>();
        for (SsoUser entity : ss) {
            map.put(entity.getName(), entity.getId());
        }
        return map;
    }

    public SsoUser selectById(String username){
        Map<String, Integer> map = selectByMap();
        Integer id = map.get(username);
        return userService.selectById(id);
    }

    @Override
    public boolean checkUser(SsoUser user, String password) {
        String pass = ShiroUtils.sha256(password,user.getSalt());
        if (user.getPassword().equals(pass) ){
            return true;
        }
        return false;
    }
}
