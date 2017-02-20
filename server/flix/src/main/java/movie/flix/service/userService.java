package movie.flix.service;

import java.util.List;

import movie.flix.entity.user;

public interface userService {
	
	public List<user> findAll();
	
	public user findOne(String userId);
	
	public user create(user user);
	
	public user update(String userId, user user);
	
	public void delete(String userId);
	
    public Boolean authUser(String userName, String password);
	

}
