<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
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
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a href="#">系统管理</a>
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/roleList">角色管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a href="view/sys/roleList"> 角色列表 </a></li>
			<li><a href="view/sys/roleForm"> 新增角色 </a></li>
		</ul>
		<div class="row">
			<div class="col-md-12">
				<form action="view/sys/roleList" method="post" class="form-body"
					role="form" style="margin: 20px;">
					<table style="width: 100%;">
						<tr>
							<td style="text-align: right; padding: 10px;"><label
								class="control-label">角色简称：</label></td>
							<td><input type="text" class="form-control" name="userName"
								placeholder="请输入角色名" /></td>
							<td>
								<button type="submit" class="btn btn-primary">
									<i class="glyphicon glyphicon-search"></i>查询
								</button>
								<button type="submit" class="btn btn-default">
									<i class="glyphicon glyphicon-refresh"></i>重置
								</button>
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
							<th class="text-center">角色编号</th>
							<th class="text-center">角色简称</th>
							<th class="text-center">描述</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>超级管理员</td>
							<td>管理系统的所有操作</td>
							<td class="text-center"><a href="#">编辑</a> <a href="#">删除</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

