package api.module.MovieKnow.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.module.MovieKnow.entity.Rating;
import api.module.MovieKnow.service.RatingService;

@RestController
@RequestMapping(value = "rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingController {
	
	@Autowired
	private RatingService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> findAll() {
		return service.findAll();
	}

//	@RequestMapping(method = RequestMethod.GET, value = "{id}")
//	public Rating findOne(@PathVariable("id") int ratingId) {
//		return service.findOne(ratingId);
//	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating create(@RequestBody Rating rating) {
		return service.create(rating);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating update(@PathVariable("id") String ratingId, @RequestBody Rating rating) {
		return service.update(ratingId, rating);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String ratingId) {
		service.remove(ratingId); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "byAvg/{title}")
	public Rating findAvg(@PathVariable("title") String ratingTitle) {
		   return service.findAvg(ratingTitle); 
	} 

}
