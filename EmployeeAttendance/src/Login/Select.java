package Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBUtil;

public class Select {

	public boolean select(String table, String username, String password) {
		// TODO Auto-generated method stub
		boolean b=false;
		Connection conn=DBUtil.getConn();
		Statement state=null;
		try {
			state=conn.createStatement();
			String sql="select * from "+table;
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				if(username.equals(rs.getString(1))&&password.equals(rs.getString(7))) {
					String n=rs.getString(6);
					System.out.println(n);
					if(n.equals("管理员")) {
						Power.setPower(0);
					}
					else if(n.equals("经理")) {
						Power.setPower(1);
					}
					else if(n.equals("员工")) {
						Power.setPower(2);
					}
					Power.setBianhao(rs.getString(1));
					Power.setBumen(rs.getString(5));
					b=true;
					
				}
			}
			rs.close();
			state.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
