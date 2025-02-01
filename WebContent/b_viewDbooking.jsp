<%@page import="java.sql.*" %>
<%@page import="com.r3sys.db.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	try
	{
		int bid = Integer.parseInt(request.getParameter("bid"));
		Connection con = ConnectDb.dbCon();
		PreparedStatement ps = con.prepareStatement("update bookings set bstatus=? where bid=?");
		ps.setString(1, "Disapproved");
		ps.setInt(2, bid);
		int i = ps.executeUpdate();
		if(i > 0)
		{
			response.sendRedirect("b_viewPendingBooking.jsp");
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
	%>
</body>
</html>