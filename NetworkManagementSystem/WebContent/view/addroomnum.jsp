<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
	</head>
	<body>
		<div class="page-container">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="glyphicon glyphicon-home"></i>
						<a  href="#">我的工作台</a>
						<i class="glyphicon glyphicon-chevron-right"></i>
					</li>
					<li>
						<a href="#">添加寝室人数</a>
					</li>
				</ul>
			</div>
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#" >
					人数设置 </a>
				</li>
			</ul>
			<div class="row">
				<div class="col-md-12">
						<form method="post" action="addroomnumserch" style="margin: 20px;">
							<table style="width:100%;">
								<tr>
									<td style="text-align: right;padding: 10px;"><label class="control-label">状态：</label></td>
									<td><input type="text" class="form-control" name="userName" placeholder="请输入状态（）"/></td>
									<td>
										<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>查询</button>
										<button type="reset" class="btn btn-default"><i class="glyphicon glyphicon-refresh"></i>重置</button>
									</td>
								</tr>
							</table>
						</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-scrollable">
						<table class="table table-striped table-bordered table-hover dataTable no-footer">
							<thead>
								<tr>
									<th class="text-center">序号</th>
									<th class="text-center">寝室号</th>
									<th class="text-center">寝室人数</th>
									<th class="text-center">状态</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach  var="item" items="${ roomlist}"  varStatus="st">
								  <tr>
								    <td>${st.index+1 }</td>
								    <td>${item.roomnumber }</td>
								    <td>${item.roomnum }</td>
								     <td>${item.state }</td>
								   <td class="text-center">
										<strong><a href="addroomnum1?id=${item.id }">+1</a>
										<a href="addroomnum2?id=${item.id }">-1</a></strong>
									</td>
								  </tr>
								  </c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>	
	</body>
</html>