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
<title>Dashboard</title>
</head>
<body>
	<header:nav></header:nav>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="col-lg-6">

					<div class="span6">
						<div class="panel panel-default">
							<div class="panel-heading">Bugs Summary</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-6">
										<div class="panel panel-default">
											<div class="panel-body bug-new">
											<h2>230</h2>
											<span>New</span>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="panel panel-default">
											<div class="panel-body bug-current">
											<h2>450</h2>
											<span>Working on</span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6">
										<div class="panel panel-default">
											<div class="panel-body bug-fixed">
											<h2>22</h2>
											<span>Fixed</span>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="panel panel-default">
											<div class="panel-body bug-duplicate">
											<h2>8</h2>
											<span>Duplicate</span>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="span6">
						<div class="panel panel-default">
							<div class="panel-heading">Event Types</div>
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
				</div>
				<div class="col-lg-6">
					<div class="span12">
						<div class="panel panel-default">
							<div class="panel-heading">History</div>
							<div class="panel-body">
								<div class="card">
									<div class="card-body m-t-0">
										<table class="table table-inner table-vmiddle">
											<thead>
												<tr>
													<th>ID</th>
													<th>Name</th>
													<th style="width: 60px">Price</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td class="f-500 c-cyan">2569</td>
													<td>Samsung Galaxy Mega</td>
													<td class="f-500 c-cyan">$521</td>
												</tr>
												<tr>
													<td class="f-500 c-cyan">9658</td>
													<td>Huawei Ascend P6</td>
													<td class="f-500 c-cyan">$440</td>
												</tr>
												<tr>
													<td class="f-500 c-cyan">1101</td>
													<td>HTC One M8</td>
													<td class="f-500 c-cyan">$680</td>
												</tr>
												<tr>
													<td class="f-500 c-cyan">6598</td>
													<td>Samsung Galaxy Alpha</td>
													<td class="f-500 c-cyan">$870</td>
												</tr>
												<tr>
													<td class="f-500 c-cyan">4562</td>
													<td>LG G3</td>
													<td class="f-500 c-cyan">$690</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div id="recent-items-chart" class="flot-chart"
										style="padding: 0px; position: relative;">
										<canvas class="flot-base" width="574" height="150"
											style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 574px; height: 150px;"></canvas>
										<canvas class="flot-overlay" width="574" height="150"
											style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 574px; height: 150px;"></canvas>
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