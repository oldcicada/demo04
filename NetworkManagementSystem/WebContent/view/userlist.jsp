<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i>
						<a  href="#">个人信息管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="#">用户列表</a>
					</li>
				</ul>
			</div>
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="dictList.html" >
					寝室列表 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
						<form method="post" action="#" style="margin: 20px;">
						</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">序号</th>
									<th class="text-center">姓名</th>
									<th class="text-center">学号</th>
									<th class="text-center">状态</th>
									<th class="text-center">email</th>
									<th class="text-center">性别</th>
									<th class="text-center">寝室号</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach  var="item" items="${userlist}"  varStatus="st">
								  <tr>
								    <td>${st.index+1 }</td>
								    <td>${item[0] }</td>
								    <td>${item[2] }</td>
								     <td>${item[3] }</td>
								     <td>${item[4] }</td>
								     <td>${item[5] }</td>
								     <td>${item[6] }</td>
								  </tr>
								  </c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>	
	</body>
</html>