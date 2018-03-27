<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resource\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource\css\common.css" />
</head>
<body>
	<div class="page-container">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-bookmark"></i><a
					href="view/about">关于本网站</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
			</ul>
		</div>
		<div class="form-actions"></div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<div class="table-scrollable">
					<table
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead>
							<tr>
								<th class="text-center">编号</th>
								<th class="text-center">IP地址</th>
								<th class="text-center">次数</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${map }" var="map" varStatus="st">
								<tr>
									<td>${st.index+1}</td>
									<td>${map.key}</td>
									<td>${map.value}</td>
									<td class="text-center"><a href="#">编辑</a> <a href="#">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="form-actions"></div>
	</div>
</body>
</html>