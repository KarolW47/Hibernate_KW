package com.sda.hibernate.service;

import com.sda.hibernate.dao.FirmDao;
import com.sda.hibernate.entity.Firm;

import java.util.List;

public class FirmService {

    private static FirmDao firmDao;

    public FirmService() {
        firmDao = new FirmDao();
    }

    public void save(Firm firm) {
        firmDao.openCurrentSession();
        firmDao.save(firm);
        firmDao.closeCurrentSesion();
    }

    public void delete(Firm firm) {
        firmDao.openCurrentSession();
        firmDao.delete(firm);
        firmDao.closeCurrentSesion();
    }

    public void update(Firm firm) {
        firmDao.openCurrentSession();
        firmDao.update(firm);
        firmDao.closeCurrentSesion();
    }

    public List<Firm> findAll() {
        firmDao.openCurrentSession();
        List<Firm> firms = firmDao.findAll();
        firmDao.closeCurrentSesion();
        return firms;
    }
}
