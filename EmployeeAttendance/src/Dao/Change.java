package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DBUtil.DBUtil;

public class Change {
	public boolean change(String table,String lie,String lie0,String gai,String biao)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			String sql="update "+table+" set "+lie+"='"+gai+"' where "+lie0+"='"+biao+"'";
			System.out.println(sql);
			state.executeUpdate(sql);
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
}
