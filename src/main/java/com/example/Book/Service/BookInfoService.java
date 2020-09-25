package com.example.Book.Service;

import com.example.Book.Entity.BookEntity;
import com.example.Book.Exception.RecordNotFoundException;

import java.util.List;

public interface BookInfoService {
    public List<BookEntity> getAllBookInfo();
    public BookEntity getBookById(Long id) throws RecordNotFoundException;
    public BookEntity createOrUpdateByBooks(BookEntity entity);
    public BookEntity deleteById(Long id) throws RecordNotFoundException;

}
