package com.jac.alexandria.Alexandria.Library.service;


import com.jac.alexandria.Alexandria.Library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    void save(Book theBook);

    void deleteById(int theId);

}
