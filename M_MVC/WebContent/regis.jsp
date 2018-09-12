<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
</head>
<body>
<script language="javascript">
function fncSubmit(){
	
	    if(document.form1.firstname.value == "")
 	{
 		alert('Please input firstname ');
 		document.form1.firstname.focus();
 		return false;
 	}
     if(document.form1.lastname.value == "")
  	{
  		alert('Please input lastname ');
  		document.form1.lastname.focus();
  		return false;
  	}
     if(document.form1.pin_code.value == "")
   	{
   		alert('Please input pin code');
   		document.form1.pin_code.focus();
   		return false;
   	}
     if(document.form1.username.value == "")
  	{
  		alert('Please input username ');
  		document.form1.username.focus();
  		return false;
  	}
     if(document.form1.password.value == "")
   	{
   		alert('Please input password ');
   		document.form1.password.focus();
   		return false;
   	}
	}
	</script>
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

	
	<div class="container">
		<div class="registration">
			<div class="registration_left">
	<br />
	<h2>
		<span style="color:#ffffff"> . </span>
	</h2>
	<h2>
		<span> Create an account </span>
	</h2>
	<div class="registration_form">
		<form:form method="post" action="saveMem.do" commandName="member"
			name="form1">
			<form:hidden path="memberId" />
			<div>
				<div>
					<label> First Name: <form:input path="firstname" value="firstname" />
					</label>
				</div>
				<div>
					<label>Last Name: <form:input path="lastname" value="lastname"  />
					</label>
				</div>
				<div>
					<label> Pin code : <form:input path="pin_code" value="pin_code"  />
					</label>
				</div>
				<div>
					<label> User name: <form:input path="username" value="username" />
					</label>
				</div>
				<div>
					<label> password : <form:input path="password" value="password" />
					</label>
				</div>
				<div>
					<label> Balance : <form:input path="balance" />
					</label>
				</div>
				<div>
					<input type="submit" value="Save" name="Register" />
				</div>

			</div>

		</form:form>
				</div>
		</div>
	</div>
	<div class="clearfix"></div>
	</div>
	<div class="subscribe">
		<div class="container"></div>
	</div>
	<!---->
</body>
</html>