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
						<a  href="#">个人信息管理</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="#">字典管理</a>
					</li>
				</ul>
			</div>
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="dictList.html" >
					字典列表 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
						<form style="margin:20px">
						</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable">
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
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>女</td>
									<td>0</td>
									<td>sex</td>
									<td>性别</td>
									<td class="text-center">
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>正常</td>
									<td>1</td>
									<td>roomStatus</td>
									<td>设备状态</td>
									<td class="text-center">
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>故障</td>
									<td>0</td>
									<td>roomStatus</td>
									<td>设备状态</td>
									<td class="text-center">
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>正常</td>
									<td>1</td>
									<td>userInfo</td>
									<td>个人信息</td>
									<td class="text-center">
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td>锁定</td>
									<td>0</td>
									<td>userInfo</td>
									<td>个人信息</td>
									<td class="text-center">
										<a href="#">删除</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			</div>
	</body>
</html>