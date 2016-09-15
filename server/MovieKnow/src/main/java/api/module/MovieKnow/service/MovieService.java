package api.module.MovieKnow.service;

import java.util.List;

import api.module.MovieKnow.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie mov);

	public Movie update(String movieId, Movie mov);

	public void remove(String movieId); 
	
	public List<Movie> findTop(String movieType, String movieRating);
	
	public List<Movie> findType(String movieType);
	
	public List<Movie> findYear(int movieYear);
	
	public List<Movie> findGenre(String movieGenre);
	
	public List<Movie> sortByRatings();
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByVotes();
	
	public List<Movie> movieInfo(String movieTitle);
}
