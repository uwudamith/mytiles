<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<master:meta></master:meta>
<header:header></header:header>
<title>Time line</title>
</head>
<body>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<div class="col-lg-3">
				<div class="panel panel-default">
					<div class="panel-heading panel-heading-green">Event Types</div>
					<div class="panel-body">
						<div class="list-group">
							<form role="form">
								<div class="checkbox">
									<label><input type="checkbox">Birthday Events</label>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Parties</label>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Weddings</label>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Meetings</label>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Funerals</label>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9">

				<div class="panel panel-default">
					<div class="panel-heading panel-heading-green">Past Events</div>
					<div class="panel-body">
						<div id="jobs-container">
							<c:forEach items="${events}" var="event" varStatus="loop">
								<div class="panel panel-default">
									<div class="panel-body">
										<h4>${event.title}</h4>
										<p>${event.description}</p>
										
										 <table class="table">
                    <tbody>
                      <tr>
                        <td>Percentage</td>
                        <td>Amount</td>
                      </tr> 
                      <tr>
                        <td>38%</td>
                        <td>$0.1M</td>
                      </tr> 
                   </tbody>
                   </table>
									</div>
								</div>

							</c:forEach>
						</div>


					</div>
				</div>

			</div>

		</div>

	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>