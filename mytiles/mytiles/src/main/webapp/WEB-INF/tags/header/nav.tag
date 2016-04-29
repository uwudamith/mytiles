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
          <a class="navbar-brand" href="#">My Book</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
             <security:authorize access="hasRole('ROLE_ADMIN')">
            	<li><a href="${contextPath}/admin">Admin</a></li>
            </security:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <security:authorize access="isAuthenticated()">
           	<li><a href="${contextPath}/logout">Logout</a></li>
          </security:authorize>
          <security:authorize access="! isAuthenticated()">
           	<li><a href="${contextPath}/login">Login</a></li>
          </security:authorize>
           
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>