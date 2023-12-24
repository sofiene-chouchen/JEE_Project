package com.polytechnique.JEE.project.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class BookController {

  final BookService bookService;


  @GetMapping("/")
  public String getAllBook(Model model) {
    List<Book> bookList = bookService.getBooks();
    model.addAttribute("books", bookList);

    return "vue";
  }
}
