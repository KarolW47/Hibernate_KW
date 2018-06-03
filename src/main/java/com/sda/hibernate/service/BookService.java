package com.sda.hibernate.service;

import com.sda.hibernate.dao.BookDao;
import com.sda.hibernate.entity.Book;

public class BookService {

    private static BookDao bookDao;

    public BookService(){
        bookDao = new BookDao();
    }

    public void save(Book book){
        bookDao.openCurrentSession();
        bookDao.save(book);
        bookDao.closeCurrentSession();
    }
}
