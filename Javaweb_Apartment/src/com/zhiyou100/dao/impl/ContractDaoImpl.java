package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhiyou100.dao.ContractDao;
import com.zhiyou100.model.Contract;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.DSUtil;
import com.zhiyou100.util.PageUtil;

public class ContractDaoImpl implements ContractDao {
	
	
	
	@Override
	public List<Contract> findContractAll(PageUtil page) {
		List<Contract> contracts = new ArrayList<>();
		ResultSet rs = null; 
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from contract WHERE cstatus = 1 limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page.getStart());
			ps.setInt(2, page.getEnd());
			rs = ps.executeQuery();
			while(rs.next()) {
				Contract contract = new Contract();
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setChid(rs.getInt("chid"));
				contract.setCid(rs.getInt("cid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setCpayType(rs.getInt("cpayType"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
				contracts.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		return contracts;
	}

	@Override
	public Contract findContractByCid(int cid) {
		Contract contract = new Contract();
		ResultSet rs = null; 
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		String sql = "select * from contract where cid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if(rs.next()) {
				contract.setCendTime(rs.getDate("cendTime"));
				contract.setChid(rs.getInt("chid"));
				contract.setClid(rs.getInt("clid"));
				contract.setCnum(rs.getString("cnum"));
				contract.setCpayType(rs.getInt("cpayType"));
				contract.setCstartTime(rs.getDate("cstartTime"));
				contract.setCtime(rs.getDate("ctime"));
				contract.setCtotalMoney(rs.getDouble("ctotalMoney"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		return contract;
	}

	@Override
	public int count() {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement s = null;
		String sql = "select count(cid) as total from contract WHERE cstatus = 1";
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
	public void contractAdd(Contract contract) {
		Connection conn = C3P0Util.getConnection();
		String sql = "INSERT into contract VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		DSUtil ds = new DSUtil();
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1,null);
			ps.setString(2, contract.getCnum());
			ps.setInt(3, contract.getChid());
			ps.setInt(4, contract.getClid());
			ps.setString(5, ds.dateToString(contract.getCtime()));
			ps.setString(6, ds.dateToString(contract.getCstartTime()));
			ps.setString(7, ds.dateToString(contract.getCendTime()));
			ps.setDouble(8, contract.getCtotalMoney());
			ps.setInt(9, contract.getCpayType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
	}

	@Override
	public void contractUpdate(Contract contract) {
		Connection conn = C3P0Util.getConnection();
		String sql = "UPDATE contract set cnum = ?,chid = ?,clid = ?,ctotalMoney = ?,cpayType = ? WHERE cid = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, contract.getCnum());
			ps.setInt(2, contract.getChid());
			ps.setInt(3, contract.getClid());
			ps.setDouble(4, contract.getCtotalMoney());
			ps.setInt(5, contract.getCpayType());
			ps.setInt(6,contract.getCid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		C3P0Util.closeAll(rs, ps, conn);
		
	}
}

