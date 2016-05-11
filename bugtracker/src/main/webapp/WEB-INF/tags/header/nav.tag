 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
 
  <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<spring:url value="${contextPath}/"></spring:url>">Bug Tracker</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          <security:authorize access="isAuthenticated()">
            <li class="${current == 'home' ?'active':'' }"><a href="<spring:url value="${contextPath}/"></spring:url>">Home</a></li>
            </security:authorize>
           <security:authorize access="isAuthenticated()">
            <li class="${current == 'dashboard' ?'active':'' }"><a href="<spring:url value="${contextPath}/dashboard"></spring:url>">Dashboard</a></li>
            </security:authorize>
             <security:authorize access="hasRole('ROLE_ADMIN')">
            	<li><a href="<spring:url value="${contextPath}/admin" ></spring:url>">Admin</a></li>
            </security:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <security:authorize access="isAuthenticated()">
           	<li><a href="<spring:url value="${contextPath}/logout"></spring:url>">Logout</a></li>
          </security:authorize>
          <security:authorize access="! isAuthenticated()">
           	<li><a href=" <spring:url value="${contextPath}/login"></spring:url>">Login</a></li>
          </security:authorize>
           
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>