<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/base.jsp"%>
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
				<li><i class="glyphicon glyphicon-home"></i> 系统管理
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/employeeList"> 员工管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a> 员工信息修改 </a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/sys/employeeEdit" method="post"
					class="form-horizontal">
					<div class="form-group">
						<input type="text" style="display: none" name="id"
							value="${user.id}" />
					</div>
					<div class="form-body">
						<div class="form-group">
							<label for="exampleInputFile" class="col-md-3 control-label">头像：</label>
							<div class="col-md-9">
								<input type="file" id="exampleInputFile">
								<p class="help-block">130:130的图片</p>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputWarning">用户名：<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="login_name"
									placeholder="请输入用户名" value="${user.login_name}" /> <span
									class="help-block"> 用户登录名 ，数字字母组成长度在5-20之间</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputError">邮箱：</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" name="email"
										placeholder="请输入Email" value="${user.email}"> <span
										class="input-group-addon"> <i class="glyphicon glyphicon-envelope"></i>
									</span>
								</div>
								<span class="help-block"> 请输入正确的邮箱，可以用来找回密码使用 </span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">姓名：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name"
									placeholder="请输入真实姓名" value="${user.name}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">手机：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="phone"
									placeholder="请输入电话号码" value="${user.phone }" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">性 &nbsp;&nbsp;别：</label>
							<input type="hidden" value="${user.sex}" id="sexvalue">
							<div class="col-md-9">
								<div style="padding:5px">
									<c:forEach items="${sexes}" var="sex">
										<input type="radio" name="sex" value="${sex.value}">${sex.tag}&nbsp;&nbsp;
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">角 &nbsp;&nbsp;色：</label> <input
								type="hidden" id="roleId" value="${role_id}" id="sexvalue">
							<div class="col-md-9">
								<div class="checkbox-list" style="padding:8px">
									<c:forEach items="${roleList}" var="role">
										<input type="checkbox" disabled="disabled"  value="${role.id}" name="role">${role.name}
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-primary blue">提交</button>
								<button type="reset" class="btn btn-default blue">
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
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
	<script type="text/javascript">
		var sexValue = $('#sexvalue').val();
		$("input[name=sex]").each(function() {
			if ($(this).val() == sexValue) {
				$(this).attr("checked", "checked");
			}
		});
		var roleValue = $('#roleId').val();
		$("input[name=role]").each(function() {
			if ($(this).val() == roleValue) {
				$(this).attr("checked", "checked");
			}
		});
	</script>
</body>
</html>