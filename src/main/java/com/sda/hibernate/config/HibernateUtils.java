package com.sda.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private final static SessionFactory sf =
            new Configuration()
                    .configure()
                    .buildSessionFactory();

    private static Session session = sf.openSession();

    public static Session getSession(){
        if(session == null){
            session = (Session) new HibernateUtils();
        }
        return session;
    }

    public static void closeConnection(){
        session.close();
        sf.close();
    }
}