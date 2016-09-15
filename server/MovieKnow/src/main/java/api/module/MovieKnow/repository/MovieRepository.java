package api.module.MovieKnow.repository;

import java.util.List;

import api.module.MovieKnow.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie findByImdbId(String imdbId);

	public Movie create(Movie mov); 

	public Movie update(Movie mov); 

	public void delete(Movie existing);
	
	public List<Movie> findTop(String movieType, String movieRating);
	
	public List<Movie> findType(String movieType);
	
	public List<Movie> findYear(int movieYear);
	
	public List<Movie> findGenre(String movieGenre);
	
	public List<Movie> sortByRatings();
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByVotes();
	
	public List<Movie> movieInfo(String movieTitle);
}
