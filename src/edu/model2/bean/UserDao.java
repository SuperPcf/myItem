package edu.model2.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDao {
	private DBConnection dbCon = new DBConnection();
	private Connection conn = dbCon.getConnection();

	/**
	 * 添加User
	 * 
	 * @param User
	 */

	public int addUser(User user) {

		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String addSQL = "insert into User(userName,userEmail,userKey,userAccount) values(?,?,?,?)";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, user.getUserName()); //
			pstmt.setString(2, user.getUserEmail()); //
			pstmt.setString(3, user.getUserKey());
			pstmt.setString(4, user.getUserAccount());

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
	 * 根据userId删除数据
	 * 
	 * @param
	 */
	public int deleteUser(int userId) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "delete from User where userId=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); // ֵ
			pstmt.setInt(1, userId); //
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
	 * 修改user
	 * 
	 * @param User
	 */

	public int updateUser(User user) {
		int res = 0;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "update User set userName=?,"
				+ "userEmail=?,userKey=?,userAccount=? where userId=?";
		PreparedStatement pstmt = null; //
		try {
			pstmt = conn.prepareStatement(updateSQL); // ֵ
			pstmt.setString(1, user.getUserName()); //
			pstmt.setString(2, user.getUserEmail()); //
			pstmt.setString(3, user.getUserKey());
			pstmt.setString(4, user.getUserAccount());
			pstmt.setInt(5, user.getUserId());

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
	public List<User> findAll() throws SQLException {

		List<User> users = new ArrayList<User>();
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select * from User";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();

				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setUserKey(rs.getString(4));
				user.setUserAccount(rs.getString(5));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			dbCon.closeConnection(conn);
		}
		return users;
	}

	/**
	 * 根据UserID查询
	 * 
	 * @param
	 * @return
	 */

	public User findUserById(int userId) {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from User where userID = ?";
		PreparedStatement pstmt = null; //
		User user = new User();
		try {
			pstmt = conn.prepareStatement(updateSQL); //
			pstmt.setInt(1, userId); //
			ResultSet rs = pstmt.executeQuery(); //

			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setUserKey(rs.getString(4));
				user.setUserAccount(rs.getString(5));
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
		return user;
	}
	public boolean loginDo(int userId,String password){
		
		boolean flase=false;
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select userKey from User where userID = ?";
		PreparedStatement pstmt = null; //

		//User user = new User();

		User user = new User();

		
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setInt(1, userId); //
				ResultSet rs = pstmt.executeQuery(); //

				
			


				if (rs.next()) {
					
					flase=	password.equals(rs.getString(1));
					

					
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
			
		
		
		
		return flase;
	}

	/**
	 * 判断ID是否存在
	 * 
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public boolean  idExist(int userId) throws SQLException {
		Connection conn = dbCon.getConnection(); //
		String updateSQL = "select * from User where userId = ?";
		PreparedStatement pstmt = null; //

		pstmt = conn.prepareStatement(updateSQL); //
		pstmt.setInt(1, userId); //
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
