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
						<form style="margin:20px" action="view/sys/dictList" method="post">
							<table style="width:100%;">
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典分类：</label></td>
									<td>
										<input type="text" class="form-control" name="dictType" placeholder="字典分类"/>
									</td>
									<td style="text-align: right;padding: 10px;"><label class="control-label">字典简称：</label></td>
									<td><input type="text" class="form-control" name="userName" placeholder="请输入字典简称"/></td>
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
									<th class="text-center">字典名称</th>
									<th class="text-center">字典值</th>
									<th class="text-center">字典分类</th>
									<th class="text-center">描述</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>男</td>
									<td>1</td>
									<td>sex</td>
									<td>性别</td>
									<td class="text-center">
										<a href="#">编辑</a>
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>女</td>
									<td>2</td>
									<td>sex</td>
									<td>性别</td>
									<td class="text-center">
										<a href="#">编辑</a>
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>正常</td>
									<td>1</td>
									<td>setStatus</td>
									<td>设备状态</td>
									<td class="text-center">
										<a href="#">编辑</a>
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>故障</td>
									<td>2</td>
									<td>setStatus</td>
									<td>设备状态</td>
									<td class="text-center">
										<a href="#">编辑</a>
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>正在维修</td>
									<td>3</td>
									<td>equipStatus</td>
									<td>设备状态</td>
									<td class="text-center">
										<a href="#">设备</a>
										<a href="#">删除</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="col-md-5 col-sm-12">
							<div class="dataTables_info" style="padding-top: 8px;" role="status" aria-live="polite">显示 1 到 10  共 25 记录</div>
						</div>
						<div class="col-md-7 col-sm-12">
							<div style="float: right;margin: 0px;height: 40px;">
								<ul class="pagination">
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
				</div>
			</div>
	</body>
</html>