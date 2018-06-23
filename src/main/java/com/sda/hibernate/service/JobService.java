package com.sda.hibernate.service;

import com.sda.hibernate.dao.JobDao;
import com.sda.hibernate.entity.Job;

import java.util.List;

public class JobService {

    private static JobDao jobDao;

    public JobService() {
        jobDao = new JobDao();
    }

    public void save(Job job) {
        jobDao.openCurrentSession();
        jobDao.save(job);
        jobDao.closeCurrentSession();
    }

    public void delete(Job job) {
        jobDao.openCurrentSession();
        jobDao.delete(job);
        jobDao.closeCurrentSession();
    }

    public void update(Job job) {
        jobDao.openCurrentSession();
        jobDao.update(job);
        jobDao.closeCurrentSession();
    }

    public List<Job> findAll() {
        jobDao.openCurrentSession();
        List<Job> jobs = jobDao.findAll();
        jobDao.closeCurrentSession();
        return jobs;
    }
}
