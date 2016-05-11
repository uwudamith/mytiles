<%@ page language="java" contentType="text/html"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false"%>
<master:root />
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<header:header />

<body>
	<div class="container container-table">
		<div class="row vertical-center-row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="login-area">
					<div class="panel panel-default">
						<div class="panel-heading">
							<spring:message code="login.page.header" />
						</div>
						<div class="panel-body">
							<c:if test="${not empty param.error}">
								<!-- Display error message -->
								<div class="alert alert-danger">
									<strong><spring:message
											code="login.page.invalid.error" /> </strong>
									<spring:message code="login.page.invalid.credential" />
								</div>
							</c:if>
							<c:if test="${not empty param.logout}">
								<!-- Display error message -->
								<div class="alert alert-success">
									<strong><spring:message
											code="login.page.invalid.success" /> </strong>
									<spring:message
										code="login.page.invalid.logout.success.message" />
								</div>
							</c:if>
							<form name='f' action="j_spring_security_check" method='POST'>
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="username"
											id="username"
											placeholder="<spring:message code="login.page.placeholder.username" />" />
									</div>

								</div>

								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
											type="password" class="form-control" name="password"
											id="password"
											placeholder="<spring:message code="login.page.placeholder.password" />" />
									</div>

								</div>
								<div class="checkbox">
									<input type="submit" name="submit" class="btn btn-primary"
										value="<spring:message code="login.page.submit" />"> <label>
										<input type="checkbox" /> <spring:message
											code="login.page.remember.me" />
									</label>
								</div>


							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>

	<footer:footer />
</body>
</html>
