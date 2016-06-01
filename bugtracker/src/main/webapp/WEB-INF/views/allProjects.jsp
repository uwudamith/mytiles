<%@page session="false"%>
<%@ taglib prefix="master" tagdir="/WEB-INF/tags/master"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/pagination"%>
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
		<div class="col-lg-3">
		</div>
		<div class="col-lg-6">
		<c:if test="${param.delete eq true }">
						<!-- Display error message -->
						<div class="alert alert-success">
							<strong><spring:message
									code="save.success"/> </strong>
							Successfully deleted!
						</div>
					</c:if>
		</div>
		<div class="col-lg-3"></div>
		</div>
			<div class="row">
				<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading panel-heading-blue">
								<span class="panel-title pull-left"> All Projects </span> <a
									href="${contextPath}/project"
									class="btn btn-success pull-right"><i
									class="fa fa-plus-circle" aria-hidden="true"></i></a>
								<div class="clearfix"></div>
							</div>
							<div class="panel-body">
								<table class="table table-condensed table-hover"
									id="all-projects">
									<thead>
										<tr>
											<th class="col-md-1">#</th>
											<th class="col-md-3">Project Name</th>
											<th class="col-md-1">Start Date</th>
											<th class="col-md-2">Target End Date</th>
											<th class="col-md-2">Actual End Date</th>
											<th class="col-md-3">&nbsp;</th>
										</tr>
									</thead>
									<tfoot>
									<tr>
										<td colspan="6">
										<!-- Pagination Bar -->
										<pagination:pagination page="${page}"/>
										</td>
									</tr>
										
									</tfoot>
									<tbody>
										<c:forEach items="${page.content}" var="project">
											<tr>
												<td class="f-500 c-cyan">${project.id}</td>
												<td>${project.name}</td>
												<td class="f-500 c-cyan"><fmt:formatDate
														pattern="MM/dd/yyyy" value="${project.startDate}" /></td>
												<td class="f-500 c-cyan"><fmt:formatDate
														pattern="MM/dd/yyyy" value="${project.targetEndDate}" /></td>
														<td class="f-500 c-cyan"><fmt:formatDate
														pattern="MM/dd/yyyy" value="${project.actualEndDate}" /></td>
												<td>
												<div class="btn-group">
												<a href="${contextPath}/role/assign?userId=${user.id}" class="btn btn-primary" title="View"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs"> Roles</span></a>
    <a href="${contextPath}/project/view?id=${project.id}" class="btn btn-success" title="View"><i class="fa fa-eye"></i><span class="hidden-xs"> View</span></a>
    <button  data-href="${contextPath}/project/delete?id=${project.id}" data-project="${project.name}" class="btn btn-danger" title="Delete" data-toggle="modal" data-target="#confirm-delete"><i class="fa fa-times"></i><span class="hidden-xs"> Delete</span></button>
</div> 
												</td>
											</tr>
										</c:forEach>
									</tbody>
									
								</table>

							</div>
						</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content panel-default">
            
                <div class="modal-header panel-heading-red">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
            
                <div class="modal-body">
                    <p>You are about to delete project <span class="proj-name"></span> from the system</p>
                    <p>Do you want to proceed?</p>
                    <p class="debug-url"></p>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger btn-ok">Delete</a>
                </div>
            </div>
        </div>
    </div>

	</div>
	<!-- /container -->

</body>
<footer:footer></footer:footer>
</html>