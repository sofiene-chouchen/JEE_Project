package com.polytechnique.JEE.project.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
  Role findByName(String roles);
}
