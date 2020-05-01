package com.oauth2.sso.service;

import com.alibaba.fastjson.JSONArray;

public interface ClientService {


    JSONArray clientList();

    boolean clientCreate();

    boolean clientDelete();

    boolean clientUpdate();

    boolean checkClientId(String clientId,String clientSecret);
}
