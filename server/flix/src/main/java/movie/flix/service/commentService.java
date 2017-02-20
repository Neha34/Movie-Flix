package movie.flix.service;

import java.util.List;

import movie.flix.entity.comment;

public interface commentService {
	
	public List<comment> findAll();
	
	public comment findOne(String commentId);
	
	public comment create(String movieId, String comment_str );
	
	public comment update(String commentId, String comment_str);
	
	public void delete(String commentId);
	
	public List<comment> findAllCommentsByMovieId(String movieId);
	
}
