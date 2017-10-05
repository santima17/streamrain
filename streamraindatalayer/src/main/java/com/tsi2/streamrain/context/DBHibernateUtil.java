/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsi2.streamrain.context;

/**
 *
 * @author santiago
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author santima17
 */
public class DBHibernateUtil {

    private static final SessionFactory sessionFactoryGenerator;
    private static final SessionFactory sessionFactoryMain;
    
    static {
        try {
        	sessionFactoryGenerator = new Configuration().configure("hibernate_gen.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactoryGenerator creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    static {
        try {
        	sessionFactoryMain = new Configuration().configure("hibernate_main.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactoryGenerator creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactoryGenerator() {
        return sessionFactoryGenerator;
    }
    
    public static SessionFactory getSessionFactoryMain() {
        return sessionFactoryMain;
    }
}
