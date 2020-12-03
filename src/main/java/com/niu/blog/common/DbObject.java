package com.niu.blog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObject {
	public static Connection getConnection(){
		Connection cn = null;
		
		try {
			//1.装载数据库驱动
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.准备数据库连接串url
//			String url = "jdbc:sqlserver://localhost\\SQL2012:1433;user=sa;password=mis123456;database=Test";
			String url = "jdbc:mysql://localhost:3306/Test";
			String name = "root";
			String pass = "qw00123.";
			
			//3.连接数据库
			cn = DriverManager.getConnection(url,name,pass);
			return cn;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static void close(Connection cn, Statement st, ResultSet rs){
		//5.关闭数据库连接
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			rs = null;
		}
		if (st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			st = null;
		}
		if (cn != null){
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			cn = null;
		}
	}
}
