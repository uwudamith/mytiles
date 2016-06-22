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
					<c:if test="${pu.message ne null }">
						<!-- Display error message -->
						<div class="alert alert-success">
							${pu.message}
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
												<form:hidden path="removeUser" id="hdnRemoveUser" />
												<form:hidden path="addUser" id="hdnAddUser" />
												<form:hidden path="userid" id="hdnUserId" />
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
															<c:if test="${user.added eq true}">
															<button data-toggle="modal" data-target="#confirm-remove-user" data-userid="${user.id}"
															class="btn btn-danger remove-userd" title="View">
															<i class="fa fa-trash-o" title="Delete" aria-hidden="true"></i><span
															class="sr-only">Remove</span></button>
															</c:if>
															<c:if test="${user.added ne true}">
															<a href="#" data-userid="${user.id}"
															class="btn btn-success add-user" title="View">
															<i class="fa fa-plus-circle" aria-hidden="true" title="Add"></i><span
															class="sr-only">Add</span></a>
															</c:if>
															
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
		<div class="modal fade" id="confirm-remove-user" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content panel-default">

					<div class="modal-header panel-heading-yellow">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
					</div>

					<div class="modal-body">
						<p>
							You are about to remove user form selected project
						</p>
						<p>Do you want to proceed?</p>
						<p class="debug-url"></p>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
						<a class="btn btn-danger btn-ok">Delete</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>

