
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top navbar-custom">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="<spring:url value="${contextPath}/"></spring:url>">Bug
				Tracker</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<security:authorize access="isAuthenticated()">
					<li class="${current == 'home' ?'active':'' }"><a
						href="<spring:url value="${contextPath}/"></spring:url>">Home</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="${current == 'dashboard' ?'active':'' }"><a
						href="<spring:url value="${contextPath}/dashboard"></spring:url>">Dashboard</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="dropdown ${current == 'admin' ?'active':'' }"><a
						href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">Admin<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="${child == 'all_projects' ?'active':'' }"><a
								href="<spring:url value="${contextPath}/project/all" />">All Projects</a></li>
							<li class="${child == 'createproject' ?'active':'' }"><a
								href="<spring:url value="${contextPath}/project" />">Create
									a Project</a></li>
							<li class="${child == 'user' ?'active':'' }"><a
								href="<spring:url value="${contextPath}/user" />">Manage
									Users</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>

				</security:authorize>

			</ul>
			<%--           <ul class="nav navbar-nav navbar-right">
          <security:authorize access="isAuthenticated()">
           	<li><a href="<spring:url value="${contextPath}/logout"></spring:url>">Logout</a></li>
          </security:authorize>
          <security:authorize access="! isAuthenticated()">
           	<li><a href=" <spring:url value="${contextPath}/login"></spring:url>">Login</a></li>
          </security:authorize>
           
          </ul> --%>
			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="! isAuthenticated()">
					<li><a
						href=" <spring:url value="${contextPath}/login"></spring:url>">Login</a></li>
				</security:authorize>
				<li class="dropdown">
				<security:authorize access="isAuthenticated()">
				<security:authentication var="user" property="principal" />
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>
						<strong>${user.username}</strong> <span
						class="glyphicon glyphicon-chevron-down"></span>
				</a>
				</security:authorize>
					<ul class="dropdown-menu">
						<li>
							<div class="navbar-login">
								<div class="row">
									<div class="col-lg-4">
										<p class="text-center">
											<span class="glyphicon glyphicon-user icon-size"></span>
										</p>
									</div>
									<div class="col-lg-8">
										<p class="text-left">
											<strong>Salman Khan</strong>
										</p>
										<p class="text-left small">crazytodevelop@@gmail.com</p>
										<p class="text-left">
											<a href="#" class="btn btn-primary btn-block btn-sm">Profile</a>
										</p>
									</div>
								</div>
							</div>
						</li>
						<li class="divider navbar-login-session-bg"></li>
<!-- 						<li><a href="#">Account Settings <span
								class="glyphicon glyphicon-cog pull-right"></span></a></li>
						<li class="divider"></li>
						<li><a href="#">User stats <span
								class="glyphicon glyphicon-stats pull-right"></span></a></li>
						<li class="divider"></li>
						<li><a href="#">Messages <span class="badge pull-right">
									42 </span></a></li>
						<li class="divider"></li>
						<li><a href="#">Favourites Snippets <span
								class="glyphicon glyphicon-heart pull-right"></span></a></li>
						<li class="divider"></li> -->
						<security:authorize access="isAuthenticated()">
							<li><a
								href="<spring:url value="${contextPath}/logout"></spring:url>">Sign
									Out <span class="glyphicon glyphicon-log-out pull-right"></span>
							</a></li>
						</security:authorize>
					</ul></li>
					
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>