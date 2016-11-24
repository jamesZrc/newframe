package com.james.system.security.impl;

import com.james.system.model.UserModel;
import com.james.system.security.CustomUserDetailsService;
import com.james.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by eronzen on 11/15/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userService.getUserByUsername(username);

        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new GrantedAuthorityImpl("ROLE_USER"));

        user.setAuthorities(auths);
        return user;
    }
}
