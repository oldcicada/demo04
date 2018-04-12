<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
<%@ include file="/base.jsp" %>
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
						<i class="glyphicon glyphicon-home"></i>
						<a  href="#">系统管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="view/sys/dictList">字典管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="view/sys/dictList" >
					字典列表 </a>
				</li>
				<li>
					<a href="view/sys/dictForm">
					新增字典 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12"> 
							<table style="margin:20px 200px">
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典分类：</label></td>
									<td>
										<input type="text" class="form-control" name="type" placeholder="字典分类"/>
									</td>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典简称：</label></td>
									<td><input type="text" class="form-control" name="tag" placeholder="请输入字典简称"/></td>
									<td style="text-align: right;padding: 10px;">
										<button type="submit" id="query" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>查询</button>
										<button type="reset"  id="reset" class="btn btn-default"><i class="glyphicon glyphicon-refresh"></i>重置</button>
									</td>
									
								</tr>
							</table>
						</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable alltable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">字典值</th>
									<th class="text-center">字典名称</th>
									<th class="text-center">字典分类</th>
									<th class="text-center">描述</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody id="content"></tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
		<div class="col-md-5 col-sm-12">
			<div id="pageMessage" style="padding:8px 20px;"
			></div>
		</div>
		<div class="col-md-7 col-sm-12">
			<div style="float: right; margin-right: 20px;"
				id="pageControl">
				<a href="javascript:void(0)" class="page" id="first">首页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="previou">上页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="next">下页</a>&nbsp; 
			    <a href="javascript:void(0)" class="page" id="last">末页</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/dictList.js"></script>
</body>
</html>