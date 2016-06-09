<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="page" required="true" type="com.bug.tracker.wrapper.PageWrapper" %>
<div class="text-center">
	<ul class="pagination pagination-centered pagination-sm">
		<c:choose>
			<c:when test="${page.firstPage}">
				<li class="disabled"><span>First</span></li>
				<li class="disabled"><span>Prev</span></li>

			</c:when>
			<c:otherwise>
				<li><a href="#" data-url="${page.url}" class="pagination-s" data-page="${1}" data-size="${page.size}">First</a></li>
				<li><a href="#" data-url="${page.url}" class="pagination-s" data-page="${page.number-1}" data-size="${page.size}">Prev</a></li>
			</c:otherwise>
		</c:choose>

		<c:forEach items="${page.items}" var="item">
			<c:if test="${page.number eq item.number}">
				<c:set var="active" value="active"></c:set>
			</c:if>
			<li class="${active}"><a href="#" data-url="${page.url}" class="pagination-s" data-page="${item.number}" data-size="${page.size}">${item.number}</a>
			</li>
			<c:remove var="active" />
		</c:forEach>
		<c:choose>
			<c:when test="${page.lastPage}">
				<li class="disabled"><span>Next</span></li>
				<li class="disabled"><span>Last</span></li>
			</c:when>
			<c:otherwise>
				<li><a href="#" data-url="${page.url}" class="pagination-s" data-page="${page.number+1}" data-size="${page.size}">Next</a></li>
				<li><a href="#" data-url="${page.url}" class="pagination-s" data-page="${page.totalPages}" data-size="${page.size}">Last</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>
