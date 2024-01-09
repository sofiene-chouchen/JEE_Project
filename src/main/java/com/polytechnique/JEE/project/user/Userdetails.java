package com.polytechnique.JEE.project.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Userdetails implements UserDetails {
  private String email;
  private String password;
  private List<GrantedAuthority> roles;

  public Userdetails(User ourUser) {
    this.email = ourUser.getEmail();
    this.password = ourUser.getPassword();
    List<GrantedAuthority> authorityList = new ArrayList<>();
    ourUser.getRoles().forEach(e -> authorityList.add(new SimpleGrantedAuthority(e.getName())));

    this.roles = authorityList;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.email;
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
    return true;
  }
}
