package com.dgd.lottery.user.api;

import java.util.List;

import com.dgd.lottery.user.dao.User;

public interface UserService {
	
	public List<User> FindAll();
}
