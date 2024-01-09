package com.polytechnique.JEE.project.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements CatergoryInterfaceService {
  private CategoryRepository repository;

  @Override
  public List<Category> getCategory() {
    return repository.findAll();
  }

  @Override
  public Category getCategoryById(String id) {
    return repository.findById(id).orElseThrow();
  }

  @Override
  public void createCategory(Category category) {
    Category newCategory = Category.builder().name(category.getName()).build();
    repository.save(newCategory);

  }

  @Override
  public void deleteCategory(String id) {
    repository.deleteById(id);
  }
}
