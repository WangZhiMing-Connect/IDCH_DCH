package com.dch.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTIL {
	// 设定数据库驱动，数据库连接地址，端口，名称，用户名，秘密

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@192.168.137.111:1521:orcl";
	private static final String user = "scott";
	private static final String password = "11";
	private static Connection conn = null;

	public static Connection getConnect() {
		try {
			// 1.加载数据库驱动
			Class.forName(driverName);
			//2.获得数据库连接
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
