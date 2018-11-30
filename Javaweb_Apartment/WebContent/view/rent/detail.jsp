<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租金信息详情查看</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>租金信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">房屋序号</td>
				<td colspan="3" class="detail">
					${rent.rhid }
				</td>
			</tr>
			<tr>
				<td class="label">租户序号</td>
				<td colspan="3" class="detail">
					${rent.rlid }
				</td>
			</tr>
			<tr>
				<td class="label">租金</td>
				<td colspan="3" class="detail">
					${rent.rprice }
				</td>
			</tr>
			<tr>
				<td class="label">交租时间</td>
				<td colspan="3" class="detail">
					${rent.rpayTime }
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