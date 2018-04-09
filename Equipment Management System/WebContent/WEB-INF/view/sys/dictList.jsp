<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
<%@ include file="/base.jsp" %>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="resource/css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i>
						<a  href="#">系统管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="view/sys/dictList">字典管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="view/sys/dictList" >
					字典列表 </a>
				</li>
				<li>
					<a href="view/sys/dictForm">
					新增字典 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12"> 
						<form style="margin:20px 200px" action="view/sys/dictList" method="post">
							<table>
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典分类：</label></td>
									<td>
										<input type="text" class="form-control" name="type" placeholder="字典分类"/>
									</td>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典简称：</label></td>
									<td><input type="text" class="form-control" name="tag" placeholder="请输入字典简称"/></td>
									<td style="text-align: right;padding: 10px;">
										<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>查询</button>
										<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-refresh"></i>重置</button>
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
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">字典名称</th>
									<th class="text-center">字典值</th>
									<th class="text-center">字典分类</th>
									<th class="text-center">描述</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${dictionaryList }" var="list">
								<tr>
									<td>${list.tag }</td>
									<td>${list.value }</td>
									<td>${list.type }</td>
									<td>${list.description }</td>
									<td class="text-center">
										<a href="view/sys/dictEdit?id=${list.id}">编辑</a>
										<a href="view/sys/dictDelete?id=${list.id}">删除</a>
									</td>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</body>
</html>