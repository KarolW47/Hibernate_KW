package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Job;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JobDao implements DaoInterface<Job> {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtils.getSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    @Override
    public void save(Job entity) {
        currentSession.save(entity);
    }

    @Override
    public void update(Job entity) {
        currentSession.update(entity);
    }

    @Override
    public Job findById(int id) {
        Job job = getCurrentSession().get(Job.class, id);
        return job;
    }

    @Override
    public void delete(Job entity) {
        currentSession.delete(entity);
    }

    @Override
    public List<Job> findAll() {
        List<Job> jobs = getCurrentSession().createQuery("FROM " + Job.class.getName()).list();
        return jobs;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from stanowiska";
        getCurrentSession().createQuery(sql).executeUpdate();
    }
}
