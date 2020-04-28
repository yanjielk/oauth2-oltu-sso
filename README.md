# OAuth2 sso 授权中心

### springboot

**启动: SsoApplication**

账号:	admin/123456

1.浏览器方式

```
http://localhost:8088/authorize?client_id=0f112be3-ffd2-4957-9e7f-57db8842d3d0&response_type=code&redirect_uri=http://www.baidu.com

返回:https://www.baidu.com/?code=d7a36e37c71d5119639978aea14154bf
code 为授权码 "code=d7a36e37c71d5119639978aea14154bf"

获取token地址:
http://localhost:8088/access  
填写：
ClientId:0f112be3-ffd2-4957-9e7f-57db8842d3d0
ClientSecret:e3234b95-3c3d-4ece-aa87-2099abd7dfa2
code：***
回调地址:http://www.baidu.com

返回:
Access Token  =  81cf7b1c473f1b6c477ab2aae2d8ea84
通过浏览器请求(access_token 更换为获取到的token)
http://localhost:8088/oauth/userInfo?access_token=987155f4aa2d050dfe1010929922fa19
```

2. 通过postman,选择oauth2.0


```
授权地址:http://localhost:8088/authorize
获取token地址:http://localhost:8088/accessToken
ClientId:0f112be3-ffd2-4957-9e7f-57db8842d3d0
ClientSecret:e3234b95-3c3d-4ece-aa87-2099abd7dfa2
回调地址:http://www.baidu.com


登录:admin/123456

获取token

通过浏览器请求(access_token 更换为获取到的token)
http://localhost:8088/oauth/userInfo?access_token=6e4078d792b703748b7273876e1c26ae
```

```
postman
client 新增,修改,删除:
localhost:8088/client/create  {"clientname": "admin"}

localhost:8088/client/delete  {"clientname": "admin"}

localhost:8088/client/update  {"clientname": "admin", "newClientname":"super"}

用户 新增,修改,删除:
localhost:8088/user/create    {"username": "super","password":"123456"}

localhost:8088/user/delete    {"username": "super"}

localhost:8088/user/delete    {"username": "super","password":"123456","newPassword":"newPassword"}

持续补充，通过页面方式新增信息。
```

