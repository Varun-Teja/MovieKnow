package api.module.MovieKnow.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.module.MovieKnow.entity.Comment;
import api.module.MovieKnow.service.CommentService;

@RestController
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	
	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET, value = "allComments/{title}")
	public Comment findAll(@PathVariable("title") String movTitle) {
		return service.findAll(movTitle);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "{id}")
//	public Rating findOne(@PathVariable("id") int ratingId) {
//		return service.findOne(ratingId);
//	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment com) {
		return service.create(com);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Comment update(@PathVariable("id") String comId, @RequestBody Comment com) {
//		return service.update(comId, com);
//	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String comId) {
		service.remove(comId); 
	}
	
}
