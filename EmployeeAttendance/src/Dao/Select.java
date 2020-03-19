package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Bean.Yuangong_static;
import DBUtil.DBUtil;

public class Select {
	
	public int select(String table) {
		boolean b=false;
		Connection conn=DBUtil.getConn();
		Statement state=null;
		int f=20190000;
		try {
			state=conn.createStatement();
			String sql="select * from "+table;
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				if(f<rs.getInt(1)) {
					f=rs.getInt(1);
				}
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e) {
			
		}
		return ++f;
	}

	public boolean select(String table, String JobID) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		Statement state=null;
		boolean f=false;
		try
		{
			state=conn.createStatement();
			String sql="select * from "+table;
			ResultSet rs=state.executeQuery(sql);
			
			while(rs.next())
			{
				if(JobID.equals(rs.getString(1)))
				{
					f=true;
					Yuangong_static.setJobID(rs.getString(1));
					Yuangong_static.setName(rs.getString(2));
					Yuangong_static.setSex(rs.getString(3));
					Yuangong_static.setBirthday(rs.getString(4));
					Yuangong_static.setDepartment(rs.getString(5));
					Yuangong_static.setRole(rs.getString(6));
					Yuangong_static.setPassword(rs.getString(7));
				}
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return f;
	}

	public boolean select_kaoqin(String table,String JobID, String date, String type) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		Statement state=null;
		boolean f=false;
		try
		{
			state=conn.createStatement();
			String sql="select * from "+table;
			ResultSet rs=state.executeQuery(sql);
			while(rs.next())
			{
				if(JobID.equals(rs.getString(2))&&date.equals(rs.getString(8))&&type.equals(rs.getString(7)))
				{
					f=true;
				}
			}
			rs.close();
			state.close();
			conn.close();
		
		}
		catch(Exception e)
		{
			
		}
		return f;
	}
}
