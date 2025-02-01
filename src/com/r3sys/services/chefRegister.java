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
 * Servlet implementation class chefRegister
 */
public class chefRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chefRegister() {
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
			int cid = 0;
			String cname = request.getParameter("cname");
			String cspeciality = request.getParameter("cspeciality");
			String copenTime = request.getParameter("copenTime");
			String ccloseTime = request.getParameter("ccloseTime");
			String caddress = request.getParameter("caddress");
			String carea = request.getParameter("carea");
			String ccity = request.getParameter("ccity");
			int cpincode = Integer.parseInt(request.getParameter("cpincode"));
			String ccontact = request.getParameter("ccontact");
			String cemail = request.getParameter("cemail");
			String cpassword = request.getParameter("cpassword");
			String cstatus = "Pending";
			
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("insert into chef values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, cid);
			
			ps.setString(2, cname);
			ps.setString(3, cspeciality);
			ps.setString(4, copenTime);
			ps.setString(5, ccloseTime);
			ps.setString(6, caddress);
			ps.setString(7, carea);
			ps.setString(8, ccity);
			ps.setInt(9, cpincode);
			ps.setString(10, ccontact);
			ps.setString(11, cemail);
			ps.setString(12, cpassword);
			ps.setString(13, cstatus);
			int i = ps.executeUpdate();
			if(i > 0)
			{
				PojoDb.setCid(cid);
				response.sendRedirect("chefPage.html");
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
