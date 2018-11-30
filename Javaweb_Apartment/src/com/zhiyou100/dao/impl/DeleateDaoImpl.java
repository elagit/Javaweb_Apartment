package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.dao.DeleateDao;
import com.zhiyou100.util.C3P0Util;
import com.zhiyou100.util.DBUtil;
import com.zhiyou100.util.SwitchUtil;

public class DeleateDaoImpl implements DeleateDao{

	@Override
	public void deleate(int caseNo,int id) {
		Connection conn = C3P0Util.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SwitchUtil su = new SwitchUtil();
		String sql = su.deleateSqlSwitch(caseNo);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		
	}

}
