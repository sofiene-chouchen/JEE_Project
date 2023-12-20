package com.polytechnique.JEE.project.book;


import com.polytechnique.JEE.project.book.dto.BookTdo;
import com.polytechnique.JEE.project.category.Category;
import com.polytechnique.JEE.project.category.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService implements InterfaceService {
  BookRepository bookRepository;
  CategoryRepository categoryRepository;

  @Override
  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Optional<Book> getBookById(String id) {
    return bookRepository.findById(id);
  }

  @Override
  public void addBook(BookTdo book) {
    Category category = categoryRepository.findByName(book.getCategoryName());

    Book newBook = Book.builder()
            .name(book.getName())
            .language(book.getLanguage())
            .date(book.getDate())
            .category(category)
            .build();
    bookRepository.save(newBook);
  }

  @Override
  public void deleteBook(String id) {
    bookRepository.deleteById(id);

  }

  @Override
  public Book updateBook(String id, Book book) {
    return null;
  }

  @Override
  public List<Book> findByCategory(String category) {
    return bookRepository.findByCategory(category);
  }
}
