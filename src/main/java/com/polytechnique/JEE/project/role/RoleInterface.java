package com.polytechnique.JEE.project.role;

import java.util.List;

public interface RoleInterface {

  public List<Role> getRolles();

  public void addRole(Role role);

  public void deleteRole(String id);
}
