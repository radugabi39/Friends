package fmi.friends.restServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import fmi.friends.dao.ShowsDAO;
import fmi.friends.dao.UserDAO;
import fmi.friends.hibernateEntities.Shows;
import fmi.friennds.restUtils.ResponseListWrapper;

@Path("/user")
public class UserRest {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO=new UserDAO();
	public final Logger logger = Logger.getLogger(ShowsRest.class);
	
	@GET
	@Path("/getPointsByUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllShows(@PathParam("userId") int userId) {
		Integer toReturn=userDAO.getPointsByUser(userId);

		
	
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(toReturn).build();
	}

}
