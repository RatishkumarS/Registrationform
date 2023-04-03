package com.empoyee.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empoyee.registration.model.Employee;
import com.mysql.cj.xdevapi.Statement;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
	String Insert_Query="Insert into employee(id,first_name,last_name,user_name,password,address,contact) "
			+ "Values(?,?,?,?,?,?,?)";
	String count_query="Select max(id) as cnt from Employee";
	
	int result=0;
	int count=0;
	Class.forName("com.mysql.jdbc.Driver");
	try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee?useSSL=false","root","**********"))
	{
		PreparedStatement preparedstatement=connection.prepareStatement(Insert_Query);
		java.sql.Statement stmt = connection.createStatement();
		ResultSet cnts=stmt.executeQuery(count_query);
		while(cnts.next())
			count=cnts.getInt("cnt");
		preparedstatement.setFloat(1, count+1);
		preparedstatement.setString(2,employee.getFirstname());
		preparedstatement.setString(3,employee.getLasttname());
		preparedstatement.setString(4,employee.getUsername());
		preparedstatement.setString(5,employee.getPassword());
		preparedstatement.setString(6,employee.getAddress());
		preparedstatement.setString(7,employee.getContact());
		
		System.out.print(preparedstatement);
		result=preparedstatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return result;
	}
}
