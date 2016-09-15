package api.module.MovieKnow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.module.MovieKnow.entity.Comment;
import api.module.MovieKnow.entity.Movie;
import api.module.MovieKnow.entity.User;
import api.module.MovieKnow.exception.EntityAlreadyExistException; 
import api.module.MovieKnow.exception.EntityNotFoundException;
import api.module.MovieKnow.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private MovieService ms;
	
	@Autowired
	private UserService us;

	@Override
	public Comment findAll(String movTitle) {
		return repository.findAll(movTitle);
	}

//	@Override
//	public Comment findOne(String comId) {
//		Comment existing = repository.findOne(comId);
//		if (existing == null) {
//			throw new EntityNotFoundException("Not found");
//		}
//		return existing;
//	}

	@Transactional
	@Override
	public Comment create(Comment com) {
		
		String movieId = com.getMovie().getId();
		String userId = com.getUser().getId();
		Movie mov = ms.findOne(movieId);
		User user = us.findOne(userId);
		if (mov == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		if(user == null){
			throw new EntityNotFoundException("User not found");
		}
		com.setMovie(mov);
		com.setUser(user);
		return repository.create(com);
	}

//	@Transactional
//	@Override
//	public Comment update(String comId, Comment com) {
//		
//		Comment existing = repository.findOne(comId);
//		if(existing == null){
//			throw new EntityNotFoundException("Not found");
//		}
//		String movieId = com.getMovie().getId();
//		String userId = com.getUser().getId();
//		Movie mov = ms.findOne(movieId);
//		User user = us.findOne(userId);
//		if (mov == null) {
//			throw new EntityNotFoundException("Movie not found");
//		}
//		if(user == null){
//			throw new EntityNotFoundException("User not found");
//		}
//
//		return repository.update(com);
//	}

	@Transactional
	@Override
	public void remove(String comId) {
		Comment existing = repository.findOne(comId);
		if (existing == null) {
			throw new EntityNotFoundException("Not found");
		}
		repository.delete(existing);
	}
	
}
