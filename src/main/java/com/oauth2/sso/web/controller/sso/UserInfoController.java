package com.oauth2.sso.web.controller.sso;

import com.alibaba.fastjson.JSON;
import com.oauth2.sso.web.common.Constants;
import com.oauth2.sso.util.mybatis.entity.SsoUser;
import com.oauth2.sso.web.service.OAuthService;
import com.oauth2.sso.web.service.UserService;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/oauth")
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    OAuthService oAuthService;

    @RequestMapping(value = "/userInfo")
    public Object userInfo(HttpServletRequest request) throws OAuthSystemException {
        return checkAccessToken(request);
    }

    public Object checkAccessToken(HttpServletRequest request) throws OAuthSystemException {
        try {
            //构建OAuth资源请求
            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
            //获取Access Token
            String accessToken = oauthRequest.getAccessToken();
            //验证Access Token
            if (!oAuthService.checkAccessToken(accessToken)) {
                // 如果不存在/过期了
                return Constants.INVALID_ACCESS_TOKEN;
            }
            //获取用户名
            String username = oAuthService.getUsernameByAccessToken(accessToken);
            SsoUser user = userService.selectById(username);
            String json = JSON.toJSONString(user);
            return new ResponseEntity<>(json,HttpStatus.OK);
        } catch (OAuthProblemException e) {

        }

        return "";
    }
}
