package com.niu.blog.service;

import java.util.List;

import com.niu.blog.dao.UserDao;
import com.niu.blog.entity.User;

public class UserService {

	public UserService() {
	}
	
	public boolean loginVerify(String userName, String password){
		//0.check if username is null
		//if(userName == null){
		//	return false;
		//}
		
		//1. 根据用户名从dao对象得到用户的实体对象
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);
		
		//2. 判断密码是否正确
		if (user.getPassword().equals(password))
			return true;
		else
			return false;
		
		//3. 判断用户是否禁用
		
		//4. 判断用户是否拥有权限
		
		//5. 记录日志

	}
	
	public User addUser(User user){
		UserDao userDao = new UserDao();
		
		User newUser = userDao.addUser(user);
		
		//记录日志等。。。。。。
		
		return newUser;
	}

	public User updateUser(User user){
		UserDao userDao = new UserDao();
		
		User newUser = userDao.updateUser(user);
		
		//记录日志等。。。。。。
		
		return newUser;
	}
	
	public User updateUserPassword(User user) {
		UserDao userDao = new UserDao();
		
		User newUser = userDao.updateUserPassword(user);
		
		//记录日志等。。。。。。
		
		return newUser;
	}
	
	public User findByUserName(String userName) {
		UserDao userDao = new UserDao();
		return userDao.findByUserName(userName);
	}
	
	public boolean exists(String userName){
		User user = findByUserName(userName);
		if (user == null)
			return false;
		else
			return true;
	}

	public List<com.niu.blog.entity.User> findAll() {
		UserDao userDao = new UserDao();
		
		return userDao.findAll();
	}



}
