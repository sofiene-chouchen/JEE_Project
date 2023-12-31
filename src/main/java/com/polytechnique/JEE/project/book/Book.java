package com.polytechnique.JEE.project.book;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.polytechnique.JEE.project.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(unique = true)
  private String name;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date date;

  private String language;

  @ManyToOne
  private Category category;

}
