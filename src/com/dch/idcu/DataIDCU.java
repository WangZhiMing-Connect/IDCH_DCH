package com.dch.idcu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dch.db.DBUTIL;
import com.dch.modl.modlData;

public class DataIDCU {
	public void addData(modlData m) throws SQLException {
		Connection conn = DBUTIL.getConnect();
		String sql = "insert into emp(empno,ENAME,JOB,MGR,HIREDATE,COMM,SAL) values(?,?,?,?,?,?,?)";/*HIREDATE,*/
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, m.getEmpno());
		ptmt.setString(2, m.getENAME());
		ptmt.setString(3, m.getJOB());
		ptmt.setInt(4, m.getMGR());
		ptmt.setDate(5, new Date(m.getHIREDATE().getTime()));
		ptmt.setInt(6, m.getCOMM());
		ptmt.setInt(7, m.getSAL());
		ptmt.execute();
	}
	
	public void updateData(modlData m) throws SQLException {
		Connection conn = DBUTIL.getConnect();
		String sql = "update  emp set ENAME=?,JOB=?,MGR=?,HIREDATE=?,COMM=?,SAL=? where empno=?";//HIREDATE=?,
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setString(1, m.getENAME());
		ptmt.setString(2, m.getJOB());
		ptmt.setInt(3, m.getMGR());
		ptmt.setDate(4, new Date(m.getHIREDATE().getTime()));
		ptmt.setInt(5, m.getCOMM());
		ptmt.setInt(6, m.getSAL());
		ptmt.setInt(7, m.getEmpno());
		ptmt.execute();
	}
	
	public void delData(Integer empno) throws SQLException {
		Connection conn = DBUTIL.getConnect();
		String sql = "delete  from  emp where empno = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, empno);
		ptmt.execute();
	}
	
	public List<modlData> query() throws SQLException {
		List<modlData> result = new ArrayList<modlData>();
		
		Connection conn = DBUTIL.getConnect();
		StringBuilder sb = new StringBuilder();
		sb.append( "select *from  emp " );
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		modlData m = null;
		while(rs.next()) {
			m = new modlData();
			m.setEmpno(rs.getInt(1));
			m.setENAME(rs.getString(2));
			m.setJOB(rs.getString(3));
			m.setMGR(rs.getInt(4));
			m.setHIREDATE(rs.getDate(5));
			m.setCOMM(rs.getInt(6));
			m.setSAL(rs.getInt(7));
			result.add(m);
		}
		return result;
	}
	
	public List<modlData> query(String empno,String comm,String sal) throws SQLException{
		List<modlData> result = new ArrayList<modlData>();
		
		Connection conn = DBUTIL.getConnect();
		StringBuilder sb = new StringBuilder();
		sb.append( "select *from  emp " );
		sb.append("where empno like ? and comm like ? and sal = ?");
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+empno+"%");
		ptmt.setString(2, "%"+comm+"%");
		ptmt.setString(3, "%"+sal+"%");
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		
		modlData m = null;
		while(rs.next()) {
			m = new modlData();
			m.setEmpno(rs.getInt(1));
			m.setENAME(rs.getString(2));
			m.setJOB(rs.getString(3));
			m.setMGR(rs.getInt(4));
			m.setHIREDATE(rs.getDate(5));
			m.setCOMM(rs.getInt(6));
			m.setSAL(rs.getInt(7));
			result.add(m);
		}
		return result;
	}
	
	public List<modlData> query(List<Map<String, Object>> params) throws SQLException{
		List<modlData> result = new ArrayList<modlData>();
		
		Connection conn = DBUTIL.getConnect();
		StringBuilder sb = new StringBuilder();
		sb.append( "select *from  emp where 1=1" );
		
		if(params!=null&&params.size()>0) {
			for(int i=0;i<params.size();i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name") +" " +map.get("rela") + " " + map.get("value") + " ");
			}
		}
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		
		modlData m = null;
		while(rs.next()) {
			m = new modlData();
			m.setEmpno(rs.getInt(1));
			m.setENAME(rs.getString(2));
			m.setJOB(rs.getString(3));
			m.setMGR(rs.getInt(4));
			m.setHIREDATE(rs.getDate(5));
			m.setCOMM(rs.getInt(6));
			m.setSAL(rs.getInt(7));
			result.add(m);
		}
		return result;
	}
	
	public modlData get(Integer empno) throws SQLException {
		modlData m = null;
		Connection conn = DBUTIL.getConnect();
		String sql = "select *from emp where empno = ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, empno);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			m = new modlData();
			m.setEmpno(rs.getInt(1));
			m.setENAME(rs.getString(2));
			m.setJOB(rs.getString(3));
			m.setMGR(rs.getInt(4));
			m.setHIREDATE(rs.getDate(5));
			m.setCOMM(rs.getInt(6));
			m.setSAL(rs.getInt(7));
		}
		return m;
	}
}
