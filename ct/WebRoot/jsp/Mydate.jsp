<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
	<div class="container my-container">
		<div class="row">
			<div class="col-md-7 col-md-offset-2 ">
				<ul class="nav nav-tabs">
					<li role="presentation" class="useDataBut active"><a href="#">基本信息</a></li>
					<li role="presentation" class="changePasswordBut"><a href="#">修改密码</a></li>
				</ul>
				<!-- 修改用户信息 -->
				<div class="changeUse" style="width: 500px">
					<form action="<%= this.getServletContext().getContextPath() %>/changeUse" enctype="multipart/form-data" method="post">
						<div style="padding: 10px" class="form-group">
							昵称:<input class="form-control" type="text" name="patname" value="${use.patname}">
						</div>
						<div style="padding: 10px;width: auto;"
							class="form-group clearfix">

							<div class="fileerrorTip" style="height: 0px"></div>

							<p>&nbsp&nbsp上传图片:</p>
							<div class="col-md-3">
								<img class="nav-user-photo" id="photo"
									src="<%= this.getServletContext().getContextPath() %>${use.headimgurl}"
									style="max-width: 80px;">
							</div>
							<div class="a-upload" style="top: 10px">
								<input type="file" id="imgOne" name="useImg"
									onchange="preImg()" style="width: auto;">点击上传图片
							</div>
							<span class="showFileName" style="margin-left:15px;top: 0px"></span>

							<!-- 	<p class="showFileName" style="margin-left: 15px;">未上传文件</p> -->

						</div>

						<div style="padding: 10px" class="form-group clearfix">
							性别: <label class="radio-inline" style="left: 25px;padding: 5px">
								<input type="radio" name="sex" value="女" style="width: auto;" checked> 女 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" style="width: auto;" value="男" 
								> 男
							</label>

						</div>
						<div style="padding: 10px" class="form-group">
							签名:
							<textarea class="form-control" name="explains"
								class="form-control" rows="3" placeholder="签名档（100个汉字以内）">${use.explains}</textarea>
								
						</div>
						<button type="submit" style="padding: 10px"
							class="form-group btn btn-primary pull-right">
							<small>&nbsp修改&nbsp</small>
						</button>
					
					</form>
				</div>
				
				<!-- 修改密码 -->
				<div class="changePassword" style="width: 500px">
					<form action="<%= this.getServletContext().getContextPath() %>/changeUse" method="post">
						<div style="padding: 10px" class="form-group">
							原密码:<input class="form-control" type="text" name="oldPassword">
						</div>
						<div style="padding: 10px" class="form-group">
							新密码:<input class="form-control" type="text" name="password">
						</div>
						<div style="padding: 10px" class="form-group">
							确认密码:<input class="form-control" type="text">
						</div>
						<button type="submit" style="padding: 10px"
							class="form-group btn btn-primary pull-right">
							<small>&nbsp修改&nbsp</small>
						</button>
					</form>
				</div>

			</div>
</body>
</html>
