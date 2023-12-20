package com.polytechnique.JEE.project.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

  @Query("select p from Book p where p.category.name=:category")
  List<Book> findByCategory(@PathVariable String category);

}
