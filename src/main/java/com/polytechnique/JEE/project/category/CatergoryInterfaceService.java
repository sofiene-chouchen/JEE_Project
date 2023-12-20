package com.polytechnique.JEE.project.category;

import java.util.List;

public interface CatergoryInterfaceService {

  public List<Category> getCategory();

  public Category getCategoryById(String id);

  public void createCategory(Category category);

  public void deleteCategory(String id);


}
