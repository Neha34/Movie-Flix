package movie.flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movie.flix.entity.comment;
import movie.flix.entity.movie;
import movie.flix.exception.commentNotFoundException;
import movie.flix.repository.commentRepository;

@Service
public class commentServiceImpl implements commentService {
	
	@Autowired
	private commentRepository repository;
	
	@Autowired
	private movieService movieService;

	
	@Override
	@Transactional(readOnly=true)
	public List<comment> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public comment findOne(String id) {
		
		comment existing = repository.findOne(id);
		if(existing == null){
			throw new commentNotFoundException("Comment is not found.");
		}
		return existing;
	}

	@Override
	@Transactional
	public comment create(String movieId, String comment_str) {
		movie movie = movieService.findById(movieId);
		comment comment = new comment();
		comment.setMovie(movie);
		comment.setComment(comment_str);
		return repository.create(comment);
	}

	@Override
	@Transactional
	public comment update(String commentId, String comment_str) {
		comment existing = repository.findOne(commentId);
		if(existing == null){
			throw new commentNotFoundException("Comment not found");
		}
		existing.setComment(comment_str);		
		  return repository.update(existing);
	}

	@Override
	@Transactional
	public void delete(String id) {

		comment existing = repository.findOne(id);
		if(existing == null){
			throw new commentNotFoundException("Comment not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<comment> findAllCommentsByMovieId(String id) {
		if(repository.findAllCommentsByMovieId(id)== null){
			throw new commentNotFoundException("comments not found");
		}
		return repository.findAllCommentsByMovieId(id);
	}

}
