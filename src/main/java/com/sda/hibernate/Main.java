package com.sda.hibernate;


import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;
import com.sda.hibernate.entity.Book;
import com.sda.hibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        Transaction tx = null;

//        List<Book> books = session.createQuery(
//                "FROM " + Book.class.getName()
//        ).list();
//
//        for (Book book1: books){
//            System.out.println(book1.getAuthors());
//            System.out.println(book1.getName());
//        }

        tx = session.beginTransaction();

        Category category = new Category();
        category.setName("Fantastyka");

        Author author = new Author();
        author.setName("Jan");
        author.setLastname("Kowalski");

        Author author1 = new Author();
        author1.setName("Bogusław");
        author1.setLastname("Nowak");

        Book book1 = new Book();
        book1.setName("Wiedzmin");
        book1.setCategory(category);

        Set<Author> authors = new HashSet<>();
        authors.add(author);
        authors.add(author1);

        book1.setAuthors(authors);


        session.save(book1);
        tx.commit();


//        HibernateUtils.closeConnection();
    }
}
