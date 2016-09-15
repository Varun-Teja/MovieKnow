package api.module.MovieKnow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.module.MovieKnow.entity.Movie;
import api.module.MovieKnow.exception.EntityAlreadyExistException; 
import api.module.MovieKnow.exception.EntityNotFoundException;
import api.module.MovieKnow.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String movieId) {
		Movie mov = repository.findOne(movieId);
		if (mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return mov;
	}

	@Transactional
	@Override
	public Movie create(Movie mov) {
		Movie existing = repository.findByImdbId(mov.getImdbID());
		if (existing != null) {
			throw new EntityAlreadyExistException("Movie already exists with this id");
		}
		return repository.create(mov);
	}

	@Transactional
	@Override
	public Movie update(String movieId, Movie mov) {
		Movie existing = repository.findOne(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(mov);
	}

	@Transactional
	@Override
	public void remove(String movieId) {
		Movie existing = repository.findOne(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}
	
	@Override
	public List<Movie> findTop(String movieType, String movieRating) {
		List<Movie> mov = repository.findTop(movieType, movieRating);
		if (mov == null) {
			throw new EntityNotFoundException("Not found");
		}
		return mov;
	}
	
	@Override
	public List<Movie> findType(String movieType) {
		List<Movie> mov = repository.findType(movieType);
		if (mov == null) {
			throw new EntityNotFoundException("Not found");
		}
		return mov;
	}
	
	@Override
	public List<Movie> findYear(int movieYear) {
		List<Movie> mov = repository.findYear(movieYear);
		if (mov == null) {
			throw new EntityNotFoundException("Not found");
		}
		return mov;
	}
	
	@Override
	public List<Movie> findGenre(String movieGenre) {
		List<Movie> mov = repository.findGenre(movieGenre);
		if (mov == null) {
			throw new EntityNotFoundException("Not found");
		}
		return mov; 
	}
	
	@Override
	public List<Movie> sortByRatings() {
		return repository.sortByRatings();
	}
	
	@Override
	public List<Movie> sortByYear() {
		return repository.sortByYear();
	}
	
	@Override
	public List<Movie> sortByVotes() {
		return repository.sortByVotes();
	}
	
	@Override
	public List<Movie> movieInfo(String movieTitle) {
		List<Movie> mov = repository.movieInfo(movieTitle);
		if (mov == null) {
			throw new EntityNotFoundException("Not found");
		}
		return mov;
	}

}