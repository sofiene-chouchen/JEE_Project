package com.polytechnique.JEE.project.user;

import com.polytechnique.JEE.project.role.Role;
import com.polytechnique.JEE.project.role.RoleRepository;
import com.polytechnique.JEE.project.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserIntreface {
  UserRepository repository;
  RoleRepository roleRepository;
//  PasswordEncoder passwordEncoder;

  @Override
  public List<User> getUsers() {
    return repository.findAll();
  }

  @Override
  public void addUser(UserDto user) {
    List<Role> roles = new ArrayList<>();

    for (String i : user.getRoles()) {
      Role testRole = roleRepository.findByName(i);
      if (testRole != null) {
        Role role = testRole;
        roles.add(role);
      }
    }

    User newUser = User.builder()
            .name(user.getName())
            .email(user.getEmail())
            .password(user.getPassword())
            .roles(roles)
            .build();

    repository.save(newUser);


  }

  @Override
  public void deleteUser(String id) {

  }

  @Override
  public void updateUser(String id, User user) {

  }

  @Override
  public List<User> findByRoles(String roleName) {
    return repository.findUserByRoles(roleName);
  }
}
