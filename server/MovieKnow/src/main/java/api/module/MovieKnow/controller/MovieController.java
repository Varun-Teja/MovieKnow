package api.module.MovieKnow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.module.MovieKnow.entity.Movie;
import api.module.MovieKnow.service.MovieService;

@RestController
@RequestMapping(value = "catalog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController { 

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie mov) {
		return service.create(mov);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie mov) {
		return service.update(movieId, mov);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String movieId) {
		service.remove(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "byTop/{type}/{imdbRating}")
	public List<Movie> findTop(@PathVariable("type") String movieType, @PathVariable("imdbRating") String movieRating) {
		return service.findTop(movieType, movieRating);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "byType/{type}")
	public List<Movie> findType(@PathVariable("type") String movieType) {
		return service.findType(movieType);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "byYear/{year}")
	public List<Movie> findYear(@PathVariable("year") int movieYear) {
		return service.findYear(movieYear); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "byGenre/{genre}")
	public List<Movie> findGenre(@PathVariable("genre") String movieGenre) {
		return service.findGenre(movieGenre);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "sortRatings")
	public List<Movie> sortByRatings() {
		return service.sortByRatings();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "sortYear")
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "sortVotes")
	public List<Movie> sortByVotes() {
		return service.sortByVotes();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "info/{title}")
	public List<Movie> movieInfo(@PathVariable("title") String movieTitle) {
		return service.movieInfo(movieTitle);
	}
	
}