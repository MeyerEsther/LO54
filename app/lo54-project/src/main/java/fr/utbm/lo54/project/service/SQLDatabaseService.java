/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.Client;
import fr.utbm.lo54.project.model.Course;
import fr.utbm.lo54.project.model.CourseSession;
import fr.utbm.lo54.project.model.Location;
import fr.utbm.lo54.project.utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Valentin Bourdier
 */
public class SQLDatabaseService implements LocationStorerDao, CourseStorerDao, CourseSessionStorerDao, ClientStorerDao {
    
    private final static Logger logger = Logger.getLogger(SQLDatabaseService.class);
    
    private SessionFactory sessionFactory = null;
    
    public SQLDatabaseService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
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

    @Override
    public List<CourseSession> filterCourseSessionsAvailables(String filter) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE course.title like :filter";
        Query query = session.createQuery(hql);
        query.setParameter("filter", "%" + filter + "%");
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter by '" + filter + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;  
    }

    @Override
    public List<CourseSession> filterDateSourceSessions(String date) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE start_date = :date";
        Query query = session.createQuery(hql);
        query.setParameter("date", date);
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter for date '" + date + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;      }

    @Override
    public List<CourseSession> filterLocationSourceSessions(Integer locationId) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE location_id = :locationId";
        Query query = session.createQuery(hql);
        query.setParameter("locationId", locationId);
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter for location n°'" + locationId + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;      
    }

    @Override
    public Integer createClient(Client client) {
        Session session = sessionFactory.openSession();
        
        session.save(client);
        
        logger.info("Sucessfully save client '" + client +"' into database");
        
        return client.getId();
    }

    @Override
    public CourseSession getCourseSession(Integer id) {
        Session session = sessionFactory.openSession();
        
        CourseSession courseSession = session.get(CourseSession.class, id);
        
        logger.info("Successfully get from database CourseSession '" + courseSession + "'");
        
        return courseSession;     
    }
   
   
}
