package com.macro.mall.app.config;

import com.macro.mall.app.service.impl.YxxWorkerService;
import com.macro.mall.security.config.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * mall-security模块相关配置
 *
 * @author macro
 * @date 2019/11/5
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class YxxAppSecurityConfig extends SecurityConfig {

    private final YxxWorkerService memberService;

    public YxxAppSecurityConfig(@Lazy YxxWorkerService memberService) {
        this.memberService = memberService;
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return memberService::loadUserByPhone;
    }
}
