package movie.flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movie.flix.entity.movie;
import movie.flix.entity.rating;
import movie.flix.entity.user;
import movie.flix.repository.ratingRepository;

@Repository
public class ratingRepositoryImpl implements ratingRepository {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<rating> findAll() {
        TypedQuery<rating> query = em.createNamedQuery("rating.findAll", rating.class);
        return query.getResultList();

	}

	@Override
	public rating findOne(String id) {
		return em.find(rating.class, id);
	}

	@Override
	public rating create(rating rating) {
        em.persist(rating);
        return rating;

	}

	@Override
	public rating update(rating rating) {
		return em.merge(rating);
	}

	@Override
	public void delete(rating rating) {
        em.remove(rating);


	}

	/*@Override
	public List<rating> allRatingByMovie(String id) {
		TypedQuery<rating> query=em.createNamedQuery("rating.findAllRatingByMovie",rating.class);
		return query.getResultList();
	}*/

	@Override
	public double findAvgRatings(String movieId) {
		TypedQuery<rating> query = em.createNamedQuery("rating.findAvgRatings", rating.class);
		query.setParameter("cid", movieId);
		List<rating> list = query.getResultList();
		if(list.size() > 0){
			double sum = 0.0;
			for(int i=0;i<list.size();i++)
				sum += list.get(i).getUserRating();
			double average = sum/list.size();
			return average;
		}
		else
			return 0;
	}


}
