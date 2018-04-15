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
				<li><i class="glyphicon glyphicon-home"></i> 系统管理
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/employeeForm"> 员工管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li><a href="view/sys/employeeList"> 员工列表 </a></li>
			<li class="active"><a href="view/sys/employeeForm"> 新增员工 </a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/sys/employeeForm" method="post"
					class="form-horizontal">
					<div class="form-body">
						<div class="form-group">
							<label for="exampleInputFile" class="col-md-3 control-label">头像：</label>
							<div class="col-md-9">
								<input type="file" id="exampleInputFile">
								<p class="help-block">130:130的图片</p>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputWarning">用户名：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="login_name"
									placeholder="请输入用户名" /> <span class="help-block"> 用户登录名
									，数字字母组成长度在5-20之间</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputError">邮箱：</label>
							<div class="col-md-4">

								<div class="input-group">
									<input type="text" class="form-control" name="email"
										placeholder="请输入Email"> <span
										class="input-group-addon"> <i
										class="glyphicon glyphicon-envelope"></i>
									</span>
								</div>
								<span class="help-block"> 请输入正确的邮箱，可以用来找回密码使用 </span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">姓名：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name"
									placeholder="请输入真实姓名" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">密码：</label>
							<div class="col-md-4">
								<input type="password" class="form-control" name="password"
									placeholder="请输入密码" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">员工号：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="number"
									placeholder="请输入员工号" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">手机：</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="phone"
									placeholder="请输入电话号码" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputSuccess">描述：</label>
							<div class="col-md-4">
								<textarea  class="form-control" rows="3" name="description">
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">性别：</label>
							<div class="col-md-9">
								<div class="radio-list">
									<c:forEach items="${sexes}" var="sex">
										<c:choose>
											<c:when test="${sex.value ==0}">
												<label class="radio-inline"> <input type="radio"
													name="sex" value="${sex.value }" checked="checked">
													${sex.tag }
												</label>
											</c:when>
											<c:otherwise>
												<label class="radio-inline"> <input type="radio"
													name="sex" value="${sex.value }"> ${sex.tag }
												</label>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">角色：</label>
							<div class="col-md-9">
								<div class="radio-list">
									<c:forEach  items="${roleList}" var="role">
										<c:choose>
											<c:when test="${role.id ==1}">
												<label class="radio-inline"> <input type="radio"
													name="roleId" checked="checked" value="${role.id}">
													${role.name}
												</label>
											</c:when>
											<c:otherwise>
												<label class="radio-inline"> <input type="radio"
													name="roleId" value="${role.id}"> ${role.name}
												</label>
											</c:otherwise>
										</c:choose>
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
</body>
</html>