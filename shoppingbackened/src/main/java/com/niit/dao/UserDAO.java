package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
public boolean save(User User);
	
	public boolean delete(User User);
	public boolean update(User User);
	public List<User> listCategories();
	public User getUser(int UserId);



}
