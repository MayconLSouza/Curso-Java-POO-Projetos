package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE (DepartmentId = ?)"
					);
			
			ps.setDouble(1, 200.00);
			ps.setInt(2, 2);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println(rowsAffected + " row(s) affected.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}

	}

}
