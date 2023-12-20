package com.polytechnique.JEE.project.book.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookTdo {
  private String name;
  private String language;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date date;
  private String categoryName;


}
