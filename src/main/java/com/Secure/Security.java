package com.Secure;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

//@Provider
public class Security implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> cookHeader = null;
		System.out.println("--------------------------------------");
		System.out.println(requestContext.getUriInfo().getPath());
		System.out.println("--------------------------------------");
		if(requestContext.getUriInfo().getPath().contains("wel"))
		{
			System.out.println("contains wel in provider");
			return;
		}
		else if(requestContext.getUriInfo().getPath().contains("img")){
			System.out.println("yes contains img");
			return;
		}
		else if (requestContext.getHeaders().get("Cookie") == null) {
			Response response = Response.status(Status.UNAUTHORIZED).entity("Authorized..Please Login").build();
			//requestContext.abortWith(response);
			//System.out.println("nothing in cookie");
			System.out.println("provide : does not ");
			return;
		}
		
		
		/*cookHeader = requestContext.getHeaders().get("Cookie");
		
		if (cookHeader != null && cookHeader.size() > 0) {
			Map<String, Cookie> cookies = requestContext.getCookies();
			if(!cookies.containsKey("Token")){
				Response response = Response.status(Status.UNAUTHORIZED).entity("Authorized..Please Login").build();
				//requestContext.abortWith(response);
				//return;
			}
			else{
			Cookie cookie = cookies.get("Token");
			String tokenValue = cookie.getValue();
			
			// decode token
			Jws<Claims> claims = Jwts.parser()
			  .setSigningKey("vivek".getBytes("UTF-8")).parseClaimsJws(tokenValue);
			String scope = (String) claims.getBody().get("name");
			System.out.println(scope);
			}
			
			
			
			

		}
		return;*/

	}
}
