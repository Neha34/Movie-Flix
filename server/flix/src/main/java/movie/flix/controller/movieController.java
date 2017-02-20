package movie.flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movie.flix.entity.movie;
import movie.flix.service.movieService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping(path = "vedios")
public class movieController {
	
	@Autowired
	private movieService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<movie> findAll() {
		return service.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public movie create(@RequestBody movie movie) {
		return service.create(movie);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{title}")
	public movie update(@PathVariable("title") String title, @RequestBody movie movie) {
		return service.update(title, movie);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{title}")
	public void delete(@PathVariable("title") String title) {
		service.delete(title);
	}
	
	//findby functions
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public movie findById(@PathVariable("id") String id) {
		return service.findById(id);
		
	}
    //find details by title 	
	@RequestMapping(method = RequestMethod.GET, path = "search={title}")
	public movie findByTitle(@PathVariable("title") String title) {
		return service.findByTitle(title);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "movie/findByDirector/{director}")
	public List<movie> findMoviesByDirector(@PathVariable("director") String director) {
		return service.findMoviesByDirector(director);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "type={type}/year={year}/genre={genre}/sort={sort}")
	public List<movie> findByFilter(@PathVariable("type")String type, @PathVariable("year")int year, @PathVariable("genre")String genre, @PathVariable("sort") String sort){
		return service.findByFilter(type, year, genre, sort);
	}

	@RequestMapping(method = RequestMethod.GET, value = "top={type}")
	public List<movie> findTopRatedVideos(@PathVariable("type") String type){
		return service.findTopRatedVideos(type);
	}

	
	//sort functions
	
	
	@RequestMapping(method = RequestMethod.GET, value = "getimdb/{title}")
	public String getImdbID(@PathVariable("title") String title){
		return service.getImdbID(title);
	}

	
}
