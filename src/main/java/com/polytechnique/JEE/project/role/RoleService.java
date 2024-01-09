package com.polytechnique.JEE.project.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService implements RoleInterface {

  private RoleRepository repository;

  @Override
  public List<Role> getRolles() {
    return repository.findAll();
  }

  public Role findByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public void addRole(Role role) {
    Role newRole = Role.builder()
            .name(role.getName())
            .build();
    repository.save(newRole);
  }

  @Override
  public void deleteRole(String id) {
    repository.deleteById(id);
  }
}
