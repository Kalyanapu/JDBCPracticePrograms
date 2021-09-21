package com.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpl implements EmployeeDAO {
	private Connection connection;
	private Statement statement;

	public EmployeeDAOImpl() {
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createTable() throws SQLException {
		String sql = "create Table Employees(EmpId NUMBER(10),sal NUMBER(10,2),Ename varchar(10))";
		statement.execute(sql);
		System.out.println("EmployeeTable created!");
	}

	@Override
	public void save(Employee employee) throws SQLException {
		String sql = "insert into Employees values(" + employee.getEmpid() + ",'" + employee.getSal() + "',"
				+ employee.getEname() + ")";
		int row = statement.executeUpdate(sql);
		System.out.println("The updated rows:" + row);
	}

	@Override
	public void update(int empid, float sal) throws SQLException {
		String sql = "update Employees set empid=" + empid + "," + "sal=" + sal + "where empid=" + empid;
		int row = statement.executeUpdate(sql);
		System.out.println("The updated rows:" + row);
	}

	@Override
	public void deleteEmp(int empid) throws SQLException {
		String sql = "delete from Employees where empid=" + empid;
		int row = statement.executeUpdate(sql);
		System.out.println("Deleted row:"+row);
	}

	@Override
	public void getEmployeeById(int empid) throws SQLException {
       String sql="select *from Employees where empid=?";
       PreparedStatement ps=connection.prepareStatement(sql);
       ps.setInt(1, empid);
       ResultSet rs=ps.executeQuery();
       while(rs.next()) {
    	   System.out.println("The empid:"+rs.getInt(1));
    	   System.out.println("The empsal:"+rs.getFloat(2));
    	   System.out.println("The empname:"+rs.getString(3));
       }
	}

	@Override
	public void getAllEmployees() throws SQLException {
		String sql="select *from Employees";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			  System.out.println(rs.getRow());
	    	   System.out.println("The empid:"+rs.getInt(1));
	    	   System.out.println("The empsal:"+rs.getFloat(2));
	    	   System.out.println("The empname:"+rs.getString(3));
	       }

	}

}
