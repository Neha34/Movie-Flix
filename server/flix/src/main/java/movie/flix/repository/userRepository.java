package movie.flix.repository;

import java.util.List;

import movie.flix.entity.user;

public interface userRepository {

    public List<user> findAll();
    
    public user authUser(String userName, String password);
    
    public user findByEmail(String email);
	
	public user findOne(String id);
	
	public user create(user user);
	
	public user update(user user);
	
	public void delete(user user);
	
}
