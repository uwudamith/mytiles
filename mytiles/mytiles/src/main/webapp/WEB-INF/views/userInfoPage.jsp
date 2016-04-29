<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>${title}</title>
</head>
<body>
<header:nav></header:nav>
    <div class="container">
    <div class="content">
   <div class="row">
   	<div class="col-lg-4">
   	<div class="panel panel-default">
  <div class="panel-body">
    <spring:message code="login.page.remember.me" />
  </div>
</div>
   	</div>
   	<div class="col-lg-4">
   	<div class="panel panel-default">
  <div class="panel-body">
    Basic panel example
  </div>
</div>
   	</div>
   	<div class="col-lg-4">
   	<div class="panel panel-default">
  <div class="panel-body">
    Basic panel example
  </div>
</div>
   	</div>
   </div>
    </div>
    
    </div> <!-- /container -->
 
</body>
<footer:footer></footer:footer>
</html>