package edu.model2.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * clazz Dao
 * @author super_pcf
 *
 */
public class ClazzDao {
	private DBConnection dbCon = new DBConnection();
	private Connection conn = dbCon.getConnection();

	/**
	 * 添加Clazz
	 * 
	 * @param Clazz
	 */

	public int addClazz(Clazz clazz) {

		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String addSQL = "insert into Clazz(clazzName,clazzCode) values(?,?)";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, clazz.getClazzName()); //
			pstmt.setString(2, clazz.getClazzCode()); //

			res = pstmt.executeUpdate(); //

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				pstmt.close();
				dbCon.closeConnection(conn);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
				//
		}
		return res;
	}

	/**
	 * 根据ClazzId删除数据
	 * 
	 * @param
	 */
	public int deleteClazz(int clazzId) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "delete from Clazz where clazzId=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); // ֵ
			pstmt.setInt(1, clazzId); //
			res = pstmt.executeUpdate(); //
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dbCon.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbCon.closeConnection(conn); //
		}
		return res;
	}

	/**
	 * 修改Clazz
	 * 
	 * @param Clazz
	 */

	public int updateClazz(Clazz clazz) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "update Clazz set clazzName=?,"
				+ "clazzCode=? where clazzId=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); //
			pstmt.setString(1, clazz.getClazzName()); //
			pstmt.setString(2, clazz.getClazzCode()); //
			pstmt.setInt(3, clazz.getClazzId());

			res = pstmt.executeUpdate(); //
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dbCon.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
				//
		}
		return res;
	}

	/**
	 * 查询所有的User
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Clazz> findAll() throws SQLException {

		List<Clazz> clazzs = new ArrayList<Clazz>();
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select * from Clazz";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Clazz clazz = new Clazz();

				clazz.setClazzId(rs.getInt(1));
				clazz.setClazzName(rs.getString(2));
				clazz.setClazzCode(rs.getString(3));

				clazzs.add(clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			dbCon.closeConnection(conn);
		}
		return clazzs;
	}

	/**
	 * 根据UserID查询
	 * 
	 * @param
	 * @return
	 */

	public Clazz findClazzById(int clazzId) {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from Clazz where clazzID = ?";
		PreparedStatement pstmt = null; //
		Clazz clazz = new Clazz();
		try {
			pstmt = conn.prepareStatement(updateSQL); //
			pstmt.setInt(1, clazzId); //
			ResultSet rs = pstmt.executeQuery(); //

			if (rs.next()) {

				clazz.setClazzId(rs.getInt(1));
				clazz.setClazzName(rs.getString(2));
				clazz.setClazzCode(rs.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				pstmt.close();
				dbCon.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
				//
		}
		return clazz;
	}

	/**
	 * 判断ID是否存在
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public boolean idExist(int clazzId) throws SQLException {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from Clazz where clazzId = ?";
		PreparedStatement pstmt = null; //

		pstmt = conn.prepareStatement(updateSQL); //
		pstmt.setInt(1, clazzId); //
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return true;
	}
}
