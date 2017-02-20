package movie.flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movie.flix.entity.comment;
import movie.flix.entity.movie;
import movie.flix.entity.user;

@Repository
public class commentRepositoryImpl implements commentRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<comment> findAll() {
		TypedQuery<comment> query = em.createNamedQuery("comment.findAll", comment.class);
        return query.getResultList();
	}

	@Override
	public comment findOne(String id) {
		return em.find(comment.class, id);
	}

	@Override
	public comment create(comment comment) {
        em.persist(comment);
        return comment;

	}

	@Override
	public comment update(comment comment) {
		return em.merge(comment);
	}

	@Override
	public void delete(comment comment) {

        em.remove(comment);

	}

	@Override
	public List<comment> findAllCommentsByMovieId(String movieId) {
		TypedQuery<comment> query = em.createNamedQuery("comment.findByMovieId", comment.class);
		query.setParameter("pmovieId", movieId);
        return query.getResultList();
	}

}
