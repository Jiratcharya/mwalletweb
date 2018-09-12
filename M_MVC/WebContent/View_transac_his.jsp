<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Transaction history</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>

<!--//theme style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<!-- /start menu -->
</head>
<body>
<!--header-->
	<script src="js/responsiveslides.min.js"></script>
	<script>  
    $(function () {
      $("#slider").responsiveSlides({
      	auto: false,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: false,
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
					<li class="grid"><a href="index.jsp">Home</a></li>
					<li class="grid"><a>Member</a>
						<div class="mepanel">
						<div class="row">
								<div class="col1 me-one">
									<ul>
										<li><a href="mem_regis.jsp">Register new member </a></li>
										<li><a href="mem_edit.jsp">View Member</a></li>
										<li><a href="Viewtopup.do">View history top-up</a></li>
									</ul>
								</div>
								</div>
						</div>
					</li>
					<li class="grid"><a>View transaction</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<ul>
										<li><a href="transac_permonth.jsp">Per months</a></li>
									</ul>
								</div>
							</div>
						</div></li>
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
	
	
	
	
	
	
	<!---->
<div class="subscribe">
		<div class="container">
		</div>
	</div>

	<!---->
</body>
</html>