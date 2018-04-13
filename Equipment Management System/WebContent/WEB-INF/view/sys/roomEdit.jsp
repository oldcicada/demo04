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
			<li class="active"><a> 办公地修改 </a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/sys/roomEdit" method="post"
					class="form-horizontal">
					<div class="form-body">
					<input type="hidden"  name="id" value="${room.id}" class="form-control"/>
						<div class="form-group">
							<label class="control-label col-md-3">详细地址：</label>
							<div class="col-md-4">
								<textarea class="form-control" name="address">${room.address}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">房间号：</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" name="number"
										placeholder="请输入房间号" value="${room.number}">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">房间类型：</label>
							<div class="col-md-4">
								<select class="form-control" name="type">
									<c:forEach items="${roomTypes}" var="type">
										<c:choose>
											<c:when test="${room.type == type.value}">
												<option value="${type.value}" selected="selected">${type.tag}</option>
											</c:when>
											<c:otherwise>
												<option value="${type.value}">${type.tag}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">联系人：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="linker"
									placeholder="请输入联系人姓名" value="${room.linker}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">联系电话：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="phone"
									placeholder="请输入联系人电话号码" value="${room.phone }" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">状态：</label>
							<div class="col-md-4">
								<c:forEach items="${roomStates}" var="state">
									<c:choose>
										<c:when test="${room.state == state.value}">
											<input type="radio" name="state" value="${state.value}"
												checked="checked">${state.tag}
									</c:when>
										<c:otherwise>
											<input type="radio" name="state" value="${state.value}">${state.tag}
									</c:otherwise>
									</c:choose>
								</c:forEach>
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