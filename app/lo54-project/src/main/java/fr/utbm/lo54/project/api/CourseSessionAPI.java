/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.lo54.project.model.Course;
import fr.utbm.lo54.project.model.CourseSession;
import fr.utbm.lo54.project.service.CourseSessionDao;
import fr.utbm.lo54.project.service.CourseStorerDao;
import fr.utbm.lo54.project.service.SQLDatabaseService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Valentin Bourdier
 */

@Path("/sessions")
public class CourseSessionAPI {
    
   private CourseSessionDao courseSessionStorer = null;
   private ObjectMapper mapper = null;
   
   public CourseSessionAPI() {
       this.courseSessionStorer = new SQLDatabaseService();
       this.mapper = new ObjectMapper();
   }
   
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllCourseSessions() {
      List<CourseSession> courseSessions = courseSessionStorer.getCourseSessionsAvailables();
       try {
           String res = mapper.writeValueAsString(courseSessions);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(LocationAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
    
}
