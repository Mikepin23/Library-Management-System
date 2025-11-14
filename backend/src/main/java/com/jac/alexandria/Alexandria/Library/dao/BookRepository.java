package com.jac.alexandria.Alexandria.Library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jac.alexandria.Alexandria.Library.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>  {

    // add a method to sort by title
    public List<Book> findAllByOrderByTitleAsc();

}