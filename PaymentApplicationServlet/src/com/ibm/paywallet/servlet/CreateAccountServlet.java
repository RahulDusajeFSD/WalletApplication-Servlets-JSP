package com.ibm.paywallet.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.paywallet.Dao.DaoClass;
import com.ibm.paywallet.bean.*;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
HttpSession session=request.getSession();
		
String name=request.getParameter("name");

String age=request.getParameter("age");
String contactNo=request.getParameter("contactNo");
String PIN=request.getParameter("PIN");
String Address=request.getParameter("Address");

CustomerDetails cd=new CustomerDetails(name,age,contactNo,PIN,Address);

		
		
	
	
	
	try
	{
	DaoClass dao=new DaoClass();
	dao.CreateAccount(cd,response,request,session);
	}catch(SQLException | ClassNotFoundException |ServletException e)
	{
		System.out.println(e.getMessage());
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
