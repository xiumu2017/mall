package com.macro.mall.app.domain;

import com.macro.mall.model.YxxWorker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 会员详情封装
 *
 * @author macro
 * @date 2018/8/3
 */
public class WorkerDetails implements UserDetails {
    private YxxWorker yxxWorker;

    public WorkerDetails(YxxWorker yxxWorker) {
        this.yxxWorker = yxxWorker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Collections.singletonList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return yxxWorker.getPassword();
    }

    @Override
    public String getUsername() {
        return yxxWorker.getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return yxxWorker.getEnable() == 1;
    }

    public YxxWorker getYxxWorker() {
        return yxxWorker;
    }
}
