<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zhuyunlong.common.GetIp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>设备管理系统后台</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		$('#out').click(function(){
			if (self != top) {
				top.location = "login";
			};			
		});
		</script> 
	</head>
	<body>
		<div class="header container-fluid">
			<div class="title">
				<h4><a href="index.html"><strong>学生宿舍网络管理系统</strong></a></h4>
			</div>
			<div class="dropdown head-portrait">
				<img src="img/avatar3.jpg" />
				<button class="dropdown-toggle manager" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    管理员
    <i class="glyphicon glyphicon-menu-down"></i>
  </button>
				<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
					<li>
						<a href="userinfo" target="iframe">
							<i class="glyphicon glyphicon-user"></i> 个人信息 </a>
					</li>
					<li role="separator" class="divider"></li>
					<li>
						<a href="modifypass" target="iframe">
							<i class="glyphicon glyphicon-exclamation-sign"></i> 邮箱验证 </a>
					</li>
					<li>
						<a href="login">
							<i class="glyphicon glyphicon-log-out"></i> 安全退出 </a>
					</li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="left">
			<div class="menu-btn">
				<img src="img/menu.jpg" />
			</div>
			<div class="menu">
				<div class="panel-group" id="sidbar">
					<div class="panel panel-accordion panel-default">
						<div class="panel-heading" id="heading">
							<a href="#panel1" data-toggle="collapse" data-target="#panel1" data-parent="#sidbar" class="link">
								<i class="glyphicon glyphicon-home"></i>
								<span class="panel-title">我的工作台</span>
							</a>
						</div>
						<div class="panel-collapse collapse in" id="panel1">
							<div class="panel-body">
								<ul>
									<li>
										<a href="addroomnum" target="iframe">
											<i class="glyphicon glyphicon-user"></i> 添加寝室人数
										</a>
									</li>
									<li>
										<a href="setroomstate" target="iframe">
											<i class="glyphicon glyphicon-lock"></i> 设置寝室网络状态
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel panel-accordion panel-default">
						<div class="panel-heading" id="heading">
							<a href="#panel2" data-toggle="collapse" data-target="#panel2" data-parent="#sidbar" class="link">
								<i class="glyphicon glyphicon-cog"></i>
								<span class="panel-title">个人信息管理</span>
							</a>
						</div>
						<div class="panel-collapse collapse" id="panel2">
							<div class="panel-body">
								<ul>
									<li>
										<a href="adduser" target="iframe">
											<i class="glyphicon glyphicon-user"></i> 添加用户
										</a>
									</li>
									<li>
										<a href="driectlist" target="iframe">
											<i class="glyphicon glyphicon-print"></i> 数据字典
										</a>
									</li>
									<li>
										<a href="userlist" target="iframe">
											<i class="glyphicon glyphicon-home"></i> 用户列表
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel panel-accordion panel-default">
						<div class="panel-heading" id="heading">
							<a href="#panel3" data-toggle="collapse" data-target="#panel3" data-parent="#sidbar" class="link">
								<i class="glyphicon glyphicon-blackboard"></i>
								<span class="panel-title">设备管理</span></a>
						</div>
						<div class="panel-collapse collapse" id="panel3">
							<div class="panel-body">
								<ul>
									<li>
										<a href="roomlist" target="iframe">
											<i class="glyphicon glyphicon-volume-up"></i> 寝室管理
										</a>
									</li>
									<li>
										<a href="addroom" target="iframe">
											<i class="glyphicon glyphicon-wrench"></i> 添加寝室
										</a>
									</li>
									<li>
										<a href="equip" target="iframe">
											<i class="glyphicon glyphicon-flash"></i> 设备报修处理
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="iframe">
		<h4>欢迎${name}登录<%=new GetIp().getHostIp() %></h4>
			<iframe name="iframe"></iframe>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$("img").click(function() {
					console.log($(".left").width() + "?");
					if($(".left").width() == 35) {
						$(".left").width(220);
						$(".iframe").css("margin-left","220px");
					} else {
						$(".left").width(35);
						$(".iframe").css("margin-left","40px");
					}

				});
			});
		</script>
	</body>
</html>