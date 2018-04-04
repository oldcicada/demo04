<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>设备管理系统后台</title>
<%@ include file="../../base.jsp"%>
<link rel="stylesheet" type="text/css"
	href="resource\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resource/css/index.css" />
</head>
<body>
	<div class="header container-fluid">
		<div class="logo">
			<a href="index.html"> <img src="resource\img\logo.png" alt="logo" />
			</a>
		</div>
		<div class="title">
			<h4>
				<a href="view/index"><strong>科大讯飞设备管理系统</strong></a>
			</h4>
		</div>
		<div class="dropdown head-portrait">
			<img src="resource\img\avatar3.jpg" />
			<button class="dropdown-toggle manager" type="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				管理员 <i class="glyphicon glyphicon-menu-down"></i>
			</button>
			<ul class="dropdown-menu dropdown-menu-right"
				aria-labelledby="dropdownMenu1">
				<li><a href="view/mime/userinfo" target="iframe"><i
						class="glyphicon glyphicon-user"></i> 个人信息 </a></li>
				<li role="separator" class="divider"></li>
				<li><a href="view/mime/modifypass" target="iframe"><i
						class="glyphicon glyphicon-exclamation-sign"></i> 密码修改 </a></li>
				<li><a href="loginOut"><i
						class="glyphicon glyphicon-log-out"></i> 安全退出 </a></li>
				<li role="separator" class="divider"></li>
				<li><a href="view/about" target="iframe"><i
						class="glyphicon glyphicon glyphicon-bookmark"></i> 关于本站 </a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="left">
		<div class="menu-btn">
			<img
				src="data:image/png;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/
		2wBDAAIBAQEBAQIBAQECAgICAgQDAgICAgUEBAMEBgUGBgYFBgYGBwkIBgcJBwYGCAsICQoKCgoKBggLDAsKDAkKCgr/
		2wBDAQICAgICAgUDAwUKBwYHCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgr/
		wgARCAAbAB4DAREAAhEBAxEB/8QAGQAAAgMBAAAAAAAAAAAAAAAAAAYDBAcJ/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/
		aAAwDAQACEAMQAAAA5KDQRCuWzTyoZgSjQRCuAAB//8QALxAAAQMCAgcGBwAAAAAAAAAAAgEDBAURBgcAEhMVISIxEB
		QXQVeWGCBoldPV5f/aAAgBAQABPwCnU+fVp7NLpcJ2TJkui1Hjx2lNx1wlsICKcSJVsiInFdPALPb0Vxb7clfj0n5JZ
		zUmA/VKplFiiNFjNE7IkyKBJBtpsUVSMiULCKIiqqr2UCFvGuwqfumXUNvLab7jAKz8nWJE2ba6h2Mug8pcVTlLovg39
		J2bX3L+VpX8p93UKbUPhlzOgbCI453+fPuxG1RVdq4m7AuA2uXMPBF5k7KccBuey5VIzz0YXgWQzHeRpxxu/MImomgEq
		XsSiSIvkvTTfORPpxi33rF/W6T6rkw5AfapeAcUMySZJIz0jF8Z1sHLLqkQJAFTFFtcUIVVPNPm/8QAFBEBAAAAAAAAA
		AAAAAAAAAAAQP/aAAgBAgEBPwAH/8QAFBEBAAAAAAAAAAAAAAAAAAAAQP/aAAgBAwEBPwAH/9k=" />
		</div>
		<div class="menu">
			<div class="panel-group" id="sidbar">
				<c:forEach varStatus="st" items="${list}" var="list">
					<div class="panel panel-accordion panel-default">
						<div class="panel-heading" id="heading">
							<a href="${list.link_address}" data-toggle="collapse"
								data-target="#panel${st.index+1}" data-parent="#sidbar"
								class="link"> <i class="${list.icon}"></i><span
								class="panel-title"> ${list.name}</span>
							</a>
						</div>
						<div class="panel-collapse collapse collapse" id="panel${st.index+1}">
							<div class="panel-body">
								<ul>
									<c:forEach varStatus="st" items="${list.menus}" var="menu">
										<li><a href="${menu.link_address }" target="iframe"><i
												class="${menu.icon }"></i> ${menu.name}</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="iframe">
		<iframe name="iframe"></iframe>
	</div>
	<script src="resource\js\jquery.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="resource\js\bootstrap.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("img").click(function() {
				if ($(".left").width() == 35) {
					$(".left").width(220);
					$(".iframe").css("margin-left", "220px");
				} else {
					$(".left").width(35);
					$(".iframe").css("margin-left", "40px");
				}
			});
		});
	</script>
</body>
</html>