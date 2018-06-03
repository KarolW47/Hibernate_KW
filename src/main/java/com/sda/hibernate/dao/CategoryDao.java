package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao implements DaoInterface<Category> {

    private Session currentSession;
    private Transaction currentTransaciton;

    public Session openCurrentSession(){
        currentSession = HibernateUtils.getSession();
        currentTransaciton = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentTransaciton.commit();
        currentSession.close();
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    @Override
    public void save(Category entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Category findById(int id) {
        Category category = getCurrentSession().get(Category.class, id);
        return category;
    }

    @Override
    public void delete(Category entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = getCurrentSession().createQuery("From " + Category.class.getName()).list();
        return categories;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from category";
        getCurrentSession().createQuery(sql).executeUpdate();

    }

}
