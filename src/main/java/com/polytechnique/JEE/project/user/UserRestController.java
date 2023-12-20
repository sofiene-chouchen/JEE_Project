package com.polytechnique.JEE.project.user;


import com.polytechnique.JEE.project.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserRestController {
  private UserService service;


  @GetMapping("")
  public List<User> getUser() {
    return service.getUsers();
  }

  @PostMapping("/addUser")
  public void addUser(@RequestBody UserDto user) {
    service.addUser(user);
  }

  @GetMapping("/{roleName}")
  public List<User> getUserByRoles(@PathVariable String roleName) {
    return service.findByRoles(roleName);
  }

}
