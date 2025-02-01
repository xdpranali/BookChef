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
import com.r3sys.db.PojoDb;

/**
 * Servlet implementation class userLogin
 */
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
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
			
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("select * from user where uemail=? and upassword=?");
			ps.setString(1, uemail);
			ps.setString(2, upassword);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int uid=rs.getInt(1);
				PojoDb.setUid(uid);
				response.sendRedirect("b_userPage.html");
			}
			else
			{
				response.sendRedirect("b_error.jsp");
			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}
	}

}











