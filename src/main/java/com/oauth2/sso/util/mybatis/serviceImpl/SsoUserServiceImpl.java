package com.oauth2.sso.util.mybatis.serviceImpl;

import com.oauth2.sso.util.mybatis.entity.SsoUser;
import com.oauth2.sso.util.mybatis.mapper.SsoUserMapper;
import com.oauth2.sso.util.mybatis.service.SsoUserService;
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
public class SsoUserServiceImpl extends ServiceImpl<SsoUserMapper, SsoUser> implements SsoUserService {

}
