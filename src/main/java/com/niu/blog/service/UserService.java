package com.niu.blog.service;

import java.util.List;

import com.niu.blog.dao.UserDao;
import com.niu.blog.entity.User;

public class UserService {

	public UserService() {
	}
	
	public String loginVerify(String userName, String password){

		String msg = "success";

		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);

		if(userName.equals("")){
			msg = "用户名不能为空";
			return msg;
		}

		if (!exists(userName)){
			msg = "用户名不存在";
			return msg;
		}

		if (!user.getPassword().equals(password)){
			msg = "用户名或密码错误";
			return msg;
		}

		if (!user.getStatus().equals("enabled")){
			msg = "用户被禁用";
			return msg;
		}

		return msg;

		
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
		return user != null;
	}

	public List<com.niu.blog.entity.User> findAll() {
		UserDao userDao = new UserDao();
		
		return userDao.findAll();
	}


	public void modifyUserStatus(String userName) {
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);
		String status = user.getStatus();
		String changedStatus = null;
		if (status.equals("enabled")){
			changedStatus = "disabled";
		}else if (status.equals("disabled")){
			changedStatus = "enabled";
		}

		userDao.modifyUserStatus(userName,changedStatus);
	}
}
