<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
			<link rel="stylesheet" type="text/css" href="css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i>
						<a href="#">个人信息管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li >
						<a href="#">添加用户</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
				</ul>
			</div>
			<div class="row">
				<div class="col-md-12"> 
							<form action="adduser" method="post" class="form-horizontal">
									<div class="alert alert-danger display-hide" style="display: none;">
										<button class="close" data-close="alert"></button>
										有信息输入错误，请检查您的输入.
									</div>
									<div class="alert alert-success display-hide" style="display: none;">
										<button class="close" data-close="alert"></button>
										信息输入正确!
									</div>
									<h3 class="form-section">个人信息</h3>
									<div class="form-group" style="height: 80px;border-top: 1px solid #ccc;padding-top:20px;">
										<label class="col-md-3 control-label">头像：</label>
										<div class="col-md-9">
											<input type="file" id="exampleInputFile">
											<p class="help-block">
												 130:130的图片
											</p>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">姓名：</label>
										<div class="col-md-4">
											<input type="text" class="form-control" name="name" placeholder="请输入姓名"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">学号：<span class="required">
										 </span></label>
										<div class="col-md-4">
											<input type="text" class="form-control" name="number" placeholder="请输入用户名"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">密码：</label>
										<div class="col-md-4">
											<input type="password" class="form-control" name="password" placeholder="请输入密码"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">寝室号：</label>
										<div class="col-md-4">
											<input type="text" class="form-control" name="roomnumber" placeholder="请输入寝室号"/>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">邮箱：</label>
										<div class="col-md-4">
											<input type="email" class="form-control" name="email" placeholder="请输入Email">
											<span class="help-block">
											请输入正确的邮箱，可以用来找回密码使用 </span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">性别：</label>
										<div class="col-md-9">
											<div class="radio-list">
												<label class="radio-inline">
													<input type="radio" name="sex" value="1" checked="checked">男 </label>
												<label class="radio-inline">
													<input type="radio" name="sex"  value="2" >女 </label>
											</div>
										</div>
									</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn btn-primary blue"> 提交信息</button>
										</div>
									</div>
								</div>
							</form>
				</div>
			</div>
		</div>
	</body>
</html>