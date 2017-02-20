package movie.flix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="movie.findAll", query="SELECT m from movie m"),
	@NamedQuery(name="movie.findTopRated", query="SELECT m from movie m WHERE m.type =:ptype ORDER BY m.imdbRating desc"),
	@NamedQuery(name="movie.findByTitle", query="SELECT m from movie m WHERE m.title = :ptitle"),
	
	@NamedQuery(name="movie.findByYear", query="SELECT m from movie m WHERE m.year=:pyear"),
	@NamedQuery(name="movie.findAllSortByYear", query="SELECT m from movie m ORDER BY m.year desc"),
	@NamedQuery(name="movie.findByTypeSortByYear", query="SELECT m from movie m WHERE m.type LIKE :ptype ORDER BY m.year desc"),
	@NamedQuery(name="movie.findByGenreSortByYear", query="SELECT m from movie m WHERE m.genre LIKE :pgenre ORDER BY m.year desc"),
	@NamedQuery(name="movie.findByTypeGenreSortByYear", query="SELECT m from movie m WHERE m.type LIKE :ptype AND m.genre LIKE :pgenre ORDER BY m.year desc"),
	@NamedQuery(name="movie.findByDirector", query="SELECT m from movie m WHERE m.director=:pdirector"),
	@NamedQuery(name ="movie.findByTypeYear", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year = :pyear ORDER BY m.year asc"),
	@NamedQuery(name ="movie.findByYearGenre", query = "SELECT m FROM movie m WHERE m.year = :pyear AND m.genre LIKE :pgenre ORDER BY m.year asc"),
	@NamedQuery(name ="movie.findByTypeYearGenre", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year = :pyear AND m.genre LIKE :pgenre ORDER BY m.year asc"),
	
	@NamedQuery(name = "movie.findAllSortByVotes", query = "SELECT m FROM movie m ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByYearSortByVotes", query = "SELECT m FROM movie m WHERE m.year = :pyear ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByGenreSortByVotes", query = "SELECT m FROM movie m WHERE m.genre LIKE :pgenre ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByTypeSortByVotes", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByTypeGenreSortByVotes", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.genre LIKE :pgenre ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByTypeYearSortByVotes", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year = :pyear ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByYearGenreSortByVotes", query = "SELECT m FROM movie m WHERE m.year = :pyear AND m.genre LIKE :pgenre ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "movie.findByTypeYearGenreSortByVotes", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year = :pyear AND m.genre LIKE :pgenre ORDER BY m.imdbVotes DESC"),
	
	@NamedQuery(name = "movie.findAllSortByRating", query = "SELECT m FROM movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByTypeSortByRating", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByYearSortByRating", query = "SELECT m FROM movie m WHERE m.year = :pyear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByGenreSortByRating", query = "SELECT m FROM movie m WHERE m.genre LIKE :pgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByTypeGenreSortByRating", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.genre LIKE :pgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByTypeYearSortByRating", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year = :pyear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByYearGenreSortByRating", query = "SELECT m FROM movie m WHERE m.year=:pyear AND m.genre LIKE :pgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "movie.findByTypeYearGenreSortByRating", query = "SELECT m FROM movie m WHERE m.type LIKE :ptype AND m.year=:pyear AND m.genre LIKE :pgenre ORDER BY m.imdbRating DESC"),

})
public class movie {
	@Id
	@Column(unique=true)
	private String movieId;
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdbRating;
	private String imdbVotes;
	@Column(unique=true)
	private String imdbId;
	private String type;
	public String getId() {
		return movieId;
	}
	public void setId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMetascore() {
		return metascore;
	}
	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public movie() {
		this.movieId = UUID.randomUUID().toString();
	}
	
	@Override
	public String toString() {
		return "movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}


}
