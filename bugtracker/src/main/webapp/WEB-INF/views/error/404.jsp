<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<html>
<head>
<header:header />
</head>
<body>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4 error-code">
					<h1>404</h1>
				</div>
				<div class="col-lg-4"></div>
			</div>
			<div class="row">
				<div class="col-lg-4"></div>
				<div class="col-lg-4 error-code">
					<a href="${contextPath}/"><h2>GO TO HOME</h2></a>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>
	</div>

	<footer:footer />
</body>
</html>
