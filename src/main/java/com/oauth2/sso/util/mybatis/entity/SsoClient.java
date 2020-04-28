package com.oauth2.sso.util.mybatis.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 123
 * @since 2020-04-09
 */
@TableName("sso_client")
public class SsoClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("client_name")
    private String clientName;
    @TableField("client_id")
    private String clientId;
    @TableField("client_secret")
    private String clientSecret;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "SsoClient{" +
        ", id=" + id +
        ", clientName=" + clientName +
        ", clientId=" + clientId +
        ", clientSecret=" + clientSecret +
        "}";
    }
}
