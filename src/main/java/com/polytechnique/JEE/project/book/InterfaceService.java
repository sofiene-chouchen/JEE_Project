package com.polytechnique.JEE.project.book;

import com.polytechnique.JEE.project.book.dto.BookTdo;

import java.util.List;
import java.util.Optional;

public interface InterfaceService {

  public List<Book> getBooks();

  public Optional<Book> getBookById(String id);

  public void addBook(BookTdo book);

  public void deleteBook(String id);

  public Book updateBook(String id, Book book);

  public List<Book> findByCategory(String category);

}
