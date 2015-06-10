package edu.model2.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Attendance Dao层
 * 
 * @author super_pcf
 * 
 */
public class AttendanceDao {
	private DBConnection dbCon = new DBConnection();
	private Connection conn = dbCon.getConnection();

	/**
	 * 添加Attendance
	 * 
	 * @param Attendance
	 */

	public int addAttendance(Attendance attendance) {

		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String addSQL = "insert into Attendance(inTime,outTime,userId) values(?,?,?)";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setDate(1, attendance.getInTime()); //
			pstmt.setDate(2, attendance.getOutTime()); //
			pstmt.setInt(3, attendance.getUserId());

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
	 * 根据AttendanceId删除数据
	 * 
	 * @param
	 */
	public int deleteAttendance(int attendanceId) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "delete from Attendance where attendanceId=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); // ֵ
			pstmt.setInt(1, attendanceId); //
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
	 * 修改Attendance
	 * 
	 * @param Attendance
	 */

	public int updateAttendance(Attendance attendance) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "update Attendance set inTime=?,"
				+ "outTime=?,userId=? where attendanceID=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); // ֵ
			pstmt.setDate(1, attendance.getInTime()); //
			pstmt.setDate(2, attendance.getOutTime()); //
			pstmt.setInt(3, attendance.getUserId());
			pstmt.setInt(4, attendance.getAttendanceID());
			

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
	 * 查询所有的Attendance
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Attendance> findAll() throws SQLException {

		List<Attendance> attendances = new ArrayList<Attendance>();
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select * from Attendance";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Attendance attendance = new Attendance();

				attendance.setAttendanceID(rs.getInt(1));
				attendance.setInTime(rs.getDate(2));
				attendance.setOutTime(rs.getDate(3));
				attendance.setUserId(rs.getInt(4));
				attendances.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			dbCon.closeConnection(conn);
		}
		return attendances;
	}

	/**
	 * 根据AttendanceID查询
	 * 
	 * @param
	 * @return
	 */

	public Attendance findAttendanceById(int attendanceId) {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from Attendance where attendanceID = ?";
		PreparedStatement pstmt = null; //
		Attendance attendance = new Attendance();
		try {
			pstmt = conn.prepareStatement(updateSQL); //
			pstmt.setInt(1, attendanceId); //
			ResultSet rs = pstmt.executeQuery(); //

			if (rs.next()) {
			
				attendance.setAttendanceID(rs.getInt(1));
				attendance.setInTime(rs.getDate(2));
				attendance.setOutTime(rs.getDate(3));
				attendance.setUserId(rs.getInt(4));
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
		return attendance;
	}

	/**
	 * 判断ID是否存在
	 * 
	 * @param attendanceId
	 * @return
	 * @throws SQLException
	 */
	public boolean idExist(int attendanceId) throws SQLException {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from Attendance where attendanceId = ?";
		PreparedStatement pstmt = null; //

		pstmt = conn.prepareStatement(updateSQL); //
		pstmt.setInt(1, attendanceId); //
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
