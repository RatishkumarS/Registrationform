package com.empoyee.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empoyee.registration.dao.EmployeeDao;
import com.empoyee.registration.model.Employee;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/register")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private EmployeeDao employeeDao= new EmployeeDao();
    public Registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstName");
		String lastname=request.getParameter("lastName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		Employee e=new Employee();
		e.setFirstname(firstname);
		e.setLasttname(lastname);
		e.setUsername(username);
		e.setPassword(password);
		e.setContact(contact);
		e.setAddress(address);
		
		try {
			employeeDao.registerEmployee(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request,response);		
	}
}
