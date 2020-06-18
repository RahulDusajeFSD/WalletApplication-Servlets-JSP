package com.ibm.paywallet.Dao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Date;

import com.ibm.paywallet.bean.CustomerDetails;

public class DaoClass {
	
	
	
	
	Connection dbCon;
	PreparedStatement pstmt; 
	PreparedStatement pstmt1; 
	PreparedStatement pstmt2;
	PreparedStatement pstmt3;
	String f;
	String balanceSession;
	
	
	
	Date date=new Date();
	
	public DaoClass() throws SQLException, ClassNotFoundException
	{
	 
	 		Class.forName("com.mysql.cj.jdbc.Driver");
		dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletservlet?serverTimezone=IST", "root", "");
	 	
	
	}
	
public void CreateAccount(CustomerDetails c, HttpServletResponse response, HttpServletRequest request,HttpSession session) throws SQLException, IOException,ServletException
{
	
	String checkPINQry="select Name from basicdetails where PIN=?";
		String insertQry = "insert into basicdetails(Name,Age,contactNo,PIN,Address) values(?,?,?,?,?)";
		String accQry="insert into balancedetails(PIN,ContactNo) values(?,?)";
		
		pstmt2=dbCon.prepareStatement(checkPINQry);
		pstmt2.setString(1, c.getPin());
		
		pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setString(1,c.getName());
			pstmt.setString(2,c.getAge());
			pstmt.setString(3, c.getContactNo());
			pstmt.setString(4, c.getPin());
			pstmt.setString(5, c.getAddress());
			
			pstmt1=dbCon.prepareStatement(accQry);
			pstmt1.setString(2, c.getContactNo());
			pstmt1.setString(1, c.getPin());
			String number=request.getParameter("contactNo");
			request.getSession().setAttribute("contactNo",number);

			
			
		ResultSet rs=pstmt2.executeQuery();
		if(rs.next()==true)
		{
			String message="Duplicate PIN... Try some other PIN";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("AccountCreation.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
				pstmt1.executeUpdate();
				pstmt.executeUpdate();
				System.out.println("User Added Successfully!!");
				response.sendRedirect("LoginServlet");   // dashboard me sign in ka option....wrna sbse pehle create account exit
				
		}
		
}

public void login(CustomerDetails c, HttpServletResponse response, HttpServletRequest request, HttpSession session) throws SQLException,IOException,ServletException
{
	

	String checkQry="select Name,PIN from basicdetails where Name=? and PIN=?";
	String uname=request.getParameter("NameServlet");	
		String pin=request.getParameter("PINServlet");
		
		
	pstmt=dbCon.prepareStatement(checkQry);
	
	pstmt.setString(1, uname);
	pstmt.setString(2,pin);
	
	ResultSet rs=pstmt.executeQuery();
		
if(rs.next()==true)
	
{
	response.sendRedirect("options.jsp");  // baaki ke options
	session.setAttribute("NameServlet", uname);
	session.setAttribute("PINServlet", pin);
	

}

else
{
	PrintWriter out=response.getWriter();
	out.println("You entered wrong Name or PIN");
	out.println();		
	RequestDispatcher dispatcher=request.getRequestDispatcher("LoginJSP.jsp");

	dispatcher.forward(request, response);
}

		
	
	
}
public void deposit(CustomerDetails c, HttpServletResponse response, HttpServletRequest request) throws IOException,SQLException
{
	
	if(request.getSession().getAttribute("PINServlet")==null)
	{
		
		response.sendRedirect("index.jsp");
		
	}
	else
	{
	
	 String gg=(String)request.getSession().getAttribute("PINServlet");
	String depositQry="update balancedetails set Balance=Balance+? where PIN=?";
	
	
	pstmt=dbCon.prepareStatement(depositQry);
	pstmt.setInt(1, c.getAmount());
	pstmt.setString(2, gg);
	pstmt.executeUpdate();
	response.sendRedirect("options.jsp");
	
	}
	
}

public void withdraw(CustomerDetails c, HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException,SQLException,ServletException
{
	if(request.getSession().getAttribute("PINServlet")==null)
	{
		
	response.sendRedirect("index.jsp");
	
	}
	else
	{
	
	 String gg=(String)request.getSession().getAttribute("PINServlet");
	 String checkQry="select Balance from balancedetails where PIN=?";
	String withdrawQry="update balancedetails set Balance=Balance-? where PIN=?";
	
	
	pstmt=dbCon.prepareStatement(checkQry);
	pstmt.setString(1,gg);
	
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
	if(rs.getInt("Balance")<1000)
	{

		
		//session.setAttribute("LowBalanceWarning", "Low Balance");
				String message="Low Blanace";
				request.setAttribute("message", message);
		RequestDispatcher dispatcher=request.getRequestDispatcher("withdraw.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("options.jsp");
	}
	else
	{
	pstmt1=dbCon.prepareStatement(withdrawQry);
	pstmt1.setInt(1, c.getAmount());
	pstmt1.setString(2, gg);
	pstmt1.executeUpdate();
	response.sendRedirect("options.jsp");
	}
	}
	
	}
	
	
	
}



public void TransferFund(CustomerDetails c, HttpServletResponse response, HttpServletRequest request) throws IOException,SQLException,ServletException
{
	if(request.getSession().getAttribute("PINServlet")==null)
	{
		
		response.sendRedirect("index.jsp");
		
	}
	else
	{
	
	 String gg=(String)request.getSession().getAttribute("PINServlet");
	 String gg1=(String)request.getSession().getAttribute("contactNo");
	 System.out.println(gg1);
	 String checkQry="select Balance from balancedetails where PIN=?";
	String withdrawQry="update balancedetails set Balance=Balance-? where ContactNo=?";
	String withdrawQry1="update balancedetails set Balance=Balance+? where ContactNo=?";
	String insertTransaction="insert into transactiontable(FromUser,ToUser,Amount,Date) values(?,?,?,?)";
	
	
	pstmt=dbCon.prepareStatement(checkQry);
	pstmt.setString(1,gg);
	
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
	if(rs.getInt("Balance")<1000)
	{
		System.out.println("Low Balance");
		
		String message="Low Blanace";
		request.setAttribute("message", message);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TransferFund.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("options.jsp");
	}
	else
	{
	pstmt1=dbCon.prepareStatement(withdrawQry);
	pstmt1.setInt(1, c.getAmount());
	pstmt1.setString(2, gg1);
	
	pstmt2=dbCon.prepareStatement(withdrawQry1);
	
	
	pstmt2.setInt(1,c.getAmount());
	pstmt2.setString(2, c.getContactNo());
	
	String d=date.toString();
	pstmt3=dbCon.prepareStatement(insertTransaction);
	pstmt3.setString(1,gg);
	pstmt3.setString(2,c.getContactNo());
	pstmt3.setInt(3,c.getAmount());
	pstmt3.setString(4,d);
	
	pstmt1.executeUpdate();
	pstmt2.executeUpdate();
	pstmt3.executeUpdate();
	response.sendRedirect("options.jsp");
	}
	}
	}
	
	}
	
	

public void printPassbook(HttpServletResponse response, HttpServletRequest request,HttpSession session) throws IOException,SQLException
{
	if(request.getSession().getAttribute("PINServlet")==null)
	{
		
		response.sendRedirect("index.jsp");
		
	}
	else
	{
		String gg=(String)request.getSession().getAttribute("PINServlet");
		//String gg1=(String)request.getSession().getAttribute("contactNo");
	String passbookQry="select * from transactiontable where FromUser=?";
	
	
	pstmt=dbCon.prepareStatement(passbookQry);

	pstmt.setString(1,gg);
	ResultSet rs =pstmt.executeQuery();
	
	while(rs.next())
	{
		f="To:"+rs.getString("ToUser")+"Amount"+rs.getInt("Amount")+"+Time:"+rs.getString("Date")+"<br>";
	}
	
	session.setAttribute("passbook", f);
	
	response.sendRedirect("printPassBook.jsp");
	}
}


public void CheckBalance(HttpServletResponse response, HttpServletRequest request,HttpSession session) throws IOException,SQLException
{
	if(request.getSession().getAttribute("PINServlet")==null)
	{
		
		response.sendRedirect("index.jsp");
		
	}
	else
	{
		String gg=(String)request.getSession().getAttribute("PINServlet");
		//String gg1=(String)request.getSession().getAttribute("contactNo");
	String checkBalanceQry="select Balance from balancedetails where PIN=?";
	
	
	pstmt=dbCon.prepareStatement(checkBalanceQry);

	pstmt.setString(1,gg);
	ResultSet rs =pstmt.executeQuery();
	
	while(rs.next())
	{
		
	balanceSession="Available Balance :"+rs.getString("Balance");
	}
	
	session.setAttribute("BalanceSession", balanceSession);
	
	response.sendRedirect("CheckBalance.jsp");
	
	}
}
}
