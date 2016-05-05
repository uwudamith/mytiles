<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach items="${events}" var="event" varStatus="loop">
	<div class="panel panel-default">
  								<div class="panel-body">
  								<h4>${event.title}</h4>
  									<p>${event.description}</p>
  								</div>
							</div>
</c:forEach>
