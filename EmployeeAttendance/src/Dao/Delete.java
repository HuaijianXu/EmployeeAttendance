package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import DBUtil.DBUtil;




public class Delete {

	public boolean delete(String table,String name,String value)
	{
		boolean c=false;
		Connection conn=DBUtil.getConn();
		PreparedStatement state=null;
		String sql="delete from "+table+" where "+name+"=?";
		try {
			state=conn.prepareStatement(sql);
			state.setString(1,value);
			int num = state.executeUpdate();
			if(num!=0)
			{
				c= true;
			}
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	
}
