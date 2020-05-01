package com.oauth2.sso.service.impl;

import com.oauth2.sso.common.redis.RedisTool;
import com.oauth2.sso.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceimpl implements CacheService {

    @Autowired
    RedisTool redisTool;

    @Override
    public void codeSave(String code, String name) {
        redisTool.set(code, name, 600);
    }

    @Override
    public Boolean codeCahce(String code) {
        return redisTool.hasKey(code);
    }

    @Override
    public void toKenSave(String token, String name) {
        redisTool.set(token, name, 600);
    }

    @Override
    public Boolean toKenCahce(String token) {
        return redisTool.hasKey(token);
    }

    @Override
    public String getNameByToken(String token) {
        return redisTool.get(token).toString();
    }

    @Override
    public String getNameByCode(String code) {
        return redisTool.get(code).toString();
    }
}
