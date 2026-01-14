package com.sist.db;

import java.util.*;
import java.sql.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, "hr", "happy");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void disConnection() {
		try {
			if(ps != null) {
				ps.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<EmpVO> empAllData() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql = "SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') AS dbday "
					+ "FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				// <resultMap>
				EmpVO vo = new EmpVO(); // <select resultType="EmpVO">
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDbday(rs.getString(5));
				
				list.add(vo);
			}
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return list;
	}
}
