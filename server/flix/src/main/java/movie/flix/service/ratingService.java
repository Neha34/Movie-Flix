package movie.flix.service;

import java.util.List;

import movie.flix.entity.rating;

public interface ratingService {

	public List<rating> findAll();
	
	public rating findOne(String ratingId);
	
	public rating create(String movieId, double rate);
	
	public rating update(String ratingId, double rate);
	
	public void delete(String id);

	public double findAvgRatings(String movieId);

}
