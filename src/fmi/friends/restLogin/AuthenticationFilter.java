package fmi.friends.restLogin;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.util.List;
import fmi.friends.dao.UserDAO;

@Provider
@Priority(Priorities.AUTHENTICATION)

public class AuthenticationFilter implements ContainerRequestFilter {
	UserDAO userDAO = new UserDAO();
	final String urlLogin = "authentication/login";

	public void filter(ContainerRequestContext requestContext) throws IOException {

	       MultivaluedMap<String, String> headers = requestContext.getHeaders();
          

          final List<String> authorization = headers.get("Authorization");
		if (requestContext.getUriInfo().getRequestUri() != null
				&& requestContext.getUriInfo().getRequestUri().getPath().indexOf(urlLogin) == -1) {

			if (authorization == null ) {
				throw new NotAuthorizedException("Authorization header must be provided");
			}

			String token = authorization.get(0);

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
