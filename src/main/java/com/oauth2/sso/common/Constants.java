package com.oauth2.sso.common;

public class Constants {
    public static final String ACCESS = "登录成功";
    public static final String failure = "登录失败";

    public static final String INVALID_USERS = "登录失败:用户名或密码不能为空";
    public static final String INVALID_PASSWORD = "登录失败:密码错误";
    public static final String INVALID_USER = "登录失败:用户名不正确";
    public static final String RESOURCE_SERVER_NAME = "oauth-server";
    public static final String INVALID_CLIENT_ID = "客户端验证失败，client_id 不正确";
    public static final String INVALID_CLIENT = "客户端验证失败，client_id或者client_secret 不正确";

    public static final String INVALID_ACCESS_TOKEN = "accessToken无效或已过期。";
    public static final String INVALID_REDIRECT_URI = "缺少授权成功后的回调地址。";
    public static final String INVALID_AUTH_CODE = "错误的授权码。";

}
