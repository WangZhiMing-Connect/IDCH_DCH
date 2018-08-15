package com.dch.ViewData;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ObjDoubleConsumer;

import com.dch.ActionData.Actiondata;
import com.dch.modl.modlData;

import oracle.sql.DATE;

public class Viewdata {

	private static final String CONTEXT = "欢迎来到员工数据库： \n 下面是 是员工数据库的功能列表： \n "+ 
			"[MAIN/M]：主菜单\n "+
			"[QUERY/Q]：查看所有员工的信息\n "+
			"[TUO/T]：查看所有员工的信息(对员工奖金进行隐藏)\n "+
			"[GET/G]：查看某个员工的信息\n "+
			"[ADD/A]:添加员工信息\n "+
			"[UPDATE/U]:更新员工信息\n "+
			"[DELETE/D]：删除员工信息\n "+
			"[SELECT/S]:按条件查询某个员工的信息:根据员工信息的两个条件（如员工姓名和职位）\n " +
			"[EXIT/E]:推出员工数据库\n "+
			"[BREAK/B]：推出当前功能，返回主菜单";

	private static final String DCHATION_MAIN = "MAIN";
	private static final String DCHATION_QUERY = "QUERY";
	
	private static final String DCHATION_TUO = "TUO";
	
	private static final String DCHATION_GET = "GET";
	private static final String DCHATION_ADD = "ADD";
	private static final String DCHATION_UPDATE = "UPDATE";
	private static final String DCHATION_DELETE = "DELETE";
	private static final String DCHATION_SEARCH = "SEARCH";
	private static final String DCHATION_EXIT = "EXIT";
	private static final String DCHATION_BREAK = "BREAK";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(CONTEXT);

		Scanner s = new Scanner(System.in);
		Actiondata action = new Actiondata();

		String pervious = null;
		Integer step = 1;
		modlData m = null;

