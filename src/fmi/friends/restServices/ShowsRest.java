package fmi.friends.restServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import fmi.friends.dao.ShowsDAO;
import fmi.friends.hibernateEntities.Shows;
import fmi.friennds.restUtils.ResponseListWrapper;


@Path("/shows")
public class ShowsRest {
	private static final long serialVersionUID = 1L;
	private ShowsDAO showDAO=new ShowsDAO();
	public final Logger logger = Logger.getLogger(ShowsRest.class);
	
	@GET
	@Path("/getAllShows")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllShows() {
		ResponseListWrapper<Shows> toReturn= new ResponseListWrapper<Shows>();
		toReturn.setList(showDAO.getAllShows());
		
	
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(toReturn).build();
	}
	
	@GET
	@Path("/getShowById/{showId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getShowById(@PathParam("showId") int showId) {
		
		Shows toReturn= showDAO.getShow(showId);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(toReturn).build();
	}
}
