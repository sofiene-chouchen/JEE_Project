package com.polytechnique.JEE.project.book;

import com.polytechnique.JEE.project.book.dto.BookTdo;
import com.polytechnique.JEE.project.category.Category;
import com.polytechnique.JEE.project.category.CategoryService;
import com.polytechnique.JEE.project.user.User;
import com.polytechnique.JEE.project.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class BookController {

  final BookService bookService;
  final CategoryService categoryService;
  final UserService userService;


  @GetMapping("/")
  public String getAllBook(Model model) {
    List<Book> bookList = bookService.getBooks();
    model.addAttribute("books", bookList);
    return "vue";
  }


  @GetMapping("/category")
  public String getCategory(Model m) {
    List<Category> categoryList = categoryService.getCategory();
    m.addAttribute("category", categoryList);
    return "category";
  }

  @GetMapping("/addBook")
  public String addBook(Model m) {
    m.addAttribute("book", bookService.getBooks());
    m.addAttribute("category", categoryService.getCategory());
    return "addBook";
  }

  @PostMapping("/admin/addBook")
  public String addProduct(@ModelAttribute @Valid BookTdo b, BindingResult bindingResult, Model m) {
    if (bindingResult.hasErrors()) {
      m.addAttribute("book", bookService.getBooks());
      return "addBook";
    }
    bookService.addBook(b);
    return "redirect:/";
  }

  @GetMapping("/addCategory")
  public String addCateogry(Model model) {
    return "addCategory";
  }

  @PostMapping("/admin/addCategory")
  public String addNewCategory(@ModelAttribute @Valid Category C, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {

      return "addCategory";
    }
    categoryService.createCategory(C);
    return "redirect:/category";
  }


  @GetMapping("/user")
  public String user(Model m) {
    List<User> getAllUser = userService.getUsers();
    m.addAttribute("user", getAllUser);
    return "user";
  }

  @PostMapping("/admin/deleteBook/{id}")
  public String deleteBook(@PathVariable String id) {
    bookService.deleteBook(id);
    return "redirect:/";
  }

  @PostMapping("/admin/deleteCategory/{id}")
  public String deleteCategory(@PathVariable String id) {
    categoryService.deleteCategory(id);
    return "redirect:/category";
  }

  @PostMapping("/admin/deleteUser/{id}")
  public String deletUser(@PathVariable String id) {
    userService.deleteUser(id);
    return "redirect:/user";

  }

  @GetMapping("/admin/editBook/{id}")
  public String editBook(@PathVariable String id, Model m) {
    Optional<Book> bookById = bookService.getBookById(id);

    if (bookById.isPresent()) {
      m.addAttribute("b", bookById);
      m.addAttribute("cate" , categoryService.getCategory());
    } else {
      return "errorPage";
    }


    return "addBook";
  }

}
