/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.lo54.project.service.ClientStorerDao;
import fr.utbm.lo54.project.service.CourseSessionStorerDao;
import fr.utbm.lo54.project.service.SQLDatabaseService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Valentin Bourdier
 */
@Path("/clients")
public class ClientAPI {
    
   private ClientStorerDao clientStorer = null;
   private CourseSessionStorerDao courseSessionStorer = null;
   private ObjectMapper mapper = null;
   
   public ClientAPI() {
       SQLDatabaseService db = new SQLDatabaseService();
       this.clientStorer = db;
       this.courseSessionStorer = db;
       this.mapper = new ObjectMapper();
   }
   
  @POST
  @Path("/subscribe/{courseSessionId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String subscribeToACourseSession(@PathParam( "courseSessionId" ) String courseSessionId) {
      
      return "{}";
  }
    
}
