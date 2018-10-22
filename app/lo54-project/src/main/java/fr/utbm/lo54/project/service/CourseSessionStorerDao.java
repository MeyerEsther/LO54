/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.CourseSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentin Bourdier
 */
public interface CourseSessionStorerDao {
    
    public List<CourseSession> getCourseSessionsAvailables();
    public List<CourseSession> filterCourseSessionsAvailables(String filter);
    public List<CourseSession> filterDateSourceSessions(String date);
    public List<CourseSession> filterLocationSourceSessions(Integer locationId);
    public CourseSession getCourseSession(Integer id);

}
