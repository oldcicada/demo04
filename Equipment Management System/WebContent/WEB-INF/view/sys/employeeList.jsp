<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a href="#">系统管理</a>
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/employeeList">员工管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a href="view/sys/employeeList"> 员工列表 </a></li>
			<li><a href="view/sys/employeeForm"> 新增员工 </a></li>
		</ul>
		<div class="row">
			<div class="col-md-12">
				<form method="post" action="view/sys/employeeList"
					style="margin: 20px;">
					<table>
						<tr>
							<td style="text-align: right; padding: 10px;"><label
								class="control-label">登录名：</label></td>
							<td><input type="text" class="form-control" name="username"
								placeholder="请输入用户名" /></td>
							<td style="text-align: right; padding: 10px;">姓名：</td>
							<td><input type="text" class="form-control" name="nickname"
								placeholder="请输入员工姓名" /></td>
							<td style="text-align: right; padding: 10px;"></td>
							<td>
								<button type="submit" class="btn btn-primary blue">
									<i class="glyphicon glyphicon-search"></i>查询
								</button>
								<button type="reset" class="btn btn-default blue">
									<i class="glyphicon glyphicon-refresh"></i>重置
								</button>
								${error}
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-scrollable alltable">
				<table
					class="table table-striped table-bordered table-hover dataTable no-footer">
					<thead>
						<tr>
							<th class="text-center">编号</th>
							<th class="text-center">姓名</th>
							<th class="text-center">登录名</th>
							<th class="text-center">邮箱</th>
							<th class="text-center">性别</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
				<c:forEach varStatus="st" items="${employees }" var="emp">
						<tr>
							<td>${st.index+1 }</td>
							<td>${emp.nickname }</td>
							<td>${emp.username }</td>
							<td>${emp.email }</td>
							<td>${emp.sex }</td>
							<td class="text-center"><a href="view/sys/employeeForm?&{emp.id}">编辑</a> <a href="#">删除</a>
								<a href="#">密码重置</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5 col-sm-12">
			<div class="dataTables_info" style="padding-top: 8px;" role="status"
				aria-live="polite">显示 1 到 10 共 25 记录</div>
		</div>
		<div class="col-md-7 col-sm-12">
			<div style="float: right; margin: 0px; height: 40px;"
				id="sample_1_paginate">
				<ul class="pagination" style="visibility: visible;">
					<li class="prev disabled"><a href="#" title="首页"><i
							class="glyphicon glyphicon-menu-left"></i></a></li>
					<li class="prev disabled"><a href="#" title="上一页"><i
							class="glyphicon glyphicon-menu-left"></i><i
							class="glyphicon glyphicon-menu-left"></i></a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li class="next"><a href="#" title="下一页"><i
							class="glyphicon glyphicon-menu-right"></i></a></li>
					<li class="next"><a href="#" title="尾页"><i
							class="glyphicon glyphicon-menu-right"></i><i
							class="glyphicon glyphicon-menu-right"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>