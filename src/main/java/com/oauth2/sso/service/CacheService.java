package com.oauth2.sso.service;

public interface CacheService {

    void codeSave(String code,String name);

    Boolean codeCahce(String code);

    void toKenSave(String token,String name);

    Boolean toKenCahce(String token);

    String getNameByCode(String code);

    String getNameByToken(String token);

}
