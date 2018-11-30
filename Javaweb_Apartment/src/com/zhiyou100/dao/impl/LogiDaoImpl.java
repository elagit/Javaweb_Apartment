package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.LogiDao;
import com.zhiyou100.model.Logi;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.PageUtil;

public class LogiDaoImpl implements LogiDao {
	//查询全部的房子信息
	
	
	
	@Override
	public List<Logi> findAll(PageUtil page,String searchContent) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Logi> logis = new ArrayList<>();
		String sql = "SELECT * from logi WHERE lstatus = 1 limit ?,?";
		try {
			if(searchContent == null) {
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, page.getStart());
				 ps.setInt(2, page.getEnd());
				 rs = ps.executeQuery();
			}else {
				 sql = "SELECT * from logi WHERE lstatus = 1" + " " + "AND loname LIKE ?" + " " + "limit ?,?";
				 System.out.println(sql);
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, "%" + searchContent + "%");
				 ps.setInt(2, page.getStart());
				 ps.setInt(3, page.getEnd());
				 rs = ps.executeQuery();
				 System.out.println(sql);
			}
			while(rs.next()){
			     Logi logi = new Logi();
			     logi.setLoname(rs.getString("loname"));
			     logi.setLoaddTime(rs.getDate("loaddTime"));
			     logi.setLosex(rs.getInt("losex"));
			     logi.setLoidCard(rs.getString("loidCard"));
			     logi.setLotel(rs.getString("lotel"));
			     logi.setLosalary(rs.getDouble("losalary"));
			     logis.add(logi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		return logis;
	}

	@Override
	public Logi findLogiDetailAll(int loid) {
		Logi logi = new Logi();
		Connection conn = C3P0Util.getConnection();
		String sql = "select * from logi where loid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, loid);
			rs = ps.executeQuery();
			if(rs.next()) {
				 logi.setLoname(rs.getString("loname"));
			     logi.setLosex(rs.getInt("losex"));
			     logi.setLoidCard(rs.getString("loidCard"));
			     logi.setLotel(rs.getString("lotel"));
			     logi.setLosalary(rs.getDouble("losalary"));
			     logi.setLoaddTime(rs.getDate("loaddTime"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return logi;
	}

	@Override
	public void updateLogi(Logi logi) {
		Connection conn = C3P0Util.getConnection();
		String sql = "UPDATE logi set loname = ?,lotel = ?,loidCard = ?, losex = ?,losalary = ?,loaddTime = ? WHERE loid = ?" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, logi.getLoname());
			ps.setString(2, logi.getLotel());
			ps.setString(3, logi.getLoidCard());
			ps.setInt(4, logi.getLosex());
			ps.setDouble(5, logi.getLosalary());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateUpdate = sdf.format(logi.getLoaddTime());
			ps.setString(6, dateUpdate);
			ps.setInt(7, logi.getLoid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		
	}

	@Override
	public void insertLogi(Logi logi) {
		Connection conn = C3P0Util.getConnection();
		String sql = "INSERT into logi (loname,lotel,loidCard,losex,losalary,loaddTime,) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, logi.getLoname());
			ps.setString(2, logi.getLotel());
			ps.setString(3, logi.getLoidCard());
			ps.setInt(4, logi.getLosex());
			ps.setDouble(5, logi.getLosalary());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateUpdate = sdf.format(logi.getLoaddTime());
			ps.setString(6, dateUpdate);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
	}

	@Override
	public int count() {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement s = null;
		String sql = "select count(loid) as total from logi WHERE lstatus = 1";
		ResultSet rs = null;
		int total = 0;
		try {
			s = conn.prepareStatement(sql);
			rs = s.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, s, conn);
		
		return total;
	}

	

}
