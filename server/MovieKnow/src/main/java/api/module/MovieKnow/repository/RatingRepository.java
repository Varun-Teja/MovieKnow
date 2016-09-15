package api.module.MovieKnow.repository;

import java.util.List;

import api.module.MovieKnow.entity.Rating;

public interface RatingRepository {
	
	public List<Rating> findAll();

	public Rating findOne(String ratingId);

	public Rating create(Rating rating);

	public Rating update(Rating rating);

	public void delete(Rating existing);
	
	public Rating findAvg(String ratingTitle);
}
