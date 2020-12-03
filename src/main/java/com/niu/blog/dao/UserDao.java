package com.niu.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.User;

public class UserDao {
	public User findByUserName(String userName){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		cn = DbObject.getConnection();
		if (cn == null) 
			return null;
		
		try {
			//4.执行sql
			String sql = "select * from users where username=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, userName);
						
			rs = st.executeQuery();
			if (rs.next()){
				User user = new User();
				user.setUserName(userName);
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullName"));
				
				return user;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, rs);
		}
		
		return null;
	}
	
	public User addUser(User user){
		Connection cn = null;
		PreparedStatement st = null;
		
		cn = DbObject.getConnection();

		try {
			//4.执行sql
			String sql = "insert into users (username,fullname,gender,age,email,password,) values(?,?,?,?,?,?)";
			st = cn.prepareStatement(sql);
			
			st.setString(1, user.getUserName());
			st.setString(2, user.getFullName());
			st.setString(3, user.getGender());
			st.setInt(4,user.getAge());
			st.setString(5, user.getEmail());
			st.setString(6, user.getPassword());
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
		}
		return user;
	}	

	public User updateUser(User user){
		Connection cn = null;
		PreparedStatement st = null;
		
		cn = DbObject.getConnection();
		
		try {
			//4.执行sql
			String sql = "update users set fullname=? where username=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, user.getFullName());
			st.setString(2, user.getUserName());
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
		}
		return user;
	}
	
	public User updateUserPassword(User user) {
		Connection cn = null;
		PreparedStatement st = null;
		
		cn = DbObject.getConnection();
		
		try {
			//4.执行sql
			String sql = "update users set password=? where username=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1, user.getPassword());
			st.setString(2, user.getUserName());
			
			int ret = st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, null);
		}
		return user;
	}

	public List<com.niu.blog.entity.User> findAll() {
		ArrayList<User> userList = new ArrayList<User>();
		
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		cn = DbObject.getConnection();
		if (cn == null) 
			return null;
		
		try {
			//4.执行sql
			String sql = "select * from users";
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			while (rs.next()){
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullName"));
				
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//5.关闭数据库连接
			DbObject.close(cn, st, rs);
		}
		
		return userList;
	}


}
