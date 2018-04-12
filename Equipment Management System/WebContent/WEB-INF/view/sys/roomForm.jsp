<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li><i class="glyphicon glyphicon-home"></i> <a href="#">系统管理</a>
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/roomList">办公地管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a href="view/sys/roomForm"> 新增办公地 </a></li>
			<li><a href="view/sys/roomList"> 办公地列表</a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/sys/roomForm" method="post"
					class="form-horizontal">
					<div class="form-body">
						<div class="form-group">
							<label class="control-label col-md-3">详细地址：</label>
							<div class="col-md-4">
								<textarea class="form-control" name="address"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">房间号：</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" name="number"
										placeholder="请输入房间号">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">房间类型：</label>
							<div class="col-md-4">
								<select class="form-control" name="type">
									<option value="">请选择</option>
									<c:forEach items="${roomTypes}" var="type">
										<option value="${type.value}">${type.tag}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">联系人：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="linker"
									placeholder="请输入联系人姓名" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">联系电话：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="phone"
									placeholder="请输入联系人电话号码" />
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-primary blue">提交</button>
								<button type="reset" class="btn btn-default blue ">
									<i class="glyphicon glyphicon-refresh"></i>重置信息
								</button>
							</div>
						</div>
					</div>
				</form>
				<!-- END FORM-->
			</div>
		</div>
	</div>
</body>
</html>