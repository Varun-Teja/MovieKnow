package api.module.MovieKnow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.module.MovieKnow.entity.Rating;
import api.module.MovieKnow.entity.Movie;
import api.module.MovieKnow.entity.User;
import api.module.MovieKnow.exception.EntityAlreadyExistException; 
import api.module.MovieKnow.exception.EntityNotFoundException;
import api.module.MovieKnow.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	private RatingRepository repository;
	
	@Autowired
	private MovieService ms;
	
	@Autowired
	private UserService us;

	@Override
	public List<Rating> findAll() {
		return repository.findAll();
	}

//	@Override
//	public Rating findOne(String ratingId) {
//		Rating existing = repository.findOne(ratingId);
//		if (existing == null) {
//			throw new EntityNotFoundException("Not found");
//		}
//		return existing;
//	}

	@Transactional
	@Override
	public Rating create(Rating rating) {
		
		String movieId = rating.getMovie().getId();
		String userId = rating.getUser().getId();
		Movie mov = ms.findOne(movieId);
		User user = us.findOne(userId);
		if (mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}
		rating.setMovie(mov);
		rating.setUser(user);
		return repository.create(rating);
	}

	@Transactional
	@Override
	public Rating update(String ratingId, Rating rating) {
		Rating existing = repository.findOne(ratingId);
		if(existing == null){
			throw new EntityNotFoundException("Not found");
		}
		return repository.update(rating);
	}

	@Transactional
	@Override
	public void remove(String ratingId) {
		Rating existing = repository.findOne(ratingId);
		if (existing == null) {
			throw new EntityNotFoundException("Not found");
		}
		repository.delete(existing);
	}
	
	public Rating findAvg(String ratingTitle){
		Rating existing = repository.findOne(ratingTitle);
		if (existing == null) {
			throw new EntityNotFoundException("Not found");
		}
		return repository.findAvg(ratingTitle);
	}


}
