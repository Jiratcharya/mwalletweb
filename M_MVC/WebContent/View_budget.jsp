<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mfu.entity.Member"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Budget </title>
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
	<form:form method="post" commandName="member" name="form1"  >
		<form:hidden path="memberId" />
			<h2>
		<span style="color:#ffffff"> . </span>
	</h2>
		<div style="height: 400px; text-align: center;">
			<img src="images/Shopicon.png" >
			<div>
			<h2>
		<span style="color:#ffffff"> . </span>
	</h2>
			<h1>
				<label>Balance : <form:input path="balance" readonly="true" /> 
				</label>
				</h1>
			</div>
			<h2>
		<span style="color:#ffffff"> . </span>
	</h2>
		</div>
	</form:form>



	<!---->
	<div class="subscribe">
		<div class="container"></div>
	</div>

	<!---->
</body>
</html>