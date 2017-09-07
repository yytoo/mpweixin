package com.mpwx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mpwx.bean.PicInforBean;
import com.mpwx.util.DBManager;

public class OnLoadWxDAO {
	private String picUrl="https://85015021.qcloud.la/mpweixin/PicFile/";
	public ArrayList<PicInforBean> selectPic(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		ArrayList<PicInforBean> picMaps = new ArrayList<PicInforBean>();
		System.out.println(picMaps+"=================picMap");
		try {
			conn=DBManager.getConn();
			String sql ="SELECT a.*,b.`detail` moduleDetail,b.`name` moduleName FROM (SELECT * FROM pic ORDER BY id DESC) a INNER JOIN module b ON a.`type`=b.`id` GROUP BY TYPE LIMIT 3;";
			stmt= conn.prepareStatement(sql);

			rs=stmt.executeQuery();
			while(rs.next()){
				PicInforBean bean = new PicInforBean();
				bean.setPicName(picUrl+rs.getString("pic_name"));
				bean.setType( rs.getInt("type"));
				bean.setModuleDetail(rs.getString("moduleDetail"));
				bean.setModuleName(rs.getString("moduleName"));
				picMaps.add(bean);
			}
			System.out.println(picMaps+"=================picMap");
			return picMaps;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs != null){
					rs.close();
					rs=null;
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
