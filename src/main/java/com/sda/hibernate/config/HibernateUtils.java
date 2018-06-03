package com.sda.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory SESSION_FACTORY;

    static {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static Session session = SESSION_FACTORY.openSession();

    public static Session getConnection(){
        if(session == null){
            session = (Session) new HibernateUtils();
        }
        return session;
    }

    public static void closeConnection() {
        session.close();
        SESSION_FACTORY.close();
    }
}