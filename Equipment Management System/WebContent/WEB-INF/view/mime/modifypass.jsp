<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/base.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resource\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource\css\common.css" />
</head>
<body>
	<div class="page-container">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i><a
					href="view/mime/portal">我的工作台</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/mime/modifypass">密码修改</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/mime/modifypass" method="post"
					class="form-horizontal">
					<div class="form-body">
						<h3 class="form-section">密码修改</h3>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputError">邮箱：</label>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-envelope"></i>
									</span> <input type="email" class="form-control" name="email"
										placeholder="请输入Email">
								</div>
								<span class="help-block"> 邮件发送成功后，登录邮箱点击链接修改密码 </span>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-primary blue">发送邮件</button>
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