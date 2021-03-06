<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租户信息详情查看</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>租户信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">名字</td>
				<td class="detail">
					${lessee.lname }
				</td>
			</tr>
			<tr>
				<td class="label">电话</td>
				<td colspan="3" class="detail">
					${lessee.ltel }
				</td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td colspan="3" class="detail">
					${lessee.lsex == 1?"男":"女" }
				</td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td colspan="3" class="detail">
					${lessee.lnp }
				</td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td colspan="3" class="detail">
					${lessee.lidCard }
				</td>
			</tr>
			<tr>
				<td class="label">添加时间</td>
				<td colspan="3" class="detail">
					${lessee.laddTime }
				</td>
			</tr>
		</table>
		<div class="buttons">
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		</div>
	</form>
</div>
</body>
</html>