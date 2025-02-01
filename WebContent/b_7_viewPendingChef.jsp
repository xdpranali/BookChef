<%@page import="java.sql.*" %>
<%@page import="com.r3sys.db.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BookChef</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						<li>
							<a href="b_7_viewPendingChef.jsp"><i class="fa fa-check-square-o nav_icon"></i>viewPendingChef</a>
						</li>
						<li>
							<a href="b_viewApprovedChef.jsp"><i class="fa fa-table nav_icon"></i>viewApprovedChef</a>
						</li>
						<li>
							<a href="b_viewDapprovedChef.jsp"><i class="fa fa-cogs nav_icon"></i>viewDapprovedChef</a>
						</li>
						<li>
							<a href="b_viewUsers.jsp"><i class="fa fa-home nav_icon"></i>viewUsers</a>
						</li>
						<li>
							<a href="b_2_adminLogin.html"><i class="fa fa-sign-out nav_icon"></i>Logout</a>
						</li>
					</ul>
					<div class="clearfix"> </div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="b_2_adminLogin.html">
						<h1>BookChef</h1>
						<span>Dash Board</span>
					</a>
				</div>
				<!--//logo-->
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				<div class="profile_details_left"><!--notifications of menu start -->
					<div class="clearfix"> </div>
				</div>
				
				<div class="clearfix"> </div>	
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="forms">
					<h3 class="title1">View Pending chef</h3>
					<table class="table table-bordered">
						<%
						try 
						{%>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Speciality</th>
								<th>OpenTime</th>
								<th>CloseTime</th>
								<th>Address</th>
								<th>Area</th>
								<th>City</th>
								<th>Pincode</th>
								<th>Contact</th>
								<th>Email</th>
								<th>Status</th>
								<th>Action-1</th>
								<th>Action-2</th>
								
							</tr>
							<%
							
							//int cid = Integer.parseInt(request.getParameter("cid"));
							String cstatus = "Pending";
							Connection con = ConnectDb.dbCon();
							PreparedStatement ps = con.prepareStatement("select * from chef where cstatus=?");
							ps.setString(1, cstatus);
							ResultSet rs = ps.executeQuery();
							while(rs.next())
							{%>	 
								<tr>
									<td><%=rs.getInt(1) %></td>
									<td><%=rs.getString(2) %></td>
									<td><%=rs.getString(3) %></td>
									<td><%=rs.getString(4) %></td>
									<td><%=rs.getString(5) %></td>
									<td><%=rs.getString(6) %></td>
									<td><%=rs.getString(7) %></td>
									<td><%=rs.getString(8) %></td>
									<td><%=rs.getInt(9) %></td>
									<td><%=rs.getString(10) %></td>
									<td><%=rs.getString(11) %></td>
									<td><%=rs.getString(13) %></td>
									<td><a href="b_8_viewApprovedChef.jsp?cid=<%=rs.getInt(1)%>">Approved</a></td>
									<td><a href="b_9_viewDapprovedChef.jsp?cid=<%=rs.getInt(1)%>">Disapproved</a></td>
								</tr>	
							<%}
						
						} 
						catch(Exception e)
						{
							e.printStackTrace();
						}%>
					</table>
				</div>
			</div>
		</div>
		<!--footer-->
		<div class="footer">
		   <p>&copy; 2024 BookChef DashBoard. All Rights Reserved | Design by Pranali Dhangar</p>
		</div>
        <!--//footer-->
	</div>
	<!-- Classie -->
	<script src="js/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1' ),
		showLeftPush = document.getElementById( 'showLeftPush' ),
		body = document.body;
		
	showLeftPush.onclick = function() {
		classie.toggle( this, 'active' );
		classie.toggle( body, 'cbp-spmenu-push-toright' );
		classie.toggle( menuLeft, 'cbp-spmenu-open' );
		disableOther( 'showLeftPush' );
	};
	
	function disableOther( button ) {
		if( button !== 'showLeftPush' ) {
			classie.toggle( showLeftPush, 'disabled' );
		}
	}
</script>
<!--scrolling js-->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!--//scrolling js-->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.js"> </script>
</body>
</html>
