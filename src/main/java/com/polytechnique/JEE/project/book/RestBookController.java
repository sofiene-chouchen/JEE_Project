package com.polytechnique.JEE.project.book;


import com.polytechnique.JEE.project.book.dto.BookTdo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class RestBookController {

  private BookService service;

  @PostMapping("")
  public void addBook(@RequestBody BookTdo book) {
    service.addBook(book);
  }

  @GetMapping("")
  public List<Book> getBook() {
    return service.getBooks();
  }

  @GetMapping("/{category}")
  public List<Book> findByCategory(@PathVariable String category) {
    return service.findByCategory(category);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable String id) {
    service.deleteBook(id);
  }

  @PatchMapping("/{id}")
  public Book updateBook(@PathVariable String id, Book book) {
    return service.updateBook(id, book);
  }
}
