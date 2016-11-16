package com.james.system.security.impl;

import com.james.system.model.UserModel;
import com.james.system.security.CustomUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by eronzen on 11/15/2016.
 */
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = new UserModel("James");

        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }

        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        auths.add(new GrantedAuthorityImpl("ROLT_USER"));

        user.setAuths(auths);
        return user;
    }
}
