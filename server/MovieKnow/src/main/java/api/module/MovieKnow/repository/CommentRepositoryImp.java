package api.module.MovieKnow.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import api.module.MovieKnow.entity.Comment; 

public class CommentRepositoryImp implements CommentRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Comment findAll(String movTitle) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getSingleResult();
	}
	
	@Override
	public Comment findOne(String comId) {
		return em.find(Comment.class, comId);
	}
	
	@Override
	public Comment create(Comment com) {
		em.persist(com);
		return com;
	}
	
//	@Override
//	public Comment update(Comment com) {
//		return em.merge(com);
//	}
	
	@Override
	public void delete(Comment existing) {
		em.remove(existing);
	}
	
}
