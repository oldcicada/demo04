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
						<a href="index-2.html">我的工作台</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li >
						<a href="#">个人信息</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
				</ul>
			</div>
			<div class="row">
				<div class="col-md-12">
								<div class="form-body" style="padding-left:200px;">
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
										<label class="control-label col-md-3">用户名：</label>
											${number}
									</div>
									<br/>
									<div class="form-group">
										<label class="control-label col-md-3">邮箱：</label>
											${email}
									</div><br/>
										<br/>
									<div class="form-group">
										<label class="col-md-3 control-label">性别：</label>
											${sex }
									</div>
								</div>
								<br/>
									<br/>
				</div>
			</div>
		</div>
	</body>
</html>