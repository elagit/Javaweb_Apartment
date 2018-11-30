package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.dao.RentDao;
import com.zhiyou100.model.Lessee;
import com.zhiyou100.model.Rent;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.DSUtil;
import com.zhiyou100.util.PageUtil;

public class RentDaoImpl implements RentDao {

	@Override
	public List<Rent> rentFindAll(PageUtil page) {
		
		List<Rent> rents = new ArrayList<>();
		
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from rent WHERE rstatus = 1 limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page.getStart());
			ps.setInt(2, page.getEnd());
			rs = ps.executeQuery();
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setRhid(rs.getInt("rhid"));
				rent.setRid(rs.getInt("rid"));
				rent.setRlid(rs.getInt("rlid"));
				rent.setRpayTime(rs.getDate("rpayTime"));
				rent.setRprice(rs.getDouble("rprice"));
				rents.add(rent);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return rents;
	}

	@Override
	public int count() {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement s = null;
		String sql = "select count(rid) as total from rent WHERE rstatus = 1";
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
	public Rent rentFindByRid(int rid) {
		Rent rent = new Rent();
		Connection conn = C3P0Util.getConnection();
		String sql = "select * from rent where rid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			rs = ps.executeQuery();
			if(rs.next()) {
				rent.setRid(rid);
				rent.setRhid(rs.getInt("rhid"));
				rent.setRlid(rs.getInt("rlid"));
				rent.setRpayTime(rs.getDate("rpayTime"));
				rent.setRprice(rs.getDouble("rprice"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return rent;
	}

	@Override
	public void rentAdd(Rent rent) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "INSERT into rent VALUES (?,?,?,?,?)";
		DSUtil ds = new DSUtil();
		String rpayTime = ds.dateToString(rent.getRpayTime());
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, null);
			ps.setInt(2, rent.getRhid());
			ps.setInt(3, rent.getRlid());
			ps.setDouble(4, rent.getRprice());
			ps.setString(5, rpayTime);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void rentUpdate(Rent rent) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "UPDATE rent set rhid = ?,rlid = ?,rprice = ?,rpaytime = ? WHERE rid = ?";
		DSUtil ds = new DSUtil();
		String rpayTime = ds.dateToString(rent.getRpayTime());
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rent.getRhid());
			ps.setInt(2, rent.getRlid());
			ps.setDouble(3, rent.getRprice());
			ps.setString(4, rpayTime);
			ps.setInt(5, rent.getRid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