		while (s.hasNext()) {
			String in = s.next();
			if (DCHATION_EXIT.equals(in.toUpperCase()) || DCHATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("您已经成功退出员工数据库系统");
				break;
			} else if (DCHATION_MAIN.equals(in.toUpperCase())
					|| DCHATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
				step = 1;
				pervious = null;
				m = null;
				System.out.println(CONTEXT);
			} else if (DCHATION_QUERY.equals(in.toUpperCase())
					|| DCHATION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
				List<modlData> list = action.query();
				for (modlData m1 : list) {
					System.out.println(m1.toString());
				}
				
//				for (modlData m1 : list) {
//					System.out.println(m1.getENAME().replaceAll(".", "*"));
//				}
				
//				for(Iterator iterator=list.iterator();iterator.hasNext(); ) {
//					System.out.println(iterator.next());
//				}
			} else if (DCHATION_TUO.equals(in.toUpperCase())
					|| DCHATION_TUO.substring(0, 1).equals(in.toUpperCase())) {
				List<modlData> list = action.query();
							
				for (modlData m1 : list) {
					Integer l1=m1.getEmpno();
					String l2=m1.getENAME().replaceAll(".", "*");
					String l3=m1.getJOB().replaceAll(".", "*");
					Integer l4=m1.getMGR();
					java.util.Date l5=m1.getHIREDATE();
					Integer f=m1.getCOMM();
					String l6=Integer.toString(f).replaceAll(".", "*");
					Integer f1=m1.getSAL();
					String l7=Integer.toString(f1).replaceAll(".", "#");
					System.out.println("ENPNO:" + l1 + " \tENAME:" + l2 + " \tJOB:" + l3 +" \tMGR:" +l4+" \tHIREDATE:" + l5 + " \tCOMM:" + l6 + " \tSAL:" + l7);
				}
				
//				for(Iterator iterator=list.iterator();iterator.hasNext(); ) {
//					System.out.println(iterator.next());
//				}
			} 
			else if (DCHATION_GET.equals(in.toUpperCase()) || DCHATION_GET.substring(0, 1).equals(in.toUpperCase())
					|| DCHATION_GET.equals(pervious)) {
				pervious = DCHATION_GET;
				if (step == 1) {
					System.out.println("请输入员工的编号empno:");
				} else if (step > 1) {
					Integer empno = null;
					modlData m1;
					try {
						empno = Integer.valueOf(in);
						try {
							m1 = action.get(empno);
							if (m1 == null) {
								System.out.println("查询失败");
							} else {
								System.out.println(m1.toString());
								System.out.println("脱敏后的结果：");
								Integer l1=m1.getEmpno();
								String l2=m1.getENAME().replaceAll(".", "*");
								String l3=m1.getJOB().replaceAll(".", "*");
								Integer l4=m1.getMGR();
								java.util.Date l5=m1.getHIREDATE();
								Integer f=m1.getCOMM();
								String l6=Integer.toString(f).replaceAll(".", "*");
								Integer f1=m1.getSAL();
								String l7=Integer.toString(f1).replaceAll(".", "#");
								System.out.println("ENPNO:" + l1 + " \tENAME:" + l2 + " \tJOB:" + l3 +" \tMGR:" +l4+" \tHIREDATE:" + l5 + " \tCOMM:" + l6 + " \tSAL:" + l7);
							
							}
						} catch (Exception e) {
							System.out.println("查询失败");
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("请重新输入员工编号");
					}
				}
				step++;
			} else if (DCHATION_ADD.equals(in.toUpperCase()) || DCHATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| DCHATION_ADD.equals(pervious)) {
				pervious = DCHATION_ADD;
				if (step == 1) {
					System.out.println("请输入员工编号[empno]:");
				} else if (step == 2) {
					try {
						m = new modlData();
						m.setEmpno(Integer.parseInt(in));
						System.out.println("请输入员工姓名[ename]");
					} catch (Exception e) {
						step = 1;
						System.out.println("请重新输入正确员工编号");
					}
				} else if (step == 3) {
					m.setENAME(in);
					System.out.println("请输入员工职位[job]");
				} else if (step == 4) {
					m.setJOB(in);
					System.out.println("请输入员工MGR");
				} else if (step == 5) {
					try {
						m.setMGR(Integer.parseInt(in));
						System.out.println("请输入员工入职日期[hiredate格式：yyyy-MM-dd]");
					} catch (Exception e) {
						step = 4;
						System.out.println("请重新输入正确员工MGR");
					}
				} else if(step==6) {
					SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date hiredate=null;
					try {
						hiredate=sf.parse(in);
						m.setHIREDATE(hiredate);
						System.out.println("请输入员工奖金[comm]");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("输入格式有误，请重新输入");
						step=5;
					}
				}
				
				else if (step == 7) {
					try {
						m.setCOMM(Integer.parseInt(in));
						System.out.println("请输入员工薪资[sal]");
					} catch (Exception e) {
						step = 6;
						System.out.println("请重新输入正确员工奖金");
					}
				} else if (step == 8) {
					m.setSAL(Integer.valueOf(in));
					try {
						action.add(m);
					} catch (Exception e) {
						System.out.println("新增员工信息失败");
					}
					System.out.println("新增员工信息成功");
					step = 1;
					pervious = null;
				}
				if (DCHATION_ADD.equals(pervious)) {
					step++;
				}
			} else if (DCHATION_UPDATE.equals(in.toUpperCase())
					|| DCHATION_UPDATE.substring(0, 1).equals(in.toUpperCase()) || DCHATION_UPDATE.equals(pervious)) {
				pervious = DCHATION_UPDATE;
				if (step == 1) {
					System.out.println("请输入要修改的员工编号");
				} else if (step == 2) {
					// try {
					// Integer empno = null;
					// m=new modlData();
					// try {
					// empno=Integer.valueOf(in);
					// try {
					// m = action.get(empno);
					//
					// if (m == null) {
					// System.out.println("查询员工信息失败");
					// step = 1;
					// }
					// }catch (Exception e) {
					// System.out.println("查询员工信息失败");
					// }
					// } catch (Exception e) {
					// System.out.println("请输入正确的员工编号");
					// step = 1;
					// }
					// } catch (Exception e) {
					// System.out.println("请输入正确的员工信息");
					// step = 1;
					// }
					Integer empno = null;
					try {
						m = new modlData();
						empno = Integer.valueOf(in);
						m.setEmpno(empno);
						System.out.println("请输入员工的姓名，如果不修改，请输入-1：");
					} catch (Exception e) {
						System.out.println("请输入正确的员工编号");
						step=1;
					}
				} else if (step == 3) {
					// if (-1 != Integer.parseInt(in)) {
					// m.setENAME(in);
					// }
					if ("-1" != in) {
						m.setENAME(in);
					}
					System.out.println("请输入员工的职位，如果不修改，请输入-1：");
				} else if (step == 4) {
					if ("-1" != in) {
						m.setJOB(in);
					}
					// if (-1 !=Integer.valueOf(in).intValue()) {
					// m.setJOB(in);
					// }
					System.out.println("请输入员工的MGR，如果不修改，请输入-1：");
				} else if (step == 5) {
					Integer mgr = null;
					try {
						mgr = Integer.valueOf(in);
						if (mgr != -1) {
							m.setMGR(mgr);
						}
						System.out.println("请输入员工入职日期[yyyy-MM-dd]，如果不修改，请输入-1：");
					} catch (Exception e) {
						System.out.println("请输入正确的员工MGR");
						step=4;
					}
				} else if(step==6) {
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date hiredate=null;
					try {
					if("-1"!=in) {
						hiredate=sf.parse(in);
						m.setHIREDATE(hiredate);
					}
					System.out.println("请输入员工奖金，如果不修改，请输入-1");
					}catch (Exception e) {
						System.out.println("请输入正确的员工入职日期[hiredate格式：yyyy-MM-dd]");
						step=5;
					}
				}
				else if (step == 7) {
					Integer comm = null;
					try {
						comm = Integer.valueOf(in);
						if (comm != -1) {
							m.setCOMM(comm);
						}
						System.out.println("请输入员工的薪资，如果不修改，请输入-1：");
					} catch (Exception e) {
						System.out.println("请输入正确的员工奖金COMM");
						step=6;
					}
				} else if (step == 8) {
					try {
						Integer sal = null;
						sal = Integer.valueOf(in);
						if (sal != -1) {
							m.setSAL(sal);
						}
						action.edit(m);
					} catch (Exception e) {
						System.out.println("更新员工信息失败");
					}
					System.out.println("更新员工信息成功");
					step = 1;
					pervious = null;
				}
				if (DCHATION_UPDATE.equals(pervious)) {
					step++;
				}
			} else if (DCHATION_DELETE.equals(in.toUpperCase())
					|| DCHATION_DELETE.substring(0, 1).equals(in.toUpperCase()) || DCHATION_DELETE.equals(pervious)) {
				pervious = DCHATION_DELETE;
				if (step == 1) {
					System.out.println("请输入要删除的员工的编号empno:");
				} else if (step == 2) {
					try {
						Integer empno = null;
						try {
							empno = Integer.valueOf(in);
							action.del(empno);
							step = 1;
							System.out.println("删除员工信息成功");
						} catch (Exception e) {
							System.out.println("更新员工信息失败");
						}
					} catch (Exception e) {
						System.out.println("请输入正确的员工编号：");
						step = 1;
					}
				}
				if (DCHATION_DELETE.equals(pervious)) {
					step++;
				}
			} else if (DCHATION_SEARCH.equals(in.toUpperCase())
					|| DCHATION_SEARCH.substring(0, 1).equals(in.toUpperCase()) || DCHATION_SEARCH.equals(pervious)) {
				pervious = DCHATION_SEARCH;
				if (step == 1) {
					System.out.println("请输入要查询的员工编信息：支持两个条件查询，如果参数都输入，中间要逗号隔开[ename=vvvv,job=kkkk]");
				} else if (step == 2) {
					if (in != null || in != "") {
						try {
						List<Map<String, Object>> parmas = new ArrayList<Map<String, Object>>();
						Map<String, Object> param = null;

						String[] strs = in.split(",");
						for (int i = 0; i < strs.length; i++) {
							String[] strs_s = strs[i].split("=");
							param = new HashMap<String, Object>();
							param.put("name", strs_s[0]);
							param.put("rela", "=");
							param.put("value", "'" + strs_s[1] + "'");
							parmas.add(param);
						}
						List<modlData> list = action.query(parmas);
						if (list != null && list.size() > 0) {
							for (modlData m1 : list) {
								System.out.println(m1.toString());
							}
						} else {
							System.out.println("没有查询到员工信息");
						}
						}catch (Exception e) {
							System.out.println("请输入正确的查询条件");
						}
						step = 1;
					}
				}
				if (DCHATION_SEARCH.equals(pervious)) {
					step++;
				}
			}
		}
	}

}
