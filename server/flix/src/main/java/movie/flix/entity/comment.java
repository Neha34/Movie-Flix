package movie.flix.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="comment.findAll", query="SELECT c FROM comment c"),
	@NamedQuery(name="comment.findByMovieId", query="SELECT c FROM comment c INNER JOIN c.movie m WHERE m.movieId =:pmovieId"),
	
})
public class comment {

	
	@ManyToOne(cascade = CascadeType.ALL)
	private movie movie;
	@Id
	private String commentId;
	private String comment;
	
	public movie getMovie() {
		return movie;
	}
	public void setMovie(movie movie) {
		this.movie = movie;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public comment(){
		this.commentId = UUID.randomUUID().toString();

}
}