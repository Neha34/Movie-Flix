package movie.flix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="rating.findAll", query="SELECT r FROM rating r"),
	//@NamedQuery(name="rating.findAllRatingByMovie", query="SELECT r FROM rating r INNER JOIN r.movie WHERE m.movie.id =:pmovieId"),
	@NamedQuery(name="rating.findAvgRatingByMovie", query="SELECT avg(r.userRating) FROM rating r INNER JOIN r.movie m WHERE m.movieId =:pmovieId")
})
public class rating {
	
	@Id
	private String ratingId;
	@ManyToOne
	private movie movie;
	private double userRating;
	
	
	public String getId() {
		return ratingId;
	}
	public void setId(String ratingId) {
		this.ratingId = ratingId;
	}
	
	public movie getMovie() {
		return movie;
	}
	public void setMovie(movie movie) {
		this.movie = movie;
	}
	public double getUserRating() {
		return userRating;
	}
	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}
	public rating() {
		this.ratingId = UUID.randomUUID().toString();
	}	

	
}
