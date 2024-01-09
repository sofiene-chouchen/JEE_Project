package com.polytechnique.JEE.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

  @Query("select u from appUser u where u.roles[0].name=:roleName")
  List<User> findUserByRoles(@PathVariable String roleName);

  @Query(value = "select * from app_user where email= ?1", nativeQuery = true)
  Optional<User> findByEmail(String email);
}