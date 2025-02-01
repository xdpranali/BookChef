package com.r3sys.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.db.ConnectDb;
import com.r3sys.db.PojoDb;

/**
 * Servlet implementation class b_bookChef
 */
public class b_bookChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public b_bookChef() {
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
			int bid = 0; 
			int cid = Integer.parseInt(request.getParameter("cid"));
			int uid = PojoDb.getUid();
			String bookingDetails = request.getParameter("bookingDetails");
			System.out.println(bookingDetails);
			String bookingDate = request.getParameter("bookingDate");
			String bookingTime = request.getParameter("bookingTime");
			String bstatus = "Pending";
			Connection con =  ConnectDb.dbCon();
			PreparedStatement ps = con.prepareStatement("insert into bookings values(?,?,?,?,?,?,?)");
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			ps.setString(4, bookingDetails);
			ps.setString(5, bookingDate);
			ps.setString(6, bookingTime);
			ps.setString(7, bstatus);
			int i  = ps.executeUpdate();
			if(i > 0)
			{	 
				response.sendRedirect("b_Chefbooked.jsp");
			}
			else
			{
				response.sendRedirect("b_Uerror.html");
			}
	} 
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println(e);
	}
	}

}
