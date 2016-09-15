package api.module.MovieKnow.service;

import java.util.List;

import api.module.MovieKnow.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public User update(String userId, User user);

	public void remove(String userId);
}