package com.polytechnique.JEE.project;

import com.polytechnique.JEE.project.user.User;
import com.polytechnique.JEE.project.user.UserService;
import com.polytechnique.JEE.project.user.dto.UserDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JeeProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(JeeProjectApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(UserService userService){
    return args -> {
      List<String> roles= new ArrayList<>();
      roles.add("ADMIN");
      roles.add("USER");
      userService.addUser(new UserDto("admin" , "admin@gmail.com" , "123" , roles));
    };

  }


}
