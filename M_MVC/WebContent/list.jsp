<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mfu.entity.Member"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/Table.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>

<!--//theme style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- start menu -->
<script src="js/simpleCart.min.js">
	
</script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<!-- /start menu -->
<!-- start menu -->
<script src="js/simpleCart.min.js">
	
</script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<!-- /start menu -->
</head>
<body>
	<!--header-->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function() {
			$("#slider").responsiveSlides({
				auto : false,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				pager : false,
			});
		});
	</script>

	<div class="header-top">
		<div class="header-bottom">
			<div class="logo">
				<a href="index.jsp" id="logo"><img src="images/logo2.png"
					alt="LOGO"></a>
			</div>
			<!---->
			<div class="top-nav">
				<ul class="memenu skyblue">
					<li class="grid"><a href="regis.do">Register</a></li>
					<li class="grid"><a href="list.do">View Member</a></li>
					<li class="grid"><a href="findtopup.do">Top-Up</a></li>
							<%
						if (session.getAttribute("isLogin") == "yes") {
					%>
					<li class="grid"><a href="logout.do">logout</a></li>
					<%
						} else {
					%>
					<li class="grid"><a href="Login.do">login</a></li>
					<%
						}
					%>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>

	<!---->
<div>
	<table class="heavyTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>firstname</th>
				<th>lastname</th>
				<th>balance</th>
				<th>pin_code</th>
				<th>username</th>
				<th>password</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listmem}" var="mem">
				<tr>
					<td>${mem.memberId}</td>
					<td>${mem.firstname}</td>
					<td>${mem.lastname}</td>
					<td>${mem.balance}</td>
					<td>${mem.pin_code}</td>
					<td>${mem.username}</td>
					<td>${mem.password}</td>

					<td><a href="memForm.do?id=${mem.memberId}">Edit</a></td>
					<td><a href="budget.do?id=${mem.memberId}">View</a></td>
					<td><a href="deleteMem.do?id=${mem.memberId}">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
	

	<!---->
</body>
</html>