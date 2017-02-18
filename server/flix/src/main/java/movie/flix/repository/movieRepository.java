package movie.flix.repository;

import java.util.List;

import movie.flix.entity.movie;

public interface movieRepository {
	
    public List<movie> findAll();
	
	public movie create(movie movie);
	
	public movie update(movie movie);
	
	public void delete(movie movie);
	
	public movie findById(String id);
	
	public movie findByTitle(String name);
	
	public List<movie> findTopRatedVideos(String type);
	
	public List<movie> findByFilter(String type, int year, String genre, String sort);
	
	public List<movie> findMoviesByDirector(String direc);
	
	
	public String getImdbID(String title);

}
