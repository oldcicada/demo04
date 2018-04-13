<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="base.jsp"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>login</title>
<link rel="stylesheet" href="resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/login.css" />
</head>
<body>
<div class="loginbox container">
		<div class="head">
		</div>
		<div class="body">
			<form action="receiveMail" method="post">
				<div class="body-head">
					<h4>用户密码修改</h4>
				</div>
				<div class="body-main">
				<input type="hidden" name="receiveMail" value="${receiveMail}">
				<input type="hidden" name="code" value="${code}">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入新密码"
							name="newPassword" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="再次确认新密码"
							name="confirmPassword" required="required">
					</div>
				</div>
				<div class="body-foot">
					<button class="btn btn-success" type="submit">确定修改</button>
					<button class="btn btn-success" type="reset">重置</button>
					<span><a href="login">返回</a></span>
					<br /> ${passwordError}${emailError}
				</div>
			</form>
		</div>
	</div>
</body>
</html>