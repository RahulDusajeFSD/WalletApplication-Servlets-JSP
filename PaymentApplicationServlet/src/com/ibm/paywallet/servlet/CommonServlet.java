package com.ibm.paywallet.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.paywallet.Dao.DaoClass;

@WebServlet("/CommonServlet")
public class CommonServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // pehle jsp pr redirect krna for getting information then redirect to createaccount servlet
		
		try
		{
		DaoClass dao=new DaoClass();
		}catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
		String rb=request.getParameter("rb");
		if(rb.contentEquals("Login"))
		{
			response.sendRedirect("LoginJSP.jsp");
		}
		else if(rb.equals("createAcc"))
		{
			response.sendRedirect("AccountCreation.jsp");   
		}
		else if(request.getSession().getAttribute("PINServlet")==null)
		{
			try
			{
			response.sendRedirect("index.jsp");
			}catch(IOException e)
			{
				e.getMessage();
			}
		}
		else
		{
		
				
				 if(rb.equals("deposit"))
				{
					response.sendRedirect("DepositJSP.jsp");   
				}
				else if(rb.equals("Logout"))
				{
					response.sendRedirect("LogoutServlet");   
				}
				
				else if(rb.equals("transferFund"))
				{
					response.sendRedirect("TransferFund.jsp");   
				}
				
				else if(rb.equals("printPassbook"))
				{
					response.sendRedirect("PrintPassbook");   
				}
				
				else if(rb.contentEquals("withdraw"))
				{
					response.sendRedirect("withdraw.jsp");
				}
				 
				else if(rb.contentEquals("CheckBalance"))
				{
					response.sendRedirect("CheckBalance");
				}
	
				
				
		}
				
				

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
