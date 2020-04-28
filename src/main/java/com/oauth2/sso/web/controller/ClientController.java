package com.oauth2.sso.web.controller;

import com.oauth2.sso.web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    private HttpHeaders headers = new HttpHeaders();

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public String clientList() {
        return clientService.clientlist().toString();
    }

    /**
     * {
     * "clientname": "oauth",
     * }
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String clientCreate() {
        if (!clientService.clientcreate()) {
            return "创建client失败";
        }
        return "创建client成功";
    }

    /**
     * {
     * "clientname": "oauth",
     * }
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object clientDelete() {
        headers.set("Content-Type", "application/json; charset=utf-8");
        if (!clientService.clientdelete()) {
            return "删除client失败";
        }
        return "删除client成功";
    }

    /**
     * {
     * "clientname": "oauth",
     * "newClientname": "oauth",
     * }
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String clientUpdate() {
        if (!clientService.clientupdate()) {
            return "修改client失败";
        }
        return "修改client成功";
    }
}
