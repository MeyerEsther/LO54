package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.CourseSession;
import java.util.Date;
import java.util.List;



public interface CourseSessionStorerDao {
    
    public List<CourseSession> getCourseSessionsAvailables();
    public List<CourseSession> filterCourseSessionsAvailables(String filter);
    public List<CourseSession> filterDateSourceSessions(String date);
    public List<CourseSession> filterLocationSourceSessions(Integer locationId);
    public CourseSession getCourseSession(Integer id);

}
