package movie.flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import movie.flix.entity.user;
import movie.flix.service.userService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping(path = "users")
public class userController {
	
	@Autowired
	private userService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<user> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{userId}")
	public user findOne(@PathVariable("userId")String userId) {
		return service.findOne(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public user create(@RequestBody user user) {
		return service.create(user);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{userId}")
	public user update(@PathVariable("userId")String userId, @RequestBody user user) {
		return service.update(userId, user);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{userId}")
	public void delete(@PathVariable("userId")String userId) {
		service.delete(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET,path={"{username}/{password}"})
	public Boolean authUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		
    	return service.authUser(username, password);
	}

	
}
