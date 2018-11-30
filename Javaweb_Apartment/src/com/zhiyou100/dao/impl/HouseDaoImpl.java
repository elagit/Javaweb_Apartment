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

import com.zhiyou100.dao.HouseDao;
import com.zhiyou100.model.House;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.PageUtil;

public class HouseDaoImpl implements HouseDao {


	//查询全部的房子信息
	
	
	
	@Override
	public List<House> findAll(PageUtil page,String searchContent,String filed) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<House> houses = new ArrayList<>();
		String sqlInit = "SELECT * from house WHERE hstatus = 1";
		StringBuilder sb = new StringBuilder(sqlInit);
		try {
			if(searchContent == "") {
				 sb.append(" limit ?,?");
				 ps = conn.prepareStatement(sb.toString());
				 ps.setInt(1, page.getStart());
				 ps.setInt(2, page.getEnd());
				 rs = ps.executeQuery();
			}else {
				 sb.append(" AND haddress LIKE ? " + " limit ?,?");
				 ps = conn.prepareStatement(sb.toString());
				 ps.setString(1, "%" + searchContent + "%");
				 ps.setInt(2, page.getStart());
				 ps.setInt(3, page.getEnd());
				 rs = ps.executeQuery();
			}
			while(rs.next()){
			     House house = new House();
			     house.setHaddress(rs.getString("haddress"));
			     house.setHaddTime(rs.getDate("haddTime"));
			     house.setHupdateTime(rs.getDate("hupdateTime"));
			     house.setHair(rs.getInt("hair"));
			     house.setHarea(rs.getString("harea"));
			     house.setHdeco(rs.getInt("hdeco"));
			     house.setHdir(rs.getString("hdir"));
			     house.setHfloor(rs.getString("hfloor"));
			     house.setHid(rs.getInt("hid"));
			     house.setHimage(rs.getString("himage"));
			     house.setHprice(rs.getDouble("hprice"));
			     house.setHrentStatus(rs.getInt("hrentStatus"));
			     house.setHroomNum(rs.getInt("hroomNum"));
			     houses.add(house);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		return houses;
	}

	@Override
	public House findHouseDetailAll(int hid) {
		House house = new House();
		Connection conn = C3P0Util.getConnection();
		String sql = "select * from house where hid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hid);
			rs = ps.executeQuery();
			if(rs.next()) {
				 house.setHaddress(rs.getString("haddress"));
			     house.setHaddTime(rs.getDate("haddTime"));
			     house.setHair(rs.getInt("hair"));
			     house.setHarea(rs.getString("harea"));
			     house.setHdeco(rs.getInt("hdeco"));
			     house.setHdir(rs.getString("hdir"));
			     house.setHfloor(rs.getString("hfloor"));
			     house.setHimage(rs.getString("himage"));
			     house.setHprice(rs.getDouble("hprice"));
			     house.setHrentStatus(rs.getInt("hrentStatus"));
			     house.setHroomNum(rs.getInt("hroomNum"));
			     house.setHupdateTime(rs.getDate("hupdateTime"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
		return house;
	}

	@Override
	public void updateHouse(House house) {
		Connection conn = C3P0Util.getConnection();
		String sql = "UPDATE house set haddress = ?,hfloor = ?,hroomNum = ?,harea = ?,hdir = ?,hdeco = ?, hair = ?,hprice = ?,hrentStatus = ?,hupdateTime = ? WHERE hid = ?" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, house.getHaddress());
			ps.setString(2, house.getHfloor());
			ps.setInt(3, house.getHroomNum());
			ps.setString(4, house.getHarea());
			ps.setString(5, house.getHdir());
			ps.setInt(6, house.getHdeco());
			ps.setInt(7, house.getHair());
			ps.setDouble(8, house.getHprice());
			ps.setInt(9, house.getHrentStatus());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateUpdate = sdf.format(house.getHupdateTime());
			ps.setString(10, dateUpdate);
			ps.setInt(11, house.getHid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		
	}

	@Override
	public void insertHouse(House house) {
		Connection conn = C3P0Util.getConnection();
		String sql = "INSERT into house (haddress,hfloor,hroomNum,harea,hdir,hdeco,hair,hprice,hrentStatus,himage,hupdateTime,haddTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, house.getHaddress());
			ps.setString(2, house.getHfloor());
			ps.setInt(3, house.getHroomNum());
			ps.setString(4, house.getHarea());
			ps.setString(5, house.getHdir());
			ps.setInt(6, house.getHdeco());
			ps.setInt(7, house.getHair());
			ps.setDouble(8, house.getHprice());
			ps.setInt(9, house.getHrentStatus());
			ps.setString(10, null);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateUpdate = sdf.format(house.getHupdateTime());
			String dateAdd = sdf.format(house.getHaddTime());
			
			ps.setString(11, dateAdd);
			ps.setString(12, dateUpdate);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
	}

	@Override
	public int count(String searchContent,String filed) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		String sqlInit = "select count(hid) as total from house WHERE hstatus = 1";
		ResultSet rs = null;
		int total = 0;
		StringBuilder sb = new StringBuilder(sqlInit);
		if(!"".equals(searchContent) && !"".equals(filed)) {
			sb.append(" AND " + filed + " like " + "'%" + searchContent + "%'");
		}
		try {
			ps = conn.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		
		return total;
	}

	

}
