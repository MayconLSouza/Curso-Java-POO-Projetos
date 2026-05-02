package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import db.DbIntegrityException;
import model.dao.GenericDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements GenericDao<Department>{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department dep) {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO department "
					+ "(Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, dep.getName());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					dep.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DBException("Unexpected error! No rows affected after insert");
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void update(Department dep) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("UPDATE department " 
					+ "SET Name = ? WHERE Id = ?");

			ps.setString(1, dep.getName());
			ps.setInt(2, dep.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
					
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));

				return dep;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM department ORDER BY Name");

			rs = ps.executeQuery();

			List<Department> departments = new ArrayList<>();

			while (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				departments.add(dep);
			}

			return departments;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	
}
