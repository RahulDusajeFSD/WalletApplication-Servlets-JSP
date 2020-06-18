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

@WebServlet("/TransferFund")
public class TransferFund extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String amountTransfer=request.getParameter("transferAmount");
		String Cno=request.getParameter("transferCNo");
		
		int p=Integer.parseInt(amountTransfer);
		CustomerDetails cd=new CustomerDetails(p,Cno);
		
	

	
	try
	{
		DaoClass dao=new DaoClass();
		dao.TransferFund(cd,response,request);
	}
	catch(SQLException | IOException |ClassNotFoundException|ServletException e)
	{
		System.out.println(e.getMessage());
	}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
