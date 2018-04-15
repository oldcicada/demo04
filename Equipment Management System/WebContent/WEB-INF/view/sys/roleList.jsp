<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/base.jsp"%> 
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
</head>
<body>
	<div class="page-container">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> 系统管理
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/roleList"> 角色管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a href="view/sys/roleList"> 角色列表 </a></li>
			<li><a href="view/sys/roleForm"> 新增角色 </a></li>
		</ul>
		<div class="row">
			<div class="col-md-12" style="margin: 20px;">
					<table>
						<tr>
							<td style="text-align: right; padding-left: 200px"><label
								class="control-label">角色简称：</label></td>
							<td>
							<input type="text" class="form-control" name="name"
								placeholder="请输入角色名" /></td>
							<td>
								<button type="submit" id="query" class="btn btn-primary">
									<i class="glyphicon glyphicon-search"></i>查询
								</button>
								<button type="reset" id="reset" class="btn btn-default">
									<i class="glyphicon glyphicon-refresh"></i>重置
								</button>
							</td>
						</tr>
					</table>
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
					<tbody id="content">
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5 col-sm-12">
			<div id="pageMessage" style="padding:8px 20px;"
			></div>
		</div>
		<div class="col-md-7 col-sm-12">
			<div style="float: right; margin-right: 20px;"
				id="pageControl">
				<a href="javascript:void(0)" class="page" id="first">首页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="previou">上页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="next">下页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="last">末页</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/roleList.js"></script>
</body>
</html>

