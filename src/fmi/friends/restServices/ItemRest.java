package fmi.friends.restServices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import fmi.friends.dao.ItemDAO;
import fmi.friends.dao.UserDAO;
import fmi.friends.hibernateEntities.Review;
import fmi.friends.models.ItemModel;
import fmi.friennds.restUtils.ResponseListWrapper;

@Path("/item")
public class ItemRest {

	private ItemDAO itemDAO=new ItemDAO();
	private UserDAO userDAO=new UserDAO();
	public final Logger logger = Logger.getLogger(ItemRest.class);
	
	@GET
	@Path("/getItems")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getItems() {
		ResponseListWrapper<ItemModel> toReturn= new ResponseListWrapper<ItemModel>();
		toReturn.setList(itemDAO.getItems());
		
	
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(toReturn).build();
	}
	
	@POST
	@Path("/buyItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  buyItem(@HeaderParam("Authorization") String token,Integer itemID) {
		
		Integer userId=userDAO.getUserByToken(token);

		Boolean resp=itemDAO.buyItem(userId,itemID);
		
		if(resp.equals(Boolean.TRUE)){
			return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
		}else{
			return Response.status(409).header("Access-Control-Allow-Origin", "*").build();
		}

		
	}
}
