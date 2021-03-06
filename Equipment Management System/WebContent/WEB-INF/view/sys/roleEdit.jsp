<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/base.jsp"%>
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="resource/css/zTreeStyle.css" />
</head>
<body>
	<div class="page-container">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> 系统管理
					<i class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/sys/roleForm"> 角色管理</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<ul class="nav nav-tabs">
			<li class="active"><a>角色信息修改</a></li>
		</ul>
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-8">
				<!-- BEGIN FORM-->
				<form action="view/sys/roleEdit" method="post" style="margin: 20px;">
					<input type="hidden" value="${role.id}" id="id" name="id">
					<div class="form-body">
						<div class="form-group">
							<label>角色简称：</label> <input type="text" class="form-control"
								name="name" value=${role.name } placeholder="请输入角色简称" />
						</div>
						<div class="form-group">
							<label>角色描述：</label>
							<textarea class="form-control" rows="3" name="description">${role.description}</textarea>
						</div>
						<div class="form-group">
							<label>角色代码：</label>
								<input type="text" class="form-control" name="code"
									value="${role.code}" placeholder="请输入角色代码" />
						</div>
						<div class="form-group">
							<label>是否启用：</label>
								<div class="radio-list">
									<div id="enable-radio">
										<c:forEach items="${show}" var="show">
											<c:choose>
												<c:when test="${role.used == show.value}">
													<label class="radio-inline"> <input type="radio"
														name="used" value="${show.value }" checked="checked">
														${show.tag }
													</label>
												</c:when>
												<c:otherwise>
													<label class="radio-inline"> <input type="radio"
														name="used" value="${show.value }">
														${show.tag }
													</label>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label>角色权限：</label>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</div>
					<div class="row">
					<input id="checkCodes" name="checkCodes" type="hidden">
						<div class="col-md-offset-3 col-md-9">
							<button type="submit" class="btn btn-primary blue" onclick="doSubmit()">提交</button>
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
<script src="resource/js/jquery.ztree.core.js"
	type="text/javascript" charset="utf-8"></script>
	<script src="resource/js/jquery.ztree.excheck.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	var setting = {
		check : {
			enable : true
		//是否显示选择框
		},
		data : {
			simpleData : {
				enable : true
			//是否是简单数据类型，array
			}
		}
	};

	$(function() {
		$.post("view/sys/roleDelete", {
			"id" : $("#id").val()
		}, function(data) {
			data = eval("(" + data + ")");
			$.fn.zTree.init($("#treeDemo"), setting, data);
		});
	});

	function doSubmit() {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getCheckedNodes(true);
		var menuIds = "";
		for (var i = 0; i < nodes.length; i++) {
			menuIds += nodes[i].id + ",";
		}
		$("#checkCodes").val(menuIds);
		$("#roleForm").submit();
	}
</script>
</html>