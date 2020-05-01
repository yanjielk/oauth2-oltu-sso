package com.oauth2.sso.common;

import com.oauth2.sso.common.mybatis.entity.SsoUser;
import com.oauth2.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class SystemLogin {

    @Autowired
    UserService userService;

    public boolean login(HttpServletRequest request) {
        if ("get".equalsIgnoreCase(request.getMethod())) {
            request.setAttribute("error", "非法的请求");
            return false;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("error", "登录失败:用户名或密码不能为空");
            return false;
        }

        try {
            // 写登录逻辑
            SsoUser user = userService.selectById(username);
            if (user != null) {
                if (userService.checkUser(user, password)) {
                    return true;
                } else {
                    request.setAttribute("error", "登录失败:密码错误");
                    return false;
                }
            } else {
                request.setAttribute("error", "登录失败:用户名不正确");
                return false;
            }
        } catch (Exception e) {
            request.setAttribute("error", "登录失败:" + e.getClass().getName());
            return false;
        }
    }
}
