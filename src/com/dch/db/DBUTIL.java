package com.dch.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTIL {
	// �趨���ݿ����������ݿ����ӵ�ַ���˿ڣ����ƣ��û���������

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@192.168.137.111:1521:orcl";
	private static final String user = "scott";
	private static final String password = "11";
	private static Connection conn = null;

	public static Connection getConnect() {
		try {
			// 1.�������ݿ�����
			Class.forName(driverName);
			//2.������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("���ӳɹ�");
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
