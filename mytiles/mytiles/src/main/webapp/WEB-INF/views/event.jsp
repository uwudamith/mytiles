<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>${title}</title>
</head>
<body>
	<c:url value="${contextPath}/event" var="actionUrl"></c:url>
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
						<div class="panel-heading">Add New Event</div>
						<div class="panel-body panel-form">
							<form:form commandName="event" action="${actionUrl}"
								method="POST" class="form-horizontal add-event-form">
								<div class="row">
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Title</label>
										<div class="col-sm-10">
											<form:input path="title" cssClass="form-control"
												id="txtTitle" placeholder="Title" />
											<form:errors path="title"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-sm-2 control-label">Description</label>
										<div class="col-sm-10">

											<form:textarea path="description" placeholder="Description"
												id="txtDescription" class="form-control" rows="3"></form:textarea>
											<form:errors path="description"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Date</label>
										<div class="col-sm-10">
											<div class="input-group date">
												<form:input path="date" type="text" class="form-control"
													placeholder="Date" />
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-th"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label"></label>
										<div class="col-sm-10">
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