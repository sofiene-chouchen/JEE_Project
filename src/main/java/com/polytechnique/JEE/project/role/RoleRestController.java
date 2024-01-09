package com.polytechnique.JEE.project.role;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/role")
public class RoleRestController {
  private RoleService service;

  @GetMapping("")
  public List<Role> getRoles() {
    return service.getRolles();
  }

  @PostMapping("")
  public void addRole(@RequestBody Role role) {
    service.addRole(role);
  }

  @DeleteMapping("/{id}")
  public void deleteRole(@PathVariable String id) {
    service.deleteRole(id);
  }

  @GetMapping("/{name}")
  public Role findByName(@PathVariable String name) {
    return service.findByName(name);
  }
}
