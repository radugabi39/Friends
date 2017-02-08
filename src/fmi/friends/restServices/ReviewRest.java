package fmi.friends.restServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import fmi.friends.dao.ReviewDAO;
import fmi.friends.dao.UserDAO;
import fmi.friends.hibernateEntities.Review;
import fmi.friends.models.ReviewRatingModel;
import fmi.friends.models.ReviewSaveModel;
import fmi.friennds.restUtils.ResponseListWrapper;
@Path("/review")
public class ReviewRest {
	private static final long serialVersionUID = 1L;
	private ReviewDAO reviewDAO=new ReviewDAO();
	private UserDAO userDAO=new UserDAO();
	public final Logger logger = Logger.getLogger(ReviewRest.class);
	@GET
	@Path("/getReviewByShowId/{showId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  getReviewByShowId(@PathParam("showId") int showId) {
		ResponseListWrapper<Review> toReturn= new ResponseListWrapper<Review>();
		toReturn.setList( reviewDAO.getReviewByShowId(showId));
		

		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(toReturn).build();

		
	}
	
	@POST
	@Path("/saveReview")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getReviewByShowId(@HeaderParam("Authorization") String token,ReviewSaveModel toSave) {
		Integer userId = userDAO.getUserByToken(token);
		toSave.setUserId(userId);
		reviewDAO.saveReview(toSave);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();

	}
	
	
	@POST
	@Path("/updateRating")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRating(ReviewRatingModel toUpdate) {
		reviewDAO.updateRating(toUpdate);
		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();

	}
}
