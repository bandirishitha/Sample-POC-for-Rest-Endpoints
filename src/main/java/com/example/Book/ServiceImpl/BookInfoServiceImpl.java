package com.example.Book.ServiceImpl;

import com.example.Book.Dao.BookInfoDao;
import com.example.Book.Entity.BookEntity;
import com.example.Book.Exception.RecordNotFoundException;
import com.example.Book.Service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    BookInfoDao bookDao;

    @Override
    public List<BookEntity> getAllBookInfo() {
        List<BookEntity> result= (List<BookEntity>) bookDao.findAll();
        if(result.size()>0){
            return result;
        }
        else{
            return new ArrayList<BookEntity>();
        }

    }

    @Override
    public BookEntity getBookById(Long id) throws RecordNotFoundException {
        Optional<BookEntity> bookDetails= bookDao.findById(id);
        if(bookDetails.isPresent()){
            return bookDetails.get();
        }
        else{
            throw new RecordNotFoundException("No Books are avilable with given ID");
        }

    }

    @Override
    public BookEntity createOrUpdateByBooks(BookEntity entity) {
        entity=bookDao.save(entity);
        return entity;

    }

    @Override
    public BookEntity deleteById(Long id) throws RecordNotFoundException {

        Optional<BookEntity> bookDetails= bookDao.findById(id);
        if(bookDetails.isPresent()){
            bookDao.deleteById(id);
            return bookDetails.get();
        }
        else {
            throw new RecordNotFoundException("No Books are avilable with given ID");
        }
    }
}
