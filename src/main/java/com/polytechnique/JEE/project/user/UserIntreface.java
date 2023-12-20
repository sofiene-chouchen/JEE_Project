package com.polytechnique.JEE.project.user;

import com.polytechnique.JEE.project.user.dto.UserDto;

import java.util.List;

public interface UserIntreface {

  public List<User> getUsers();

  public void addUser(UserDto user);

  public void deleteUser(String id);

  public void updateUser(String id, User user);

  public List<User> findByRoles(String roleName);

}
