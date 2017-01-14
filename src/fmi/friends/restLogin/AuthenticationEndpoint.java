package fmi.friends.restLogin;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fmi.friends.dao.UserDAO;
import fmi.friends.hibernateEntities.User;

@Path("/authentication")
public class AuthenticationEndpoint {
	UserDAO userDAO=new UserDAO();
	
	@PUT
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticationUser(Credentials credentials) {

		try {
			String username = credentials.getUsername();
			String password = credentials.getPassword();
			
			User currentUser=userDAO.checkUser(username, password);
            String token = generateToken(currentUser.getId());
            
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }     
	}
	
	
	
	private String generateToken(Integer userid) throws Exception {
		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		userDAO.saveToken(userid, token);
		return token;
	}
}
