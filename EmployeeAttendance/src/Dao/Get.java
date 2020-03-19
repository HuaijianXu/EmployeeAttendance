package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.Bumen;
import Bean.Kaoqin;
import Bean.Yuangong;
import DBUtil.DBUtil;

public class Get {
	public static List<Yuangong> getAll(String table){
		List<Yuangong> list=new ArrayList<Yuangong>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table;
		try {
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next()) {
				Yuangong yg=new Yuangong();
				yg.setJobID(rs.getString(1));
				yg.setName(rs.getString(2));
				yg.setSex(rs.getString(3));
				yg.setBirthday(rs.getString(4));
				yg.setDepartment(rs.getString(5));
				yg.setRole(rs.getString(6));
				yg.setPassword(rs.getString(7));
				list.add(yg);
			}
			rs.close();
			state.close();
			conn.close();
		}catch(Exception e) {
			
		}
		return list;		
	}
	
	public static List<Bumen> getAll1(String table){
		List<Bumen> list=new ArrayList<Bumen>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table;
		try {
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next()) {
				Bumen bm=new Bumen();
				bm.setDepartmentID(rs.getString(1));
				bm.setDepartment(rs.getString(2));
				list.add(bm);
			}
			rs.close();
			state.close();
			conn.close();
		}catch(Exception e) {
			
		}
		return list;		
	}
	
	public static List<Yuangong> getAll_bumen(String table,String department){
		List<Yuangong> list=new ArrayList<Yuangong>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table+" where department ="+"'"+department+"'";
		System.out.println(sql);
		try {
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next()) {
				Yuangong yg=new Yuangong();
				yg.setJobID(rs.getString(1));
				yg.setName(rs.getString(2));
				yg.setSex(rs.getString(3));
				yg.setBirthday(rs.getString(4));
				yg.setDepartment(rs.getString(5));
				yg.setRole(rs.getString(6));
				yg.setPassword(rs.getString(7));
				list.add(yg);
			}
			rs.close();
			state.close();
			conn.close();
		}catch(Exception e) {
			
		}
		return list;		
	}
	
	public static List<Kaoqin> getAll_kaoqin(String table,String JobID){
		List<Kaoqin> list=new ArrayList<Kaoqin>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table+" where JobID ="+"'"+JobID+"'";
		System.out.println(sql);
		try {
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next()) {
				Kaoqin kq=new Kaoqin();
				kq.setDate(rs.getString(8));
				kq.setAttendancetype(rs.getString(7));
				list.add(kq);
			}
			rs.close();
			state.close();
			conn.close();
		}catch(Exception e) {
			
		}
		return list;		
	}
	
	public static List<Kaoqin> getAll_kaoqin1(String table,String department){
		List<Kaoqin> list=new ArrayList<Kaoqin>();
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		ResultSet rs=null;
		String sql="select * from "+table+" where department ="+"'"+department+"'";
		System.out.println(sql);
		try {
			state=conn.prepareStatement(sql);
			rs=state.executeQuery();
			while(rs.next()) {
				Kaoqin kq=new Kaoqin();
				kq.setDate(rs.getString(8));
				kq.setJobID(rs.getString(2));
				kq.setName(rs.getString(3));
				kq.setSex(rs.getString(4));
				kq.setDepartment(rs.getString(6));
				kq.setAttendancetype(rs.getString(7));				
				list.add(kq);
			}
			rs.close();
			state.close();
			conn.close();
		}catch(Exception e) {
			
		}
		return list;		
	}
}
