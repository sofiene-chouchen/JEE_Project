package com.polytechnique.JEE.project.user;

import com.polytechnique.JEE.project.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "appUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private String email;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Role> roles;

}
