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
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a  href="#">设备管理</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">故障处理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="view/equip/faultList" >
					故障列表 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12 alltable" >
						<form action="view/equip/faultList" style="margin: 20px;">
							<table style="width:100%;">
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">设备类型：</label></td>
									<td>
										<select name="classify">
											<option>请选择类型</option>
										</select>
									</td>
									<td style="text-align: right;padding: 10px;">设备名称：</td>
									<td><input type="text" class="form-control" name="userName" placeholder="请输入设备名称"/></td>
									<td style="text-align: right;padding: 10px;">故障状态：</td>
									<td>
										<select name="classify">
											<option>请选择类型</option>
										</select>
									</td>
									<td style="text-align: right;padding: 10px;"></td>
									<td>
										<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>查询</button>
										<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-refresh"></i>重置</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable alltable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">故障编号</th>
									<th class="text-center">故障标题</th>
									<th class="text-center">房间地址</th>
									<th class="text-center">故障状态</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>201801019900990</td>
									<td>电脑出现蓝屏</td>
									<td>机房2</td>
									<td>待处理</td>
									<td class="text-center"><a href="#">查看详情</a>
										<a href="#">立即处理</a>
									</td>
								</tr>
								
								<tr>
									<td>201801019900990</td>
									<td>电脑出现蓝屏</td>
									<td>机房2</td>
									<td>待处理</td>
									<td class="text-center"><a href="#">查看详情</a>
										<a href="#">立即处理</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5 col-sm-12">
					<div class="dataTables_info" style="padding-top: 8px;" role="status" aria-live="polite">显示 1 到 10  共 25 记录</div>
				</div>
				<div class="col-md-7 col-sm-12">
					<div style="float: right;margin: 0px;height: 40px;" id="sample_1_paginate">
						<ul class="pagination" style="visibility: visible;">
							<li class="prev disabled"><a href="#" title="首页"><i class="glyphicon glyphicon-menu-left"></i></a></li>
							<li class="prev disabled"><a href="#" title="上一页"><i class="glyphicon glyphicon-menu-left"></i><i class="glyphicon glyphicon-menu-left"></i></a></li>
							<li class="active"><a href="#">1</a></li><li><a href="#">2</a></li>
							<li><a href="#">3</a></li><li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="next"><a href="#" title="下一页"><i class="glyphicon glyphicon-menu-right"></i></a></li>
							<li class="next"><a href="#" title="尾页"><i class="glyphicon glyphicon-menu-right"></i><i class="glyphicon glyphicon-menu-right"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
	</body>
</html>