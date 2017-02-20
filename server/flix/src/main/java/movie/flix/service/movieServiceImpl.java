package movie.flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movie.flix.entity.movie;
import movie.flix.exception.movieAlreadyExistsException;
import movie.flix.exception.movieNotFoundException;
import movie.flix.repository.movieRepository;

@Service
public class movieServiceImpl implements movieService {

	@Autowired
	private movieRepository repository;
	@Override
	@Transactional(readOnly=true)
	public List<movie> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public movie create(movie movie) {
		movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null){
			throw new movieAlreadyExistsException("Movie with the id doesnot exist");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public movie update(String title, movie movie) {
		movie existing = repository.findById(title);
		if(existing == null){
			throw new movieNotFoundException("Movie with the title doesnot exist");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String title) {

		movie existing = repository.findByTitle(title);
		if(existing == null){
			throw new movieNotFoundException("Movie with the title doesnot exist");
		}
		repository.delete(existing);
	}

	@Override
	@Transactional(readOnly = true)
	public movie findById(String id) {
		
		movie existing = repository.findById(id);
		if(existing == null){
			throw new movieNotFoundException("Movie with the id doesnot exist");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly = true)
	public movie findByTitle(String name) {
		movie existing = repository.findByTitle(name);
		
		if(existing == null){
			throw new movieNotFoundException("Movie with the name doesnot exist");
		}
		return existing;
	}

	@Override
	public List<movie> findTopRatedVideos(String type) {
		return repository.findTopRatedVideos(type);
	}

	@Override
	public List<movie> findMoviesByDirector(String direc) {
		return repository.findMoviesByDirector(direc);
	}
	
	@Override
	public List<movie> findByFilter(String type, int year, String genre, String sort) {
		return repository.findByFilter(type, year, genre, sort);
	}

	@Override
	public String getImdbID(String title) {
		movie existing = repository.findByTitle(title);
		if(existing == null){
			throw new movieNotFoundException("movie not found");
		}
				return repository.getImdbID(title);
	}


	}
