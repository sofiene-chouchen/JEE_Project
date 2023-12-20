package com.polytechnique.JEE.project.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
  Category findByName(String categoryName);
}
