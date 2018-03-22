<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>login</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$("#forget").click( function () {$(".body").first().hide();$(".forget").show()});
				$(".back").click( function () {$(".body").first().show();$(".forget").hide()});
			});
		</script>
	</head>
	<body>
		<div class="loginbox container">
			<div class="head">
				<h3>学生宿舍网络管理系统</h3>
			</div>
			<div class="body">
				<form action="login" method="post">
					<div class="body-head">
						<h2>用户登录</h2>
					</div>
					<div class="body-main">
						<div class="form-group">
							<input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名" name="number" value="${username }" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name="password" required="required">
						</div>
					</div>
					<div class="body-foot">
						<button class="btn btn-success" type="submit">确定登陆</button>
						<div class="checkbox">
							<label><input type="checkbox" name="remerber" value="true" checked="checked"> 记住我</label>
							<span id="forget"><a href="javascript:void(0)">忘记密码？</a></span>
						</div>
						<br /><br />
						${error}
					</div>
				</form>
			</div>
			<div class="body forget">
				<form action="register" method="post">
					<div class="body-head">
						<h2>忘记密码？</h2>
					</div>
					<div class="body-main">
						<div class="form-group" style="text-align: left;">
							输入你的邮箱进行重新设置你的密码
							<input type="text" class="form-control" id="exampleInputEmail2" placeholder="Email">
						</div>
					</div>
					<div class="body-foot">
						<button class="btn btn-default back" type="reset">返回</button>
						<button class="btn btn-success" type="submit">确定登陆</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>