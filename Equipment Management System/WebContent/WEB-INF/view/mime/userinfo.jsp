<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/base.jsp" %>
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
					href="view/mime/portal"> 我的工作台</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/mime/userinfo"> 个人信息</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/mime/userinfo" method="post"
					 class="form-horizontal">
					<div class="form-body">
						<h3 class="form-section">个人信息</h3>
							<input type="hidden" name="id" value="${user.id }"/> 
						<div id="topline" class="form-group">
							<label class="col-md-3 control-label">头 &nbsp;&nbsp;像：</label>
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
							<label class="control-label col-md-3">用户名：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="login_name"
									value="${user.login_name }" placeholder="请输入用户名" /> <span
									class="help-block"> 用户登录名 ，数字字母组成长度在5-20之间</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">姓名：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name"
									value="${user.name }" placeholder="请输入姓名" /> 
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">邮&nbsp;&nbsp;箱：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="email"
									value="${user.email }" placeholder="请输入Email"> <span
									class="help-block"> 请输入正确的邮箱，可以用来找回密码使用 </span> 
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">电&nbsp;&nbsp;话：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="phone"
									value="${user.phone }" placeholder="请输入手机号"> 
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
							<label class="col-md-3 control-label">角 &nbsp;&nbsp;色：</label>
							<input type="hidden" id="roleId" value="${role_id}" id="sexvalue">
							<div class="col-md-9">
								<div class="checkbox-list" style="padding:8px">
								<c:forEach items="${roleList}" var="role">
										<input type="checkbox" name="role"  value="${role.id}" disabled="disabled">${role.name}
									</c:forEach>
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
	<script type="text/javascript">
		var sexValue=$('#sexvalue').val();
		$("input[name=sex]").each(function(){
			if($(this).val() == sexValue){
				$(this).attr("checked","checked");
			}
		});
		var roleValue=$('#roleId').val();
		$("input[name=role]").each(function(){
			if($(this).val() == roleValue){
				$(this).attr("checked","checked");
			}
		});
	</script>
</body>
</html>