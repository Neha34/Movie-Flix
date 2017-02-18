package movie.flix.service;

import java.util.List;

import movie.flix.entity.movie;

public interface movieService {

	public List<movie> findAll();
	
	public movie create(movie movie);
	
	public movie update(String title, movie movie);
	
	public void delete(String title);
	
	public movie findById(String movieId);
	
	public movie findByTitle(String name);
	
	public List<movie> findMoviesByDirector(String direc);
	
	public List<movie> findByFilter(String type, int year, String genre, String sort);

	public String getImdbID(String title);

	public List<movie> findTopRatedVideos(String type);
	
}
