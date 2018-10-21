/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.Location;
import fr.utbm.lo54.project.utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Valentin Bourdier
 */
public class SQLDatabaseService implements LocationStorerDao {
    
    private final static Logger logger = Logger.getLogger(SQLDatabaseService.class);

    @Override
    public Integer createRecordLocation(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tran = session.beginTransaction();
        session.save(location);
        
        tran.commit();
        
        session.close();
        logger.info("Successfully created Location: " + location);
        
        return location.getId();
    }

    @Override
    public void updateRecordLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRecordLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getRecordsLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
