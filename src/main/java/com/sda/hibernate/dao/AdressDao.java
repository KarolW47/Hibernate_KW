package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Adress;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdressDao implements DaoInterface<Adress> {

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
    public void save(Adress entity) {
        currentSession.save(entity);
    }

    @Override
    public void update(Adress entity) {
        currentSession.update(entity);
    }

    @Override
    public Adress findById(int id) {
        Adress adress = getCurrentSession().get(Adress.class, id);
        return adress;
    }

    @Override
    public void delete(Adress entity) {
        currentSession.delete(entity);
    }

    @Override
    public List<Adress> findAll() {
        List<Adress> adresses = getCurrentSession().createQuery("FROM " + Adress.class.getName()).list();
        return adresses;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from adresy";
        getCurrentSession().createQuery(sql).executeUpdate();
    }
}
