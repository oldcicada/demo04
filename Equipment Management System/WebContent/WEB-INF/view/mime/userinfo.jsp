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
<style type="text/css">
.headpicture {
	width: 60px;
	height: 60px;
	margin: 5px;
}

.headpicture img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}
</style>
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a
					href="view/mime/portal">我的工作台</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/mime/userinfo">个人信息</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/mime/userinfo" method="post"
					enctype="multipart/form-data" class="form-horizontal">
					<div class="form-body">
						<h3 class="form-section">个人信息</h3>
						<div id="topline" class="form-group">
							<label class="col-md-3 control-label">头像：</label>
							<div class="col-md-9">
								<div class="headpicture"
									style="margin: 5px; border-radius: 50%;">
									<img id="headpicture" src="resource\img\avatar3.jpg" alt="head">
								</div>
								<input type="file" id="headSculpture" name="headSculpture">
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">用户名：<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="username"
									value="${employee.login_name }" placeholder="请输入用户名" /> <span
									class="help-block"> 用户登录名 ，数字字母组成长度在5-20之间</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">邮箱：</label>
							<div class="col-md-4">
								<input type="email" class="form-control" name="email"
									value="${employee.email }" placeholder="请输入Email"> <span
									class="help-block"> 请输入正确的邮箱，可以用来找回密码使用 </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">性别：</label>
							<div class="col-md-9">
								<div class="radio-list">
									<c:if test="${employee.sex=='1'}">
										<label class="radio-inline"> 
										<input type="radio"
											name="sex" value="1" checked="checked">男
										</label>
									</c:if>
									<c:if test="${employee.sex=='0'}">
										<label class="radio-inline"> 
										<input type="radio" name="sex" checked="checked">女
										</label>
									</c:if>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">角色：</label>
							<div class="col-md-9">
								<div class="checkbox-list">
									<div class="checker disabled" id="uniform-inlineCheckbox21">
										<span class="checked"> <input type="checkbox"
											id="inlineCheckbox21" value="option1" checked="checked"
											disabled="disabled">
										</span><label class="checkbox-inline"> 超级管理员 </label>
									</div>
									<div class="checker disabled" id="uniform-inlineCheckbox22">
										<span> <input type="checkbox" id="inlineCheckbox22"
											value="option2" disabled="disabled">
										</span><label class="checkbox-inline"> 管理员 </label>
									</div>
									<div class="checker disabled disabled"
										id="uniform-inlineCheckbox23">
										<span> <input type="checkbox" id="inlineCheckbox23"
											value="option3" disabled="disabled">
										</span><label class="checkbox-inline"> 维修人员 </label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-primary blue">修改信息</button>
							</div>
						</div>
					</div>
				</form>
				<!-- END FORM-->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
</body>
</html>