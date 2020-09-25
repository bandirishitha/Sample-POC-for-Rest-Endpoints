package com.example.Book.Dao;

import com.example.Book.Entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInfoDao extends CrudRepository<BookEntity,Long> {

}
