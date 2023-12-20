package com.polytechnique.JEE.project.category;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polytechnique.JEE.project.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Book> books;


}
