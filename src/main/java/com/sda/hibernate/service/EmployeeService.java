package com.sda.hibernate.service;

import com.sda.hibernate.dao.EmployeeDao;
import com.sda.hibernate.entity.Employee;

import java.util.List;

public class EmployeeService {

    private static EmployeeDao employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDao();
    }

    public void save(Employee employee) {
        employeeDao.openCurrentSesion();
        employeeDao.save(employee);
        employeeDao.closeCurrentSesion();
    }

    public void delete(Employee employee) {
        employeeDao.openCurrentSesion();
        employeeDao.delete(employee);
        employeeDao.closeCurrentSesion();
    }

    public void update(Employee employee) {
        employeeDao.openCurrentSesion();
        employeeDao.update(employee);
        employeeDao.closeCurrentSesion();
    }

    public List<Employee> findAll(){
        employeeDao.openCurrentSesion();
        List<Employee> employees = employeeDao.findAll();
        employeeDao.closeCurrentSesion();
        return employees;
    }
}
