package com.oauth2.sso.web.service;

import com.alibaba.fastjson.JSONArray;

public interface ClientService {


    JSONArray clientlist();

    boolean clientcreate();

    boolean clientdelete();

    boolean clientupdate();

    boolean checkClientId(String clientId,String clientSecret);
}
