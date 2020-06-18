package com.ibm.paywallet.servlet;

import com.ibm.paywallet.Dao.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.paywallet.bean.*;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String amountDeposit=request.getParameter("depositAmount");
		
		int p=Integer.parseInt(amountDeposit);
		CustomerDetails cd=new CustomerDetails(p);
	
	


	try
	{
		DaoClass dao=new DaoClass();
		dao.deposit(cd,response,request);
		
	}catch(SQLException | ClassNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
