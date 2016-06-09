<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/pagination"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>Assign Role</title>
</head>
<body>
	<c:url value="${contextPath}/project/users/${pu.projectId}" var="actionUrl"></c:url>
	<c:set var="actionClass" value="projectUsers" scope="page"></c:set>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<c:if test="${param.save eq true }">
						<!-- Display error message -->
						<div class="alert alert-success">
							<strong><spring:message code="save.success" /> </strong>
							<spring:message code="save.success.message" />
						</div>
					</c:if>
				</div>
				<div class="col-lg-2"></div>
			</div>
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading panel-heading-blue">
							<span class="panel-title pull-left"> Assign Users to <b>${pu.projectName}</b></span>
							<a href="${contextPath}/project/all"
								class="btn btn-warning pull-right"><i
								class=" fa fa-arrow-left" aria-hidden="true"></i></a>
							<div class="clearfix"></div>
						</div>
						<div class="panel-body panel-form">
							<form:form commandName="pu" action="${actionUrl}" method="POST"
								class="form-horizontal project-users-form">
								<form:hidden path="projectId" id="hdnId" />
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<div class="col-sm-4">
												<form:hidden path="page" id="hdnPage" />
												<form:hidden path="size" id="hdnSize" />
												<form:input path="username" cssClass="form-control" id="txtUserName"
													placeholder="Name" />
											</div>
											<div class="col-sm-4">
												
											</div>
											<div class="col-sm-4">
												<input type="submit" class="btn btn-success pull-right" value="Filter" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<table class="table table-condensed table-hover"
											id="all-projects">
											<thead>
												<tr>
													<th class="col-md-3">Name</th>
													<th class="col-md-3">Username</th>
													<th class="col-md-4">Email</th>
													<th class="col-md-2">&nbsp;</th>
												</tr>
											</thead>
											<tfoot>
												<tr>
													<td colspan="5">
														<!-- Pagination Bar --> <pagination:pagination actionClass="${actionClass}"
															page="${page}" />
													</td>
												</tr>

											</tfoot>
											<tbody>
												<c:forEach items="${page.content}" var="user">
													<tr>
														<td>${user.name}</td>
														<td>${user.username}</td>
														<td>${user.email}</td>
														<td>
															<div class="btn-group">
															<a href="${contextPath}/project/users/${project.id}"
															class="btn btn-primary" title="View"><span
															class="hidden-xs"> Add</span></a>
															</div>
														</td>
													</tr>
												</c:forEach>
											</tbody>

										</table>

									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="col-lg-2"></div>
			</div>
		</div>

	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>

