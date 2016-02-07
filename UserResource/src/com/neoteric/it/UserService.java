package com.neoteric.it;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getWelcomeMessage(){
		//return userDao.getAllUsers();
		return "Hello Users, this is RestFul Web Services";
	}
	
	@GET
	@Path("/Users")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserList(@QueryParam("Id") String userId){
		return userDao.getUser(userId);
		
	}
	
	@GET
	@Path("/AllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList(){
		return userDao.getAllUsers();
		
	}
	
	@PUT
	@Path("/Users")
	@Produces(MediaType.APPLICATION_XML)
	public User updateUser(@QueryParam("Id") String userId){
		return userDao.getUser(userId);
		
	}
	
	
	

}
