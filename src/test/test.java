package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.LineListener;
import javax.swing.ActionMap;

import com.dch.ActionData.Actiondata;
import com.dch.modl.modlData;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Actiondata action = new Actiondata();
		modlData m = new modlData();
		//m.setEmpno("0000");
		m.setEmpno(6666);
		m.setENAME("vkll");
		m.setJOB("kjkh");
		m.setMGR(8888);
		//m.setHIREDATE(rs.getDate(5));
		m.setCOMM(7777);
		m.setSAL(9999);
//		
//		//action.add(m);
		action.edit(m);
//		//action.del(empno);
		
//		List<Map<String, Object>> parmas =new ArrayList<Map<String,Object>>();
//		Map<String, Object>map = new HashMap<String, Object>();
//		
//		map.put("name", "ENAME");
//		map.put("rela", "=");
//		map.put("value", "'vvvv'");
//		parmas.add(map);
//		
//		List<modlData> result = action.query(parmas);
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getENAME() +": " + result.get(i).getJOB());
//			
//		}
	}

}
