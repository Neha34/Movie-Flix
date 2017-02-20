package movie.flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movie.flix.entity.movie;

@Repository
public class movieRepositoryImpl implements movieRepository {

	@PersistenceContext
    private EntityManager em;
	@Override
	public List<movie> findAll() {
		TypedQuery<movie> query = em.createNamedQuery("movie.findAll", movie.class);
        return query.getResultList();
	}

	@Override
	public movie create(movie movie) {
        em.persist(movie);
        return movie;

	}

	@Override
	public movie update(movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(movie movie) {

        em.remove(movie);

	}

	@Override
	public movie findById(String id) {
		return em.find(movie.class, id);
	}

	@Override
	public movie findByTitle(String name) {
		TypedQuery<movie> query=em.createNamedQuery("movie.findByTitle",movie.class);
		query.setParameter("ptitle", name);
		List<movie> movies=query.getResultList();
		if(movies.size()==1)
		{
			return movies.get(0);
		}
		else{
		return null;}
	}

	
	@Override
	public List<movie> findMoviesByDirector(String direc) {
		TypedQuery<movie> query = em.createNamedQuery("movie.findByDirector", movie.class);
        query.setParameter("pdirector", direc);
        return query.getResultList();
	}

	@Override
	public List<movie> findTopRatedVideos(String type) {
		TypedQuery<movie> query = em.createNamedQuery("movie.findTopRated",movie.class);
		query.setParameter("ptype", type);
		query.setMaxResults(15);
		return query.getResultList();
	}
	
	@Override
	public String getImdbID(String title) {
		TypedQuery<movie> query = em.createNamedQuery("movie.findByTitle",movie.class);
		query.setParameter("ptitle", title);
		List<movie> movie = query.getResultList();
		if(movie.size() == 1) {
			return movie.get(0).getImdbId();		  
		}
		else{
			return null;
		}
	}

	
	@Override
	public List<movie> findByFilter(String type, int year, String genre, String sort) {
		TypedQuery<movie> query =null;
	
		if(type.equals("null") && year == 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findAllSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findAllSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findAllSortByYear",movie.class);
		}
		else if(type.equals("null") && year == 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByGenreSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByGenreSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByGenreSortByYear",movie.class);
			
			query.setParameter("pgenre", "%"+genre+"%");
		}
		else if(type.equals("null") && year != 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByYearSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByYearSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByYear",movie.class);
			
			query.setParameter("pyear", year);
		}
		else if(type.equals("null") && year != 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByYearGenreSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByYearGenreSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByYearGenre",movie.class);
		
			query.setParameter("pyear", year);
			query.setParameter("pgenre","%"+genre+"%");
		}
		else if(!type.equals("null") && year == 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByTypeSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByTypeSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByTypeSortByYear",movie.class);
		
			query.setParameter("ptype", "%"+type+"%");
		}
		else if(!type.equals("null") && year == 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByTypeGenreSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByTypeGenreSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByTypeGenreSortByYear",movie.class);
			
			query.setParameter("ptype", "%"+type+"%");
			query.setParameter("pgenre","%"+genre+"%");
		}
		else if(!type.equals("null") && year != 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByTypeYearSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByTypeYearSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByTypeYear",movie.class);
		
			query.setParameter("ptype", "%"+type+"%");
			query.setParameter("pyear", year);
		}
		else if(!type.equals("null") && year != 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("movie.findByTypeYearGenreSortByRating",movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("movie.findByTypeYearGenreSortByVotes",movie.class);
			else
				 query = em.createNamedQuery("movie.findByTypeYearGenre",movie.class);
		
			query.setParameter("ptype", "%"+type+"%");
			query.setParameter("pyear", year);
			query.setParameter("pgenre","%"+genre+"%");
		}
		return query.getResultList();
	}

}
