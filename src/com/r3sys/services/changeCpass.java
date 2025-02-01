package com.r3sys.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.db.ConnectDb;

/**
 * Servlet implementation class changeCpass
 */
public class changeCpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeCpass() {
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
			String npassword = request.getParameter("npassword");
			Connection con = ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("update chef set cpassword=? where cemail=? and cpassword=?");
			ps.setString(1, npassword);
			ps.setString(2, cemail);
			ps.setString(3, cpassword);
			int i = ps.executeUpdate();
			
			if(i > 0)
			{
				response.sendRedirect("b_changeCpass.html");
			}
			else
			{
				response.sendRedirect("b_Cerror.html");
			}
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}
	}

}
