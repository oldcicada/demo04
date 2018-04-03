<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
</head>
<body>
	<div class="page-container">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a href="#">系统管理</a>
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/roleForm">角色管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li><a href="view/sys/roleList"> 角色列表 </a></li>
			<li class="active"><a href="view/sys/roleForm"> 角色信息 </a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-8">
				<!-- BEGIN FORM-->
				<form action="view/sys/roleForm" method="post" style="margin: 20px;">
					<div class="form-body">
						<div class="form-group">
							<label>角色简称：<span class="required">* </span></label> <input
								type="text" class="form-control" name="userName"
								placeholder="请输入角色简称" />
						</div>
						<div class="form-group">
							<label>角色描述：</label>
							<textarea class="form-control" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label>角色权限：</label>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-offset-3 col-md-9">
							<button type="submit" class="btn btn-primary blue">提交</button>
							<button type="reset" class="btn btn-default blue">
								<i class="glyphicon glyphicon-refresh"></i>重置信息
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- END FORM-->
	</div>
</body>
<script src="resource/js/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="resource/js/jquery.ztree.core.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		}
	};

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "设备故障报修管理",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "我的工作台",
		open : true
	}, {
		id : 111,
		pId : 11,
		name : "信息和报表"
	}, {
		id : 112,
		pId : 11,
		name : "个人信息"
	}, {
		id : 113,
		pId : 11,
		name : "密码修改"
	}, {
		id : 12,
		pId : 1,
		name : "系统管理",
		open : false
	}, {
		id : 121,
		pId : 12,
		name : "用户管理"
	}, {
		id : 122,
		pId : 12,
		name : "角色管理"
	}, {
		id : 123,
		pId : 12,
		name : "菜单管理"
	}, {
		id : 124,
		pId : 12,
		name : "字典管理"
	}, {
		id : 125,
		pId : 12,
		name : "办公地管理"
	}, {
		id : 13,
		pId : 1,
		name : "设备管理",
		open : false
	}, {
		id : 131,
		pId : 13,
		name : "设备库管理"
	}, {
		id : 132,
		pId : 13,
		name : "设备报修"
	}, {
		id : 133,
		pId : 13,
		name : "设备报修处理"
	}, {
		id : 134,
		pId : 13,
		name : "维修记录查询"
	} ];

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</script>
</html>