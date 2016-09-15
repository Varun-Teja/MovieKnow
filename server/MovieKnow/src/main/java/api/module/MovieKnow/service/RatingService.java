package api.module.MovieKnow.service;
import java.util.List;

import api.module.MovieKnow.entity.Rating;

public interface RatingService {
	
	public List<Rating> findAll();

//	public Rating findOne(String ratingId);

	public Rating create(Rating rating);

	public Rating update(String ratingId, Rating rating);

	public void remove(String ratingId);
	
	public Rating findAvg(String ratingTitle);

}
