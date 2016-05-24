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
<title>Project</title>
</head>
<body>
<c:url value="${contextPath}/project" var="actionUrl"></c:url>
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
						<div class="panel-heading panel-heading-blue">Add New Project</div>
						<div class="panel-body panel-form">
							<form:form commandName="projectForm" action="${actionUrl}"
								method="POST" class="form-horizontal add-event-form">
								<div class="row">
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Name</label>
										<div class="col-sm-8">
											<form:hidden path="id" id="hdnId" />
											<form:input path="name" cssClass="form-control"
												id="txtName" placeholder="Name" />
												<!-- Display error message -->
												<div class="val-erros">
													<form:errors path="name"></form:errors>
												</div>
												
											
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Start Date</label>
										<div class="col-sm-8">
											<div class="input-group date">
												<form:input path="startDate" type="text" class="form-control"
													placeholder="Start Date" />
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-th"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Target End Date</label>
										<div class="col-sm-8">
											<div class="input-group date">
												<form:input path="targetEndDate" type="text" class="form-control"
													placeholder="Target End Date" />
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-th"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-4 control-label">Actual End Date</label>
										<div class="col-sm-8">
											<div class="input-group date">
												<form:input path="actualEndDate" type="text" class="form-control"
													placeholder="Actual End Date" />
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-th"></i></span>
											</div>
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

