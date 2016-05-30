<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
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
<c:url value="${contextPath}/role/assign" var="actionUrl"></c:url>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
		<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<c:if test="${param.save eq true }">
						<!-- Display error message -->
						<div class="alert alert-success">
							<strong><spring:message
									code="save.success"/> </strong>
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
						<span class="panel-title pull-left"> Assign Roles to User</span> <a
									href="${contextPath}/user/all"
									class="btn btn-warning pull-right"><i
									class=" fa fa-arrow-left" aria-hidden="true"></i></a>
								<div class="clearfix"></div>
						</div>
						<div class="panel-body panel-form">
							<form:form commandName="userRoles" action="${actionUrl}"
								method="POST" class="form-horizontal add-event-form">
								<div class="row">
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">User Name</label>
										<div class="col-sm-8">
											<form:hidden path="user.id" id="hdnId" />
											<form:input path="user.username" cssClass="form-control disabled"
												id="txtName" placeholder="Name" readonly="true" />
												
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Roles</label>
										<div class="col-sm-8">
											<c:forEach items="${roles}" var="role" varStatus="loop">
											 <div class="checkbox">
											  <label>
											  		<form:checkbox path="selectedRoles" value="${role.id}" label="${role.name}" />
											  </label>
											 </div>
											</c:forEach>
											<form:errors path="selectedRoles" element="div" cssClass="my-notify-warning"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label"></label>
										<div class="col-sm-8">
											<input type="submit" name="submit" class="btn btn-success"
												value="<spring:message code="login.page.submit" />">
										</div>

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

