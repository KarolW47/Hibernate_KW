package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDao implements DaoInterface<Author> {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtils.getSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    @Override
    public void save(Author entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Author entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Author findById(int id) {
        Author author = getCurrentSession().get(Author.class, id);
        return author;
    }

    @Override
    public void delete(Author entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = getCurrentSession().createQuery("FROM " + Author.class.getName()).list();
        return authors;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from author";
        getCurrentSession().createQuery(sql).executeUpdate();
    }
}
