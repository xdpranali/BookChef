package com.r3sys.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.db.ConnectDb;

/**
 * Servlet implementation class changePass
 */
public class changePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePass() {
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
			String uemail = request.getParameter("uemail");
			String upassword = request.getParameter("upassword");
			String npassword = request.getParameter("npassword");
			
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("update user set upassword=? where uemail=? and upassword=?");
			ps.setString(1, npassword);
			ps.setString(2, uemail);
			ps.setString(3, upassword);
			int i = ps.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("b_changePass.html");
			}
			else
			{
				response.sendRedirect("b_Uerror.html");
			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}
	}

}
