package com.r3sys.services;
import com.r3sys.db.*;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.db.ConnectDb;

/**
 * Servlet implementation class chefLogin
 */
public class chefLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chefLogin() {
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
			String cemail = request.getParameter("cemail");
			String cpassword = request.getParameter("cpassword");
			
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("select * from chef where (cemail=? and cpassword=?) and cstatus=?");
			ps.setString(1, cemail);
			ps.setString(2, cpassword);
			ps.setString(3, "Approved");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int cid=rs.getInt(1);
				PojoDb.setCid(cid);
				response.sendRedirect("chefPage.html");
			}
			else
			{
				response.sendRedirect("b_error.html");
			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}
	}

}











