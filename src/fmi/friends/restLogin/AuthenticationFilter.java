package fmi.friends.restLogin;

import java.io.IOException;
import java.lang.annotation.*;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import fmi.friends.restLogin.Secured;

//@Provider
//@Priority(Priorities.AUTHENTICATION)
//@Secured
public class AuthenticationFilter {
//	@Override
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            throw new NotAuthorizedException("Authorization header must be provided");
//        }
//        
//        String token = authorizationHeader.substring("Bearer".length()).trim();
//
//        try {
//            validateToken(token);
//        } catch (Exception e) {
//            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//        }
//    }
	
	private void validateToken(String token) {
		
	}
}
