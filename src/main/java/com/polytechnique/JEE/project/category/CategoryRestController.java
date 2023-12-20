package com.polytechnique.JEE.project.category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController {

  CategoryService service;

  @PostMapping("")
  public void addCategory(@RequestBody Category category) {
    service.createCategory(category);
  }

  @GetMapping("")

  public List<Category> getAllCategory() {
    return service.getCategory();
  }

  @GetMapping("/{id}")
  public Category getCategoryById(@PathVariable String id) {
    return service.getCategoryById(id);
  }

}
