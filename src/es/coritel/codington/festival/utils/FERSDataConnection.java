package es.coritel.codington.festival.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.coritel.codington.festival.exceptions.DAOException;

/**
 * HELPER class to handle DATACONNECTIVITY with FESTIVALDATABASE in MYSQL
 */
public class FERSDataConnection {

	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";

	/**
	 * Get connection
	 * 
	 * @return
	 * @throws DAOException
	 */
	public static Connection getConnection() throws DAOException {
		try {

			if (conn == null) {
				
				Class.forName(driver);
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/festivaldb", "root",
						"abcd1234");
				conn.setAutoCommit(false);
			}
			else
				if(conn.isClosed()){
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/festivaldb", "root",
							"abcd1234");
					conn.setAutoCommit(false);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Close connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void closeConnection(Connection conn) throws DAOException {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Commit connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void commit(Connection conn) throws DAOException {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Rollback connection
	 * 
	 * @param conn
	 * @throws DAOException
	 */
	public static void rollback(Connection conn) throws DAOException {

		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Close preparedStatement
	 * 
	 * @param ps
	 * @throws DAOException
	 */
	public static void closeStatement(PreparedStatement ps) throws DAOException {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close preparedStatement
	 * 
	 * @param rs
	 * @throws DAOException
	 */
	public static void closeResulSet(ResultSet rs) throws DAOException {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		FERSDataConnection.getConnection();
	}
}
