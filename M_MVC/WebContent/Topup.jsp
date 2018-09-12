<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Top_Up</title>
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
						
						<%
						if (session.getAttribute("isLogin") == "yes") {
					%>
					<li class="grid"><a href="logout.do">logout</a></li>
					<%
						} else {
					%>
					<li class="grid"><a href="list.do">Back</a></li>
					<%
						}
					%>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="login_sec">
		<div class="container">
			<h2>
		<span style="color:#ffffff"> . </span>
	</h2>
			<h2>Top up</h2>
			<div class="col-md-6 log">
				<div class="registration_form">
		
			<thead>
			<tr>
				<th>Username : </th>

			</tr>
		</thead>
		<c:forEach items="${listmem}" var="mem">
				<tr>
					<td>${mem.username}</td>
					
					</tr>
			</c:forEach>
		
   </div>
   <div class="registration_form">
		<form:form method="post" action="saveMem.do" commandName="member"
			name="form1">
			<form:hidden path="memberId" />
			<div>
  				<div>
					<label> Balance : <form:input path="balance" />
					</label>
				</div>
			<br />
   <div>
					<input type="submit" value="Save" name="Register" />
				</div>

			</div>

		</form:form>
  </div>
  </div>
  
  <div class="clearfix"></div>
	<div class="subscribe">
		<div class="container"></div>
	</div>
</body>
</html>