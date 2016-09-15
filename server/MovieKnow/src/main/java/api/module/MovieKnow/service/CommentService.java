package api.module.MovieKnow.service;
import java.util.List;

import api.module.MovieKnow.entity.Comment;

public interface CommentService {
	
	public Comment findAll(String movTitle);

//	public Comment findOne(String comId);

	public Comment create(Comment com);

//	public Comment update(String comId, Comment com);

	public  void remove(String comId);

}
