package com.sda.hibernate.service;

import com.sda.hibernate.dao.AdressDao;
import com.sda.hibernate.entity.Adress;

import java.util.List;

public class AdressService {

    private static AdressDao adressDao;

    public AdressService() {
        adressDao = new AdressDao();
    }

    public void save(Adress adress) {
        adressDao.openCurrentSession();
        adressDao.save(adress);
        adressDao.closeCurrentSession();
    }

    public void delete(Adress adress) {
        adressDao.openCurrentSession();
        adressDao.delete(adress);
        adressDao.closeCurrentSession();
    }

    public void update(Adress adress){
        adressDao.openCurrentSession();
        adressDao.update(adress);
        adressDao.closeCurrentSession();
    }

    public List<Adress> showAll(){
        adressDao.openCurrentSession();
        List<Adress> adresses = adressDao.findAll();
        adressDao.closeCurrentSession();
        return adresses;
    }
}
