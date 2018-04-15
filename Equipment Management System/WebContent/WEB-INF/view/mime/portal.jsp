<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/base.jsp"%>
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="resource/css/protal.css" />
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a
					href="view/mime/portal"> 我的工作台</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/mime/portal"> 信息和报表</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN DASHBOARD STATS -->
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
				<div class="dashboard-stat blue-madison">
					<div class="visual">
						<i class="fa fa-comments"></i>
					</div>
					<div class="details">
						<div class="number">1349</div>
						<div class="desc">未使用设备</div>
					</div>
					<a class="more" href="#"> 查看设备库存 <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
				<div class="dashboard-stat red-intense">
					<div class="visual">
						<i class="fa fa-bar-chart-o"></i>
					</div>
					<div class="details">
						<div class="number">￥125,000</div>
						<div class="desc">本月维修费用</div>
					</div>
					<a class="more" href="#"> 维修记录查询 <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
				<div class="dashboard-stat green-haze">
					<div class="visual">
						<i class="fa fa-shopping-cart"></i>
					</div>
					<div class="details">
						<div class="number">549</div>
						<div class="desc">最新故障单</div>
					</div>
					<a class="more" href="#"> 故障处理 <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row ">

			<div class="col-md-12 col-sm-12">
				<div class="portlet-title">
					<div class="caption">
						<i class="glyphicon glyphicon-ok"></i>最新保修单
					</div>
					<div class="actions">
						<a class="btn btn-default" href="#"> more&gt;&gt; </a>
					</div>
				</div>
				<div class="portlet-body">
					<table
						class="table table-striped table-bordered table-advance table-hover">
						<thead>
							<tr>
								<th>设备所在办公室</th>
								<th class="hidden-xs">设备类型</th>
								<th class="hidden-xs">设备编号</th>
								<th><i class="glyphicon glyphicon-shopping-cart"></i> 报修时间
								</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="highlight">
									<div class="success"></div> <a href="#"> 教室一 </a>
								</td>
								<td class="hidden-xs">电脑</td>
								<td class="hidden-xs">PC-201709001</td>
								<td>2018-01-01 19:30:20</td>
								<td><a href="#" class="btn default btn-xs purple"> <i
										class="glyphicon glyphicon-wrench"></i> 立即处理
								</a></td>
							</tr>
							<tr>
								<td class="highlight">
									<div class="success"></div> <a href="#"> 教室一 </a>
								</td>
								<td class="hidden-xs">电脑</td>
								<td class="hidden-xs">PC-201709001</td>
								<td>2018-01-01 19:30:20</td>
								<td><a href="#" class="btn default btn-xs purple"> <i
										class="glyphicon glyphicon-wrench"></i> 立即处理
								</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
</body>
</html>
