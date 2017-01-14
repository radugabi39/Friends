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

import fmi.friends.dao.UserDAO;
import fmi.friends.restLogin.Secured;

@Provider
@Priority(Priorities.AUTHENTICATION)
// @Secured
public class AuthenticationFilter implements ContainerRequestFilter {
	UserDAO userDAO = new UserDAO();
	final String urlLogin = "authentication/login";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		// if(requestContext.get)
		if (requestContext.getUriInfo().getRequestUri() != null
				&& requestContext.getUriInfo().getRequestUri().getPath().indexOf(urlLogin) == -1) {
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
				throw new NotAuthorizedException("Authorization header must be provided");
			}

			String token = authorizationHeader.substring("Bearer".length()).trim();

			try {
				validateToken(token);
			} catch (Exception e) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		}

	}

	private void validateToken(String token) throws Exception {
		boolean response = userDAO.checkToken(token);
		if (response == false) {
			throw new Exception();
		}

	}
}
