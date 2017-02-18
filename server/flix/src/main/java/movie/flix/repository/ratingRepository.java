package movie.flix.repository;

import java.util.List;

import movie.flix.entity.rating;

public interface ratingRepository {

    public List<rating> findAll();
	
	public rating findOne(String ratingId);
	
	public rating create(rating rating);
	
	public rating update(rating rating);
	
	public void delete(rating rating);
	
	//public List<rating> allRatingByMovie(String movieId);
	
	public 	double findAvgRatings(String videoId);
;

}
