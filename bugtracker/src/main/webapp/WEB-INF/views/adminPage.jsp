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
<title>Admin</title>
</head>
<body>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-lg-6">

					<div class="span6">
						<div class="panel panel-default">
							<div class="panel-heading panel-heading-blue">
								<span class="panel-title pull-left">
									All Projects
	            				</span>
								 <a href="${contextPath}/project" class="btn btn-default pull-right"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>
								<div class="clearfix"></div>
							</div>
							<div class="panel-body">
								<div class="card">
									<div class="card-body m-t-0">
										<table class="table table-condensed table-hover table-striped">
											<thead>
												<tr>
													<th>#</th>
													<th>Project Name</th>
													<th>Start Date</th>
													<th>Target End Date</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${projects}" var="project">
													<tr>
														<td class="f-500 c-cyan">${project.id}</td>
														<td>${project.name}</td>
														<td class="f-500 c-cyan"><fmt:formatDate
																pattern="yyyy-MM-dd" value="${project.startDate}" /></td>
														<td class="f-500 c-cyan"><fmt:formatDate
																pattern="yyyy-MM-dd" value="${project.targetEndDate}" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>

								</div>

							</div>
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