package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBUtil;

public class UserDao {
	
	public boolean login(String table,String username) {
		// TODO Auto-generated method stub
		String sql = "select * from "+table+" where JobID ='" + username + "'";
		System.out.println(sql);
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;	
		boolean b=false;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return b;		
	}
	
	public boolean login2(String table,String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from "+table+" where JobID ='" + username + "'";
		System.out.println(sql);
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;	
		boolean b=false;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				if(password.equals(rs.getString("password"))) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return b;		
	}
	
	public boolean login3(String table,String username) {
		// TODO Auto-generated method stub
		String sql = "select * from "+table+" where department ='" + username + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;	
		boolean b=false;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return b;		
	}
	
	public boolean login4(String table,String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from "+table+" where departmentID ='" + username + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		ResultSet rs = null;	
		boolean b=false;
		try {
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				if(password.equals(rs.getString("department"))) {
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, state, conn);
		}
		return b;		
	}
}
