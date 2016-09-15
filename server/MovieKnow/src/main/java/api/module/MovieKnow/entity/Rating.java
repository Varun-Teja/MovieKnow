package api.module.MovieKnow.entity;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne; 
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Rating.findAll", query = "SELECT rat from Rating rat ORDER BY rat.rating desc"),
		@NamedQuery(name = "Rating.findAverage", query = "SELECT rat.movie.title, avg(rat.rating) from Rating rat GROUP BY rat.movie.title having rat.movie.title=:pTitle")
})
public class Rating {
	
	@Id
	private String id; 

	private int rating;
	
	@OneToOne
	private Movie movie;
	
	@OneToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
