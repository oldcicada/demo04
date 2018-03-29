<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css"/>
			<link rel="stylesheet" type="text/css" href="resource/css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i>
						<a href="#">设备管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="#">设备库管理</a>
					</li>
				</ul>
			</div>
			<div class="clearfix">
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li >
					<a href="view/eqiup/applyList" >
					设备列表 </a>
				</li>
				<li class="active" >
					<a href="view/equip/applyForm">
					故障申报</a>
				</li>
			</ul>
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
							<!-- BEGIN FORM-->
							<form action="view/equip/applyForm" method="post" class="form-horizontal">
								<div class="form-body">
									<div class="form-group">
										<label class="control-label col-md-3" for="inputWarning">设备名称：<span class="required">
										* </span></label>
										<div class="col-md-4">
											电脑2
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3" for="inputError">故障标题：</label>
										<div class="col-md-4">
											<div class="input-group">
												<input type="email" class="form-control" name="email" placeholder="请输入一句话故障">
												<span class="input-group-addon">
												<i class="glyphicon glyphicon-envelope"></i>
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
										<label class="control-label col-md-3" for="inputSuccess">上传附件：</label>
										<div class="col-md-4">
											<input type="file" class="form-control" name="realName" placeholder="请输入电话号码"/>
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
							<!-- END FORM-->
				</div>
			</div>
		</div>
	</body>