package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhiyou100.dao.LesseeDao;
import com.zhiyou100.model.Lessee;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.DSUtil;
import com.zhiyou100.util.PageUtil;

public class LesseeDaoImpl implements LesseeDao {

	@Override
	public List<Lessee> findLesseeAll(PageUtil page) {
		List<Lessee> lessees = new ArrayList<>();
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from lessee WHERE lstatus = 1 limit ?,?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page.getStart());
			ps.setInt(2, page.getEnd());
			rs = ps.executeQuery();
			while(rs.next()) {
				Lessee lessee = new Lessee();
				lessee.setLid(rs.getInt("lid"));
				lessee.setLname(rs.getString("lname"));
				lessee.setLtel(rs.getString("ltel"));
				lessee.setLsex(rs.getInt("lsex"));
				lessee.setLnp(rs.getString("lnp"));
				lessee.setLidCard(rs.getString("lidCard"));
				lessee.setLaddTime(rs.getDate("laddTime"));
				lessees.add(lessee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return lessees;
	}

	
	
	@Override
	public int count() {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement s = null;
		String sql = "select count(lid) as total from lessee WHERE lstatus = 1";
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



	@Override
	public Lessee lesseeFindByLid(int lid) {
		Lessee lessee = new Lessee();
		Connection conn = C3P0Util.getConnection();
		String sql = "select * from lessee where lid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lid);
			rs = ps.executeQuery();
			if(rs.next()) {
				lessee.setLaddTime(rs.getDate("laddTime"));
				lessee.setLidCard(rs.getString("lidCard"));
				lessee.setLname(rs.getString("lname"));
				lessee.setLnp(rs.getString("lnp"));
				lessee.setLsex(rs.getInt("lsex"));
				lessee.setLtel(rs.getString("ltel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return lessee;
	}



	@Override
	public void lesseeAdd(Lessee lessee) {
		Connection conn = C3P0Util.getConnection();
		String sql = "INSERT into lessee VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DSUtil ds = new DSUtil();
		try {
			ps = conn.prepareStatement(sql);
			String date = ds.dateToString(lessee.getLaddTime());
			ps.setObject(1,null);
			ps.setString(2, lessee.getLname());
			ps.setString(3, lessee.getLtel());
			ps.setInt(4, lessee.getLsex());
			ps.setString(5, lessee.getLnp());
			ps.setString(6, lessee.getLidCard());
			ps.setString(7, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
	}



	@Override
	public void lesseeUpdate(Lessee lessee) {
		Connection conn = C3P0Util.getConnection();
		String sql = "UPDATE lessee set lname = ?,ltel = ?,lsex = ?,lnp = ?,lidcard = ?,laddTime = ? WHERE lid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DSUtil ds = new DSUtil();
		try {
			ps = conn.prepareStatement(sql);
			String date = ds.dateToString(lessee.getLaddTime());
			ps.setString(1, lessee.getLname());
			ps.setString(2, lessee.getLtel());
			ps.setInt(3, lessee.getLsex());
			ps.setString(4, lessee.getLnp());
			ps.setString(5, lessee.getLidCard());
			ps.setString(6, date);
			ps.setInt(7, lessee.getLid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
	}
}
