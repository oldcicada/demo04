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
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> 设备管理
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/equip/applyList"> 故障列表</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a href="view/equip/applyForm"> 故障详情</a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-10">
			<input type="hidden" name="id" value="${repairId}">
				<div class="table-scrollable alltable" style="margin-top:40px">
					<table
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead>
							<tr>
								<th class="text-center col-md-1">编号</th>
								<th class="text-center col-md-3">名称</th>
								<th class="text-center col-md-6">详细信息</th>
							</tr>
						</thead>
						<tbody id="content">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-sm-12">
				<div id="pageMessage" style="padding: 8px 20px;"></div>
			</div>
			<div class="col-md-7 col-sm-10">
				<div style="float: right; margin-right: 20px;" id="pageControl">
					<a href="javascript:void(0)" class="page" id="first">首页</a>&nbsp; <a
						href="javascript:void(0)" class="page" id="previou">上页</a>&nbsp; <a
						href="javascript:void(0)" class="page" id="next">下页</a>&nbsp; <a
						href="javascript:void(0)" class="page" id="last">末页</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/applyShow.js"></script>
</body>
</html>