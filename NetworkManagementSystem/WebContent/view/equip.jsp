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
						<a href="index-2.html">设备管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="#">设备报修处理</a>
					</li>
				</ul>
			</div>
			<div class="clearfix">
			</div>
			<ul class="nav nav-tabs">
				<li class="active" >
					<a href="#">
					故障申报</a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
							<form action="equip" class="form-horizontal">
								<div class="form-body">
									<div class="form-group">
										<label class="control-label col-md-3" for="inputWarning">申报人名称：</label>
										<div class="col-md-4">
											${name}
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3" for="inputError">故障标题：</label>
										<div class="col-md-4">
											<div class="input-group">
												<input type="text" class="form-control" name="title" placeholder="请输入一句话故障">
												<span class="input-group-addon">
												</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3" for="inputSuccess">故障详情：</label>
										<div class="col-md-4">
											<textarea></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3" for="inputSuccess">手机：</label>
										<div class="col-md-4">
											<input type="text" class="form-control" name="realName" placeholder="请输入电话号码"/>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn btn-primary blue">确定申报</button>
										</div>
									</div>
								</div>
							</form>
				</div>
			</div>
		</div>
	</body>
