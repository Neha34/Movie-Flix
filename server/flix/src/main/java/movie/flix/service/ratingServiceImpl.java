package movie.flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movie.flix.entity.movie;
import movie.flix.entity.rating;
import movie.flix.exception.ratingNotFoundException;
import movie.flix.repository.ratingRepository;

@Service
public class ratingServiceImpl implements ratingService {

	@Autowired
	private ratingRepository repository;
	
	@Autowired
	private movieService movieService;

	
	@Override
	@Transactional(readOnly=true)
	public List<rating> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public rating findOne(String id) {
		rating existing = repository.findOne(id);
		if(existing == null){
			throw new ratingNotFoundException("Rating not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public rating create(String movieId, double rate) {
		movie movie = movieService.findById(movieId);
		rating rating = new rating();
		rating.setMovie(movie);
		rating.setUserRating(rate);
    	return repository.create(rating);
	}

	@Override
	@Transactional
	public rating update(String ratingId, double rate) {
		rating rating = repository.findOne(ratingId);
		if (rating == null) {
		   	throw new ratingNotFoundException("Rating not found");
		}
		rating.setUserRating(rate);
		return repository.update(rating);
	}


	@Override
	@Transactional
	public void delete(String id) {

		rating existing = repository.findOne(id);
		if(existing == null){
			throw new ratingNotFoundException("Rating not found");
		}
		repository.delete(existing);
	}

	/*@Override
	public List<rating> allRatingByMovie(String id) {
		
		List<rating> existing = repository.allRatingByMovie(id);
		if(existing.size()==0){
			throw new ratingNotFoundException("Rating not found");
		}
		return repository.allRatingByMovie(id);
	}*/

	@Override
	public double findAvgRatings(String movieId) {
		return repository.findAvgRatings(movieId);
	}


}
