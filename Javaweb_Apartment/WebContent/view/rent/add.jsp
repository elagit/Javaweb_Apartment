<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房租信息添加</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>添加房租信息</h3>
	<form action="<c:url value='/rent/add'/>" method="post">
	<table class="form-table">
			<tr>
				<td>房屋序号</td>
				<td colspan="3" class="control">
					<input type="text" name="rhid" >
				</td>
			</tr>
			<tr>
				<td>租户序号</td>
				<td colspan="3" class="control">
					<input type="text" name="rlid" >
				</td>
			</tr>
			<tr>
				<td>租金</td>
				<td colspan="3" class="control">
					<input type="text" name="rprice"  >
				</td>
			</tr>
			<tr>
				<td>交租时间</td>
				<td colspan="3" class="control">
					<input type="date" name="rpayTime"  >
				</td>
			</tr>
	</table>
	<div class="buttons">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>