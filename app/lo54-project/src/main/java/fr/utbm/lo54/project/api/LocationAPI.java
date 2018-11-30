package fr.utbm.lo54.project.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.lo54.project.model.Location;
import fr.utbm.lo54.project.service.LocationStorerDao;
import fr.utbm.lo54.project.service.SQLDatabaseService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/locations")
public class LocationAPI {
    
   private LocationStorerDao locationStorer = null;
   private ObjectMapper mapper = null;
   
   public LocationAPI() {
       this.locationStorer = new SQLDatabaseService();
       this.mapper = new ObjectMapper();
   }

  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllLocations() {
      List<Location> locations = locationStorer.getRecordsLocation();
       try {
           String res = mapper.writeValueAsString(locations);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(LocationAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
  
  /*@GET
  @Path("/get/{locationId}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSpecificLocation(@PathParam( "locationId" ) String userCode, @Context UriInfo uriInfo) {
        //Location loc = locationStorer.
        return userCode;
  }*/

}