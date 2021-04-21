package com.nagarro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sanchitdwivedi
 */
public class SessionUtil {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
    	sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
