package Dao;

import java.sql.Connection;
import java.sql.Statement;

import Bean.Bumen;
import Bean.Kaoqin;
import Bean.Yuangong;
import DBUtil.DBUtil;

public class Add {
	public boolean add(String table,Yuangong yg) {
		boolean b=false;
		String sql="insert into "+table+"(JobID,Name,sex,birthday,department,role,password) values('"+yg.getJobID()+"','"+  yg.getName() + "','" + yg.getSex() + "','" + yg.getBirthday() +"','" + yg.getDepartment() + "','" + yg.getRole()  + "','" + yg.getPassword() +  "')";
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int n=state.executeUpdate(sql);
			if(n!=0) {
				b=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(state, conn);
		}
		return b;
	}
	
	public boolean add(String table,Bumen bm) {
		boolean b=false;
		String sql="insert into "+table+"(departmentID,department) values('"+  bm.getDepartmentID() + "','" +  bm.getDepartment() +  "')";
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int n=state.executeUpdate(sql);
			if(n!=0) {
				b=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(state, conn);
		}
		return b;
	}

	public boolean add(String table, Kaoqin kq) {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="insert into "+table+"(Attendancetime,JobID,Name,sex,birthday,department,Attendancetype,date) values('"+  kq.getAttendancetime() + "','" +  kq.getJobID()+ "','"+ kq.getName() + "','" +  kq.getSex()+ "','"+ kq.getBirthday() + "','" +  kq.getDepartment() +"','" +  kq.getAttendancetype() +"','" +  kq.getDate() +"')";
		System.out.println(sql);
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			int n=state.executeUpdate(sql);
			if(n!=0) {
				b=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(state, conn);
		}
		return b;
	}
	
}
