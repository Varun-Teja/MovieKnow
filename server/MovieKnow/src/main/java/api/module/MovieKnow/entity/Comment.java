package api.module.MovieKnow.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
//		@NamedQuery(name = "Comment.findAll", query = "SELECT com from Comment com ORDER BY com.id desc"),
		@NamedQuery(name = "Comment.findAll", query = "SELECT com.movie.title, com.comment from Comment com where com.movie.title=:pTitle")
})

public class Comment {
	
	@Id
	private String id; 

	private String comment;
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment; 
	}

	public void setComment(String comment) {
		this.comment = comment;
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
