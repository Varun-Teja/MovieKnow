package api.module.MovieKnow.repository;

import java.util.List;

import api.module.MovieKnow.entity.Comment;

public interface CommentRepository {
	
	public Comment findAll(String movTitle);

	public Comment findOne(String comId);

	public Comment create(Comment com);

//	public Comment update(Comment com);

	public void delete(Comment existing); 
	
}
