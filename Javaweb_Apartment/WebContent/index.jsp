<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓信息管理系统 - 登录页面</title>
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="login">
	<img src="" alt="">
	<p>公寓信息管理系统</p>
	<form action="<c:url value='/login'/>" method="post">
	<div>
		<input type="text" id="username" name="username" value="" placeholder="请输入用户名" required="required">
	</div>
	<div>
		<input type="password" id="password" name="password" value="" placeholder="请输入密码" required="required">
	</div>
	<div>
		<p class="error-message">${error }</p>
		<input type="submit" value="登录">
	</div>
	</form>
</div>
<script src="js/index.js"></script>
</body>
</html>