<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <%@ include file="/base.jsp" %>
			<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css"/>
			<link rel="stylesheet" type="text/css" href="resource/css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i> 设备管理
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="view/equip/applyList"> 设备报修处理</a>
					</li>
				</ul>
			</div>
			<div class="clearfix">
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li>
					<a href="view/equip/applyList" >
					申报列表 </a>
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
								<input type="hidden" class="form-control" name="id" value="${equipmentId }">
									<div class="form-group">
										<label class="control-label col-md-3">设备名称：</label>
										<label class="control-label col-md-1">${name }</label>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">故障标题：</label>
										<div class="col-md-4">
											<div class="input-group">
												<input type="text" class="form-control" name="title" placeholder="请输入一句话故障">
												<span class="input-group-addon">
												</span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">故障详情：</label>
										<div class="col-md-4">
											<textarea name="description"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3" for="inputSuccess">上传附件：</label>
										<div class="col-md-4">
											<input type="file" class="form-control" name="file"/>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn btn-primary blue">确定申报</button>
											<button type="reset" class="btn btn-primary blue">重置</button>
										</div>
									</div>
								</div>
							</form>
							<!-- END FORM-->
				</div>
			</div>
		</div>
	</body>
