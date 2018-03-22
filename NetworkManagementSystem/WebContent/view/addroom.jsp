<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>
<body>
	<div class="page-container">
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="glyphicon glyphicon-home"></i> <a
					href="#l">设备管理</a> <i
					class="glyphicon glyphicon-chevron-right"></i></li>
				<li><a href="#">添加寝室</a></li>
			</ul>
		</div>
		<ul class="nav nav-tabs">
			<li><a href="addroom"> 添加寝室 </a></li>
		</ul>
		<div class="row">
			<div class="col-md-12">
				<form action="addroom" method="post" class="form-horizontal">
					<div class="form-body">
						<div class="form-group">
							<label class="control-label col-md-3" for="inputWarning">寝室号：<span
								class="required"> * </span></label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="roomnumber"
									placeholder="请输入寝室号" /> <span class="help-block">
									4位数字，例如1101表示1栋1层101室</span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="inputError">寝室人数：</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" name="roomnum"
										placeholder="请输入人数">
								</div>
								<span class="help-block"> 最多为6人</span>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button type="submit" class="btn btn-primary blue">提交</button>
									<button type="reset" class="btn btn-default blue">
										<i class="glyphicon glyphicon-refresh"></i>重置信息
									</button>
								</div>
							</div>
								${success }
						</div>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>