package movie.flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movie.flix.entity.user;

@Repository
public class userRepositoryImpl implements userRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<user> findAll() {
		TypedQuery<user> query=em.createNamedQuery("user.findAll",user.class);
		 return query.getResultList();

	}

	@Override
	public user findOne(String id) {
		return em.find(user.class,id);
	}

	@Override
	public user create(user user) {
		 em.persist(user);
		 return user;

	}

	@Override
	public user update(user user) {
		return em.merge(user);
	}

	@Override
	public void delete(user user) {
		em.remove(user);

	}

	@Override
	public user findByEmail(String email) {
		TypedQuery<user> query=em.createNamedQuery("user.findByEmail",user.class);
		query.setParameter("pEmail", email);
		List<user> users=query.getResultList();
		if(users!=null && users.size()==1){
			return users.get(0);
		}
		else{
		return null;
		}
	}
	
    @Override
    public user authUser(String userName, String password) {
        TypedQuery<user> query = em.createNamedQuery("user.authUser", user.class);
        query.setParameter("puserName", userName);
        query.setParameter("ppassword", password);
        
        List<user> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}else{
			return null;
		}
    }


}
