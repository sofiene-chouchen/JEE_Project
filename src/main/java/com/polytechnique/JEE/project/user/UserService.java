package com.polytechnique.JEE.project.user;

import com.polytechnique.JEE.project.role.Role;
import com.polytechnique.JEE.project.role.RoleRepository;
import com.polytechnique.JEE.project.role.RoleService;
import com.polytechnique.JEE.project.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserIntreface {
  UserRepository repository;
  RoleRepository roleRepository;
  PasswordEncoder passwordEncoder;
  RoleService roleService;

  @Override
  public List<User> getUsers() {
    return repository.findAll();
  }

  @Override
  public void addUser(UserDto user) {
    List<Role> roles = new ArrayList<>();

    for (String i : user.getRoles()) {
      Role testRole = roleService.roleByName(i);
      if (testRole != null) {
        Role role = testRole;
        roles.add(role);
      }
    }

    User newUser = User.builder()
            .name(user.getName())
            .email(user.getEmail())
            .password(passwordEncoder.encode(user.getPassword()))
            .roles(roles)
            .build();

    repository.save(newUser);
  }

  @Override
  public void deleteUser(String id) {
    repository.deleteById(id);
  }

  @Override
  public void updateUser(String id, User user) {
    // Implement update logic if needed
  }

  @Override
  public List<User> findByRoles(String roleName) {
    return repository.findUserByRoles(roleName);
  }

  @Override
  public Optional<User> loadUserByUsername(String username) {
    return repository.findByEmail(username);
  }
}