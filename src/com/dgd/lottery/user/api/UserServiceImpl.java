package com.dgd.lottery.user.api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dgd.lottery.user.dao.User;
import com.dgd.lottery.user.dao.UserDao;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Resource(name = "userDaoImpl")
	private UserDao userdao;
	
	@Override
	public List<User> FindAll() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> list = null;
		try {
			list = userdao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		return list;
	}
	
}
