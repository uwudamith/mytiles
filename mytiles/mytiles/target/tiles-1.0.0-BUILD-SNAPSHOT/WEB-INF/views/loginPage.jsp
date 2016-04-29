<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false"%>
<master:root />
<html>
<header:header/>
<c:set var="actionUrl" value="/login" ></c:set>

<body>
	<div class="container container-table">
		<div class="row vertical-center-row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="error-area">
					<spring:hasBindErrors name="loginForm">
						<div class="formerror">
							<ul>
								<c:forEach var="error" items="${errors.allErrors}">
									<li>${error.defaultMessage}</li>
								</c:forEach>
							</ul>
						</div>
					</spring:hasBindErrors>
				</div>
				<div class="login-area">
					<form name='f' action="j_spring_security_check" method='POST'>
						<table>
							<tr>
								<td>User:</td>
								<td><input type='text' name='username' value=''></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type='password' name='password' /></td>
							</tr>
							<tr>
								<td><input name="submit" type="submit" value="submit" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
	
	<footer:footer/>
</body>
</html>
