package com.r3sys.services;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.db.ConnectDb;
import com.r3sys.db.PojoDb;

/**
 * Servlet implementation class userRegister
 */
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
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
			int uid = 0;
			String uname = request.getParameter("uname");
			String ucity = request.getParameter("ucity");
			String ucontact = request.getParameter("ucontact");
			String uaddress = request.getParameter("uaddress");
			int upincode = Integer.parseInt(request.getParameter("upincode"));
			String uemail = request.getParameter("uemail");
			String upassword = request.getParameter("upassword");
			
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, uid);
			ps.setString(2, uname);
			ps.setString(3, ucity);
			ps.setString(4, ucontact);
			ps.setString(5, uaddress);
			ps.setInt(6, upincode);
			ps.setString(7, uemail);
			ps.setString(8, upassword);
			int i = ps.executeUpdate();
			if(i > 0)
			{
				PojoDb.setUid(uid);
				response.sendRedirect("b_userPage.html");
			}
			else
			{
				response.sendRedirect("error.html");
			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}
	}

}
