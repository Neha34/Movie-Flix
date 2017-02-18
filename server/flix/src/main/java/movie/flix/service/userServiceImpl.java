package movie.flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import movie.flix.entity.user;
import movie.flix.exception.badRequestException;
import movie.flix.exception.userNotFoundException;
import movie.flix.repository.userRepository;

@Service
public class userServiceImpl implements userService {
	
	@Autowired
    private userRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<user> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public user findOne(String id) {
		
		user u = repository.findOne(id);
		if(u == null){
			throw new userNotFoundException("User not found");
		}
		return u;
	}

	@Override
	@Transactional
	public user create(user user) {
		user existing = repository.findByEmail(user.getEmailId());
		if(existing != null){
			throw new badRequestException("User with this emailid already exists.");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public user update(String id, user user) {
		user existing = repository.findOne(id);
		if(existing == null){
			throw new userNotFoundException("User not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		user u = repository.findOne(id);
		if(u == null){
			throw new userNotFoundException("User not found");
		}
		repository.delete(u);
	}

    @Override
	@Transactional(readOnly = true)
    public Boolean authUser(String userName, String password) {
        user user = repository.authUser(userName, password);
        boolean exists=true;
        if (user == null) {
            exists = false;
        }
        return exists;
    }

	/*@Validated
    public Boolean validateUser(user user) {

        String userEmail_Pattern = " ^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String userPassword_Pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

        if (!user.getEmailId().matches(userEmail_Pattern)) {
            return false;
        } else if (user.getUserName().isEmpty()) {
            return false;
        } else if (!user.getPassword().matches(userPassword_Pattern)) {
            return false;
        } else if (user.getPassword().length() < 8 || user.getPassword().length() > 20) {
            return false;
        }
        return true;
    }*/

}
