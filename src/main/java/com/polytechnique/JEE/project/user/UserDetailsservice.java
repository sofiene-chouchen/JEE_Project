package com.polytechnique.JEE.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


@Configuration

public class UserDetailsservice implements UserDetailsService {
  @Autowired

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = Optional.ofNullable(userRepository.findByEmail(username).orElse(null));
    return user.map(Userdetails::new).orElseThrow(() -> new UsernameNotFoundException("User Does Not Exist"));
  }
}