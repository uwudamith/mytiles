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
<title>User</title>
</head>
<body>
<c:url value="${contextPath}/user" var="actionUrl"></c:url>
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
					<c:if test="${param.update eq true }">
						<!-- Display error message -->
						<div class="alert alert-success">
							<strong><spring:message
									code="save.success"/> </strong>
							User details successfully updated
						</div>
					</c:if>
				</div>
				<div class="col-lg-2"></div>
			</div>
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading panel-heading-blue">Manage User</div>
						<div class="panel-body panel-form">
							<form:form commandName="userForm" action="${actionUrl}"
								method="POST" class="form-horizontal add-event-form">
								<div class="row">
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Name</label>
										<div class="col-sm-8">
											<form:hidden path="id" id="hdnId" />
											<form:input path="name" cssClass="form-control"
												id="txtName" placeholder="Name" />
												<!-- Display error message -->
												<form:errors path="name" element="div" cssClass="my-notify-warning"/>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Email</label>
										<div class="col-sm-8">
											<form:input path="email"  autocomplete="off" cssClass="form-control"
												id="txtEmail" placeholder="Email" />
												<!-- Display error message -->
												<form:errors path="email" element="div" cssClass="my-notify-warning"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Username</label>
										<div class="col-sm-8">
											<form:input path="username"  cssClass="form-control"
												id="txtUserName" placeholder="Username" />
												<form:errors path="username" element="div" cssClass="my-notify-warning"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Password</label>
										<div class="col-sm-8">
											<form:password path="password" cssClass="form-control"
												id="txtPassword" placeholder="Password" />
												<form:errors path="password" element="div" cssClass="my-notify-warning"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label"></label>
										<div class="col-sm-8">
											<input type="submit" name="submit" class="btn btn-primary"
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

