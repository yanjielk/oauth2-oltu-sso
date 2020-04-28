package com.oauth2.sso.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oauth2.sso.util.mybatis.entity.SsoClient;
import com.oauth2.sso.util.mybatis.service.SsoClientService;
import com.oauth2.sso.web.common.BamboocloudUtils;
import com.oauth2.sso.web.service.ClientService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class ClientServiceimpl implements ClientService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    SsoClientService clientService;

    @Override
    public JSONArray clientlist() {
        List<SsoClient> ss = clientService.selectList(null);
        JSONArray user = new JSONArray();
        Map<String, Object> map = new HashMap<>();
        for (SsoClient entity : ss){
            map.put("id",entity.getId());
            map.put("name",entity.getClientName());
            map.put("clientId",entity.getClientId());
            map.put("clientSecret",entity.getClientSecret());
            JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
            user.add(json);
        }
        return user;
    }

    @Override
    public boolean clientcreate() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        System.out.println(bodyparam);
        JSONObject json = JSON.parseObject(bodyparam);
        String name = json.getString("clientname");
        SsoClient client = new SsoClient();
        Map<String , Integer> map = selectByMap();
        if (map.containsKey(name)){
            return false;
        }
        Integer id = maxId() + 1;
        client.setId(id);
        client.setClientName(name);
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        clientService.insert(client);
        return true;
    }

    @Override
    public boolean clientdelete() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        System.out.println("bodyparam:"+bodyparam);
        JSONObject json = JSON.parseObject(bodyparam);
        Map<String , Integer> map = selectByMap();
        if (!map.containsKey(json.getString("clientname"))){
            System.out.println("ddddddd");
            return false;
        }
        Integer id = map.get(json.getString("clientname"));
        clientService.deleteById(id);
        return true;
    }

    @Override
    public boolean clientupdate() {
        String bodyparam = BamboocloudUtils.getRequestBody(request);
        JSONObject json = JSON.parseObject(bodyparam);
        String newName = json.getString("newClientname");
        Map<String , Integer> map = selectByMap();
        SsoClient client = clientService.selectById(map.get(json.getString("clientname")));
        if (map.containsKey(newName)){
            return false;
        }
        client.setClientName(newName);
        clientService.updateById(client);
        return true;
    }

    public Map selectByMap() {
        List<SsoClient> ss = clientService.selectList(null);
        Map<String, Integer> map = new HashMap<>();
        for (SsoClient entity : ss) {
            map.put(entity.getClientName(), entity.getId());
        }
        return map;
    }

    @Override
    public boolean checkClientId(String clientId,String clientSecret) {
        JSONArray json = clientlist();
        Map<String,Integer> map = new HashedMap();
        for(int i=0;i<json.size();i++) {
            JSONObject jsonObject = json.getJSONObject(i);
            String id = jsonObject.getString("clientId");
            map.put(id,i);
        }
        if (clientSecret == ""){
            if (map.containsKey(clientId)){
                return true;
            }
        }else {
            if (map.containsKey(clientId)){
                JSONObject info =  json.getJSONObject(map.get(clientId));
                if (clientSecret.equals(info.get("clientSecret"))){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public Integer maxId(){
        List<SsoClient> ss = clientService.selectList(null);
        List<Integer> idList = new ArrayList<>();

        for (SsoClient entity : ss) {
            idList.add(entity.getId());
        }
        if (idList.size() == 0){
            return 0;
        }
        idList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = o1 < o2 ? 1 : -1;
                return i;
            }
        });
        return idList.get(0);
    }

}
