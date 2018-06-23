package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtils;
import com.sda.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao implements DaoInterface<Employee> {

    private Session currentSesion;
    private Transaction currentTransaction;

    public Session openCurrentSesion() {
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
    public void save(Employee entity) {
        currentSesion.save(entity);
    }

    @Override
    public void update(Employee entity) {
        currentSesion.update(entity);
    }

    @Override
    public Employee findById(int id) {
        Employee employee = getCurrentSesion().get(Employee.class, id);
        return employee;
    }

    @Override
    public void delete(Employee entity) {
        currentSesion.delete(entity);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = getCurrentSesion().createQuery("FROM " + Employee.class.getName()).list();
        return employees;
    }

    @Override
    public void deleteAll() {
        String sql = "delete from pracownicy";
        getCurrentSesion().createQuery(sql).executeUpdate();
    }
}
