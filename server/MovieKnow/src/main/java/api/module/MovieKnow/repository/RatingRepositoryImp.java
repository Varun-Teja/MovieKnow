package api.module.MovieKnow.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import api.module.MovieKnow.entity.Rating; 

public class RatingRepositoryImp implements RatingRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}
	
	@Override
	public Rating findOne(String ratingId) {
		return em.find(Rating.class, ratingId);
	}
	
	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}
	
	@Override
	public Rating update(Rating rating) {
		return em.merge(rating);
	}
	
	@Override
	public void delete(Rating existing) {
		em.remove(existing);
	}
	
	public Rating findAvg(String ratingTitle){
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAverage", Rating.class);
		query.setParameter("pTitle", ratingTitle);
		Rating average = query.getSingleResult();   
		return average; 
		}
}
