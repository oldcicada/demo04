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
<style type="text/css">
.headpicture {
	width: 60px;
	height: 60px;
	margin: 5px;
}

.headpicture img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}
</style>
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a
					href="view/mime/portal"> 我的工作台</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="view/mime/modifypass"> 密码修改</a>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN FORM-->
				<form action="view/mime/modifypassView" method="post"
					class="form-horizontal">
					<div class="form-body">
						<h3 class="form-section">修改密码</h3>
						<input type="hidden" name="id" value="${id}" /> <input
							type="hidden" name="email" value="${email}" />
						<div class="form-group">
							<label class="control-label col-md-3">新密码：</label>
							<div class="col-md-4">
								<input type="password" class="form-control" name="newPassword"
									placeholder="请输入新密码" /> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">确认密码：</label>
							<div class="col-md-4">
								<input type="password" class="form-control" name="confirmPassword"
									placeholder="请再次输入新密码" /> 
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">验证码</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="code"
									placeholder="请输入验证码"> <span class="help-block">
									${emailError}${passwordError}${codeError }</span>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-primary blue">更改密码</button>
								<button type="reset" class="btn btn-primary blue">重置</button>
							</div>
						</div>
					</div>
				</form>
				<!-- END FORM-->
			</div>
		</div>
	</div>
	<script type="text/javascript" src="resource/js/jquery.min.js"></script>
	<script type="text/javascript">
		var sexValue = $('#sexvalue').val();
		$("input[name=sex]").each(function() {
			if ($(this).val() == sexValue) {
				$(this).attr("checked", "checked");
			}
		});
		var roleValue = $('#roleId').val();
		$("input[name=role]").each(function() {
			if ($(this).val() == roleValue) {
				$(this).attr("checked", "checked");
			}
		});
	</script>
</body>
</html>