<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>Home Page</title>
</head>
<body>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-lg-4">
					<div class="panel panel-default">
					<div class="panel-heading">Today's Events</div>
						<div class="panel-body">

						</div>
						
					</div>
				</div>
				<div class="col-lg-8">
					<div class="panel panel-default">
					<div class="panel-heading">Upcoming events for this month</div>
						<div class="panel-body">
							
						</div>
						
					</div>
				</div>
				
			</div>
		</div>

	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>