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
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i> 系统管理
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="view/sys/dictList"> 字典管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<ul class="nav nav-tabs">
				<li >
					<a href="view/sys/dictList" >
					字典列表 </a>
				</li>
				<li class="active" >
					<a href="view/sys/dictForm">
					字典信息 </a>
				</li>
			</ul>
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-8">
							<!-- BEGIN FORM-->
							<form action="view/sys/dictForm" method="post" style="padding: 20px;">
								<div class="form-body">
									<div class="form-group">
										<label>字典分类：</label>
										<input type="text" class="form-control" name="type" placeholder="请输入字典分类" required="required"/>
									</div>
									<div class="form-group">
										<label >字典简称：</label>
										<input type="text" class="form-control" name="tag" placeholder="字典简称" required="required"/>
									</div>
									<div class="form-group">
										<label >字典值：</label>
										<input type="text" class="form-control" name="value" placeholder="字典值" required="required"/>
									</div>
									<div class="form-group">
										<label >字典描述：</label>
										<textarea class="form-control" rows="3" name="description"></textarea>
									</div>
									<div class="form-group">
										<label >排序号：</label>
										<input type="text" class="form-control" name="sort" placeholder="排序号"/>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn btn-primary blue">提交</button>
											<button type="reset" class="btn btn-default blue"><i class="glyphicon glyphicon-refresh"></i>重置</button>
										</div>
									</div>
								</div>
							</form>
							<!-- END FORM-->
				</div>
			</div>
		</div>
	</body>
</html>