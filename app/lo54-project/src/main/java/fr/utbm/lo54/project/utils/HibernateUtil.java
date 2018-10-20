/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.utils;

import fr.utbm.lo54.project.model.Client;
import fr.utbm.lo54.project.model.Course;
import fr.utbm.lo54.project.model.CourseSession;
import fr.utbm.lo54.project.model.Location;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Valentin Bourdier
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            
            configuration.addAnnotatedClass(Location.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(CourseSession.class);
           
            sessionFactory = configuration.buildSessionFactory(); 
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
