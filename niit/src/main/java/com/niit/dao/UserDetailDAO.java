package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetail;

public interface UserDetailDAO {

	public boolean addUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	//public boolean approveUser(UserDetail userDetail);
	public UserDetail getUser(String userName);
	public List<UserDetail> listUsers();
}

