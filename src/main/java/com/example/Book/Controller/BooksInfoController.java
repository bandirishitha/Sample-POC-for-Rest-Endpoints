package com.example.Book.Controller;


import com.example.Book.Entity.BookEntity;
import com.example.Book.Exception.RecordNotFoundException;
import com.example.Book.Service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BooksInfoController {
    @Autowired
    BookInfoService bookService;
    @RequestMapping("/getBooks")
    public List<BookEntity> getBooksDetails(){
        List<BookEntity >books=bookService.getAllBookInfo();

        return books;
    }
    @PostMapping("/saveBook")
    public ResponseEntity<BookEntity> saveBookDetails(@RequestBody BookEntity entity){

        bookService.createOrUpdateByBooks(entity);
        BookEntity book=bookService.createOrUpdateByBooks(entity);
        return new ResponseEntity<BookEntity>(book, HttpStatus.OK);


    }
    @PutMapping("/updateBook")
    public ResponseEntity<BookEntity> updateookDetails(@RequestBody BookEntity entity){

        bookService.createOrUpdateByBooks(entity);
        BookEntity book=bookService.createOrUpdateByBooks(entity);
        return new ResponseEntity<BookEntity>(book, HttpStatus.OK);


    }
    @RequestMapping("/getBook/{id}")
    public BookEntity getBookbyId(@PathVariable(name="id")  Long id) throws RecordNotFoundException{
       BookEntity bookDetail=  bookService.getBookById(id);
        return bookDetail;
    }
    @DeleteMapping ("/deleteBook/{id}")
    public ResponseEntity<Void> deletBookbyId(@PathVariable(name="id")  Long id) throws RecordNotFoundException{
       BookEntity book=bookService.deleteById(id);
       if(book!=null){
           return ResponseEntity.noContent().build();
       }else{
           return ResponseEntity.notFound().build();
        }

    }
}
