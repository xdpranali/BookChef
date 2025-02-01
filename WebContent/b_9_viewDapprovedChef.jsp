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
		int cid = Integer.parseInt(request.getParameter("cid"));
		//String cstatus = "Pending";
		Connection con = ConnectDb.dbCon();
		PreparedStatement ps = con.prepareStatement("update chef set cstatus=? where cid=?");
		ps.setString(1, "Disapproved");
		ps.setInt(2, cid);
		int i = ps.executeUpdate();
		if(i > 0)
		{
			response.sendRedirect("b_7_viewPendingChef.jsp");
		}
		else
		{
			response.sendRedirect("b_Aerror.html");
		}
	}
	catch(Exception i)
	{
		i.printStackTrace();
	}
	%>
</body>
</html>