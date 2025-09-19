package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();		
			
			int rows1 = st.executeUpdate("UPDATE seller "
					+ " SET BaseSalary = 2090 "
					+ " WHERE DepartmentId = 1");
			
			boolean running = true;
			while(running) {
				throw new SQLException("Error during transaction.");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller "
					+ " SET BaseSalary = 3090 "
					+ " WHERE DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("Query 1, row(s) affected: " + rows1);
			System.out.println("Query 2, row(s) affected: " + rows2);
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
