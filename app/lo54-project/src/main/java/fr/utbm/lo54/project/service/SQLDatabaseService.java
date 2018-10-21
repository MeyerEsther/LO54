/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.Course;
import fr.utbm.lo54.project.model.CourseSession;
import fr.utbm.lo54.project.model.Location;
import fr.utbm.lo54.project.utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Valentin Bourdier
 */
public class SQLDatabaseService implements LocationStorerDao, CourseStorerDao, CourseSessionDao {
    
    private final static Logger logger = Logger.getLogger(SQLDatabaseService.class);
    
    private SessionFactory sessionFactory = null;
    
    public SQLDatabaseService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Integer createRecordLocation(Location location) {
        Session session = sessionFactory.openSession();
        
        session.save(location);
        
        logger.info("Successfully created Location: " + location);
        
        return location.getId();
    }

    @Override
    public void updateRecordLocation(Location location) {
        Session session = sessionFactory.openSession();
        
        session.update(location);
        
        logger.info("Successfully updated Location: " + location);    
    }

    @Override
    public void deleteRecordLocation(Location location) {
        Session session = sessionFactory.openSession();
        
        session.delete(location);
        
        logger.info("Successfully deleted Location: " + location);        
    }

    @Override
    public List<Location> getRecordsLocation() {
        Session session = sessionFactory.openSession();
        
        List<Location> locations = session.createQuery("from Location").list();
        
        logger.info("Successfully got all locations (n=" + locations.size() + ")");
        
        return locations;
    }

    @Override
    public List<Course> getCoursesAvailables() {
        Session session = sessionFactory.openSession();
        
        List<Course> courses = session.createQuery("from Course").list();
        
        logger.info("Successfully got all courses (n=" + courses.size() + ")");
        
        return courses;    
    }

    @Override
    public List<CourseSession> getCourseSessionsAvailables() {
        Session session = sessionFactory.openSession();
        
        List<CourseSession> courseSessions = session.createQuery("from CourseSession").list();
        
        logger.info("Successfully got all courses sessions (n=" + courseSessions.size() + ")");
        
        return courseSessions;  
    }

    
    
}
