package dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AdminDao;
import pojo.Admin;
import util.DBUtil;


public class AdminDaoImpl implements AdminDao {
	
	@Override
	public Admin getAdminByName(String name) {
		Admin admin = new Admin();
		Connection conn=DBUtil.getConnSource();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String sql="select * from admin where user_name=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			rs=pst.executeQuery();
			while(rs.next()){
				admin.setId(rs.getInt("id"));
				admin.setUserName(rs.getString("user_name"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return admin;
	}

}
