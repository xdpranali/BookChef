package com.r3sys.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.r3sys.db.*;

/**
 * Servlet implementation class adminLogin
 */
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			String aemail = request.getParameter("aemail");
			String apassword = request.getParameter("apassword");
			
			Connection con = ConnectDb.dbCon();
			
			if(aemail.equals("pranali@gmail.com") && apassword.equals("2207"))
			{
				response.sendRedirect("b_7_viewPendingChef.jsp");
			}
			else
			{
				response.sendRedirect("b_2_adminLogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
