package com.polytechnique.JEE.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

  @Query("select u from appUser u where u.roles[0].name=:roleName")
  List<User> findUserByRoles(@PathVariable String roleName);
}
