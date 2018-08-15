package com.dch.ActionData;

import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.dch.idcu.DataIDCU;
import com.dch.modl.modlData;

public class Actiondata {
	
	public void add(modlData m) throws SQLException {
		DataIDCU idcu = new DataIDCU();
//		m.setEmpno(6666);
//		m.setENAME("aaaa");
//		m.setJOB("bbbb");
//		m.setMGR(3333);
//		//DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		//m.setHIREDATE(df.parse("1992-5-6"));
//		m.setCOMM(2222);
//		m.setSAL(1234);
		idcu.addData(m);
	}
	
	public modlData get(Integer empno) throws SQLException {
		DataIDCU idcu = new DataIDCU();
		return idcu.get(empno);
	}
	
	public void edit(modlData m) throws SQLException {
		DataIDCU idcu = new DataIDCU();
		idcu.updateData(m);
	}
	
	public void del(Integer empno) throws SQLException {
		DataIDCU idcu = new DataIDCU();
		idcu.delData(empno);
	}
	
	public List<modlData> query() throws SQLException{
		DataIDCU idcu = new DataIDCU();
		return idcu.query();
	}
	
	public List<modlData> query(List<Map<String, Object>> params ) throws SQLException{
		DataIDCU idcu = new DataIDCU();
		return idcu.query(params);
	}
}
