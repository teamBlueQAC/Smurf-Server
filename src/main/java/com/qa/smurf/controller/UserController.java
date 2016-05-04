package com.qa.smurf.controller;

import com.qa.smurf.model.UserModel;
import com.qa.smurf.model.repository.UserModelRepository;
import com.qa.smurf.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/users")
@RequestScoped
public class UserController {
    
    @Inject
    private UserModelRepository userModelRepository;
    
    @Inject
    private UserService userService;
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel lookupUserById(@PathParam("id") long id) {
    	UserModel member = userModelRepository.findById(id);
        if (member == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return member;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(UserModel user) {
    	Response.ResponseBuilder builder = null;
    	
    	if(userModelRepository.findByEmail(user.getEmail()) != null) {
            builder = Response.status(Response.Status.BAD_REQUEST).entity(errorResponse("Email already registered"));
            return builder.build();
    	}
    	
    	try {
			userService.add(user);
			builder = Response.ok();
		} catch (Exception e) {
            builder = Response.status(Response.Status.BAD_REQUEST).entity(errorResponse(e.getMessage()));
		}
    	
		return builder.build();
    }
    
    public Map<String, String> errorResponse(String message) {
    	Map<String, String> response = new HashMap<>(); 
    	response.put("error", message);
    	return response;
    }
    
}
