package com.mpwx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mpwx.util.DBManager;

public class UploadDao {
	public void insertPic(String aFileName, int aType){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn=DBManager.getConn();
			String sql ="INSERT INTO pic(pic_name,type) VALUE(?,?);";
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, aFileName);
			stmt.setInt(2,aType);
			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null){
					stmt.close();
					stmt=null;
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBManager.closeConn(conn);	
		}
	}
}
