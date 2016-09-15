package api.module.MovieKnow.entity;
 
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Movie.findAll", query = "SELECT mo from Movie mo ORDER BY mo.year desc"),
		@NamedQuery(name = "Movie.findById", query = "SELECT mo from Movie mo where mo.imdbID=:pId"),
		@NamedQuery(name = "Movie.findByTop", query = "SELECT mo.title, mo.imdbRating, mo.poster from Movie mo where mo.type=:pType and mo.imdbRating>=:pRating ORDER BY mo.imdbRating desc"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT mo from Movie mo where mo.type=:pType"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT mo from Movie mo where mo.year=:pYear"),
		@NamedQuery(name = "Movie.findByGenre", query = "SELECT mo from Movie mo where mo.genre=:pGenre"),
		@NamedQuery(name = "Movie.sortRatings", query = "SELECT mo.title, mo.imdbRating from Movie mo ORDER BY mo.imdbRating desc"),
		@NamedQuery(name = "Movie.sortYear", query = "SELECT mo.title, mo.year from Movie mo ORDER BY mo.year desc"),
		@NamedQuery(name = "Movie.sortVotes", query = "SELECT mo.title, mo.imbdVotes from Movie mo ORDER BY mo.imbdVotes desc"),
		@NamedQuery(name = "Movie.info", query = "SELECT mo.title, mo.director, mo.actors, mo.plot, mo.imdbRating from Movie mo where mo.title=:pTitle")
})
public class Movie {

	@Id
	private String id;

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
	private int metascore;
	private double imdbRating;
	private int imbdVotes;
	
	@Column(unique = true)
	private String imdbID;
	
	private String type;

	public Movie() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImbdVotes() {
		return imbdVotes;
	}

	public void setImbdVotes(int imbdVotes) {
		this.imbdVotes = imbdVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer
				+ ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imbdVotes=" + imbdVotes + ", imdbID=" + imdbID + ", type=" + type + "]";
	}
	
	}
