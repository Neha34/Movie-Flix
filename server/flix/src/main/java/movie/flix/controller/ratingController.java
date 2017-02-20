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
import movie.flix.entity.rating;
import movie.flix.service.ratingService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping(path="ratings")
public class ratingController {

	@Autowired
	private ratingService service;
	@RequestMapping(method = RequestMethod.GET)
	public List<rating> findAll() {
		return service.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public rating findOne(@PathVariable("id") String ratingId) {
		return service.findOne(ratingId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "{movieId}/rating={rate}")
	public rating create(@PathVariable("movieId") String movieId, @PathVariable("rate") double rate) {
		return service.create(movieId,rate);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{ratingId}/rating={rate}")
	public rating update(@PathVariable("ratingId") String ratingId, @PathVariable("rate") double rate) {
		return service.update(ratingId, rate);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
		
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "{movieId}")
	public double findAvgRatings(@PathVariable("videoId") String movieId){
		int scale = (int) Math.pow(10, 1);
	    return (double) Math.round(service.findAvgRatings(movieId) * scale) / scale;
	    
	}

}
