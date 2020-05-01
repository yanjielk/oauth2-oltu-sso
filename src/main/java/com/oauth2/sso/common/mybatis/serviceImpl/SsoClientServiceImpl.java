package com.oauth2.sso.common.mybatis.serviceImpl;

import com.oauth2.sso.common.mybatis.entity.SsoClient;
import com.oauth2.sso.common.mybatis.mapper.SsoClientMapper;
import com.oauth2.sso.common.mybatis.service.SsoClientService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2020-04-09
 */
@Service
public class SsoClientServiceImpl extends ServiceImpl<SsoClientMapper, SsoClient> implements SsoClientService {

}
