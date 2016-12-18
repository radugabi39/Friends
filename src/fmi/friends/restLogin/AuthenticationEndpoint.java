package fmi.friends.restLogin;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fmi.friends.hibernateEntities.User;

@Path("/authentication")
public class AuthenticationEndpoint {
	public Response authenticationUser(Credentials credentials) {
		try {
			String username = credentials.getUsername();
			String password = credentials.getPassword();
			
            authenticate(username, password);
            String token = generateToken(username);
            
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }     
	}
	
	private void authenticate(String username, String password) throws Exception {
		Session session = null;
		Query query;
		
		query = session.createQuery(
			"select * from User where userName = :username and password = :password"
		);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		User user = (User) query.getSingleResult();
		if (user == null) {
			 throw new Exception("User does not exists!");
		}
	}
	
	private String generateToken(String username) {
		Date date = new Date();
		String token = username.concat(date.toString()) ;
		
		return token;
	}
}
