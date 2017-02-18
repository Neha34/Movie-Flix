package movie.flix.repository;

import java.util.List;

import movie.flix.entity.comment;

public interface commentRepository {

    public List<comment> findAll();
	
	public comment findOne(String id);
	
	public comment create(comment comment);
	
	public comment update(comment comment);
	
	public void delete(comment comment);
	
	public List<comment> findAllCommentsByMovieId(String movieId);
	
}
