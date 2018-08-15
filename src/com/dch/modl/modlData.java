package com.dch.modl;

import java.util.Date;

public class modlData {
	private Integer empno;
	private String ENAME;
	private String JOB;
	private Integer MGR;
	private Date HIREDATE;
	private Integer COMM;
	private Integer SAL;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public Integer getMGR() {
		return MGR;
	}
	public void setMGR(Integer mGR) {
		MGR = mGR;
	}
	public Date getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(Date date) {
		HIREDATE = date;
	}
	public Integer getCOMM() {
		return COMM;
	}
	public void setCOMM(Integer cOMM) {
		COMM = cOMM;
	}
	public Integer getSAL() {
		return SAL;
	}
	public void setSAL(Integer sAL) {
		SAL = sAL;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "empno:" + empno +",ENAME" + ENAME + ",JOB" + JOB + ",MGR" + MGR + ",HIREDATE" + HIREDATE + ",COMM" + COMM +",SAL" + SAL;
	}
	
	
	
	
	
}
