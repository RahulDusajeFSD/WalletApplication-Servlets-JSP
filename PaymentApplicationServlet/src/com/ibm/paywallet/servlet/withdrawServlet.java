package com.ibm.paywallet.servlet;

import com.ibm.paywallet.Dao.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.paywallet.bean.*;
import com.mysql.cj.Session;

@WebServlet("/withdrawServlet")
public class withdrawServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session=request.getSession();
		String amountWithdraw=request.getParameter("withdrawAmount");
		
		int p=Integer.parseInt(amountWithdraw);
		CustomerDetails cd=new CustomerDetails(p);

	
	
	
	try
	{
		DaoClass dao=new DaoClass();
		dao.withdraw(cd,response,request,session);
	}
	catch(SQLException | IOException |ClassNotFoundException | ServletException e)
	{
		System.out.println(e.getMessage());
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
