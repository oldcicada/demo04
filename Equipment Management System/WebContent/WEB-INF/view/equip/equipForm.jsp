<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <%@ include file="/base.jsp" %>
			<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css"/>
			<link rel="stylesheet" type="text/css" href="resource/css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i> 设备管理
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="view/equip/equipList"> 设备库管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li >
					<a href="view/equip/equipList" >
					设备列表 </a>
				</li>
				<li class="active" >
					<a href="view/equip/equipForm">
					新增设备 </a>
				</li>
			</ul>
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
							<!-- BEGIN FORM-->
			<div class="form-body">
				<form action="view/equip/equipForm" method="post"
					class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-3">设备名称：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name" placeholder="请输入设备名称"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">编码：</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" name="code"
										placeholder="请输入英文名称">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">设备类型：</label>
							<div class="col-md-4">
								<select class="form-control" name="type">
									<option value="">请选择</option>
									<c:forEach items="${equipmentTypes}" var="type">
										<option value="${type.value}">${type.tag}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">备注：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="remark"
									placeholder="请输入备注信息" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">设备状态：</label>
							<div class="col-md-4">
								<select class="form-control" name="state">
									<option value="">请选择</option>
									<c:forEach items="${equipmentStates}" var="type">
										<option value="${type.value}">${type.tag}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">所在房间：</label>
							<div class="col-md-4">
								<select class="form-control" name="room_id">
									<option value="">请选择</option>
									<c:forEach items="${roomList}" var="room">
										<option value="${room.id}">${room.number}</option>
									</c:forEach>
								</select>
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
				</div>
				<!-- END FORM-->
				</div>
			</div>
		</div>
	</body>
</html>