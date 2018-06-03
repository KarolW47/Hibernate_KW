package com.sda.hibernate;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtils.getConnection();
        Transaction tx = null;

        tx = session.beginTransaction();
        Book book = new Book();
        book.setAuthor("Maciek");
        book.setName("leci w kosmos");
        session.save(book);

        tx.commit();

        tx = session.beginTransaction();
        List<Book> books = session.createQuery("FROM " + Book.class.getName()).list();

        for (Book book1 : books) {
            System.out.println("Book author: " + book1.getAuthor());
            System.out.println("Book name: " + book1.getName());
            System.out.println(" ");
        }
        tx.commit();

        HibernateUtils.closeConnection();

    }
}
