<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>Time line</title>
</head>
<body>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<ul class="timeline">
			 <c:forEach items="${events}" var="event" varStatus="loop">
			 <c:set var="inverted" value="t" scope="request"></c:set>
			<c:choose>
				<c:when test="${loop.count eq 1 }">
					<c:set var="inverted" value="tt" scope="request"></c:set>
				</c:when>
				<c:when test="${loop.count % 2 eq 0}">
					<c:set var="inverted" value="timeline-inverted" scope="request"></c:set>
				</c:when>
				<c:otherwise>
					<c:set var="inverted" value="" scope="request"></c:set>
				</c:otherwise>
			</c:choose>
				
				<li class="${inverted}">
					<div class="timeline-badge">
						<a><i class="fa fa-circle" id=""></i></a>
					</div>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4>${event.title}</h4>
						</div>
						<div class="timeline-body">
							<p>${event.description}</p>
						</div>
						<div class="timeline-footer">
							<p class="text-right">${event.date}</p>
						</div>
					</div>
				</li>
			
			</c:forEach>

				<li class="clearfix no-float"></li>
			</ul>

		</div>

	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>