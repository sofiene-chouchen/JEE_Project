package com.polytechnique.JEE.project.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
  UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=userService.loadUserByUsername(username).orElse(null);
    List<GrantedAuthority> authorityList=new ArrayList<>();
    user.getRoles().forEach((e)->{
      authorityList.add(new SimpleGrantedAuthority(e.getName()));
    });
    return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorityList);

  }
}
