package movie.flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import movie.flix.entity.comment;
import movie.flix.service.commentService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping(path = "comments")
public class commentController {
	
	@Autowired
	private commentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<comment> findAll() {
		return service.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{commentId}")
	public comment findOne(@PathVariable("commentId") String commentId) {
		return service.findOne(commentId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path="{movieId}/comment={comment_str}")
	public comment create(@PathVariable("movieId") String movieId, @PathVariable("comment_str") String comment_str) {
		return service.create(movieId, comment_str);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{commentId}/comment={comment_str}")
	public comment update(@PathVariable("commentId") String commentId, @PathVariable("comment_str") String comment_str) {
		return service.update(commentId, comment_str);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String commentId) {
		service.delete(commentId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{movieId}")
	public List<comment> findAllCommentsByMovieId(@PathVariable("movieId") String movieId) {
		return service.findAllCommentsByMovieId(movieId);
		
	}
}
