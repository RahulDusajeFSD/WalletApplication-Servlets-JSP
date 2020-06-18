package com.ibm.paywallet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.paywallet.Dao.DaoClass;
import com.ibm.paywallet.bean.CustomerDetails;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	PreparedStatement pstmt;
	Connection dbCon;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String name=request.getParameter("NameServlet");
		String PIN=request.getParameter("PINServlet");
		//response.setContentType("text/html");
		
		CustomerDetails cd=new CustomerDetails(name,PIN);
		HttpSession session=request.getSession();
		
		
		
		try
		{
			DaoClass dao=new DaoClass();
		dao.login(cd, response, request, session);
		}
		catch(SQLException | IOException |ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		// dao ka object call krna
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	} 

}
