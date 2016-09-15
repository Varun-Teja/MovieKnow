package api.module.MovieKnow.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import api.module.MovieKnow.entity.Movie; 

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByImdbId(String imdbId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findById", Movie.class);
		query.setParameter("pId", imdbId);
		List<Movie> movies = query.getResultList();
		if (movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return em.merge(mov);
	}

	@Override
	public void delete(Movie existing) {
		em.remove(existing);
	}
	
	@Override
	public List<Movie> findTop(String movieType, String movieRating) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTop", Movie.class);
		query.setParameter("pType", movieType);
		query.setParameter("pRating", movieRating);
		List<Movie> movies = query.getResultList(); 
		return movies;
	}
	
	@Override
	public List<Movie> findType(String movieType) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", movieType);
		List<Movie> movies = query.getResultList(); 
		return movies;
	}
	
	@Override
	public List<Movie> findYear(int movieYear) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", movieYear);
		List<Movie> movies = query.getResultList();
		return movies;
	}
	
	@Override
	public List<Movie> findGenre(String movieGenre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre", Movie.class);
		query.setParameter("pGenre", movieGenre);
		List<Movie> movies = query.getResultList(); 
		return movies;
	}
	
	@Override
	public List<Movie> sortByRatings() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortRatings", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortYear", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> sortByVotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortVotes", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> movieInfo(String movieTitle) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.info", Movie.class);
		query.setParameter("pTitle", movieTitle);
		List<Movie> movies = query.getResultList(); 
		return movies;
	}
		
}