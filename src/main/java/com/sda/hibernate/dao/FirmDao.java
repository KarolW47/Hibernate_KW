package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Firm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FirmDao implements DaoInterface<Firm>{

    private Session currentSesion;
    private Transaction currentTransaction;

    public Session openCurrentSession(){
        currentSesion = HibernateUtils.getSession();
        currentTransaction = currentSesion.beginTransaction();
        return currentSesion;
    }

    public void closeCurrentSesion(){
        currentTransaction.commit();
        currentSesion.close();
    }

    public Session getCurrentSesion(){
        return currentSesion;
    }

    @Override
    public void save(Firm entity) {
        currentSesion.save(entity);
    }

    @Override
    public void update(Firm entity) {
        currentSesion.update(entity);
    }

    @Override
    public Firm findById(int id) {
        Firm firm = currentSesion.get(Firm.class, id);
        return firm;
    }

    @Override
    public void delete(Firm entity) {
        currentSesion.delete(entity);
    }

    @Override
    public List<Firm> findAll() {
        List<Firm> firms = getCurrentSesion().createQuery("FROM " + Firm.class.getName()).list();
        return firms;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from firmy";
        getCurrentSesion().createQuery(sql).executeUpdate();
    }
}
