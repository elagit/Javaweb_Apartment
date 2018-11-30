<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租户信息更新</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>修改租户信息</h3>
	<form action="<c:url value='/lessee/edit'/>" method="post">
		<table class="form-table">
			<input type="hidden" name="lid"  value="${lessee.lid }"/>
			<tr>
				<td>名字</td>
				<td colspan="3" class="control">
					<input type="text" name="lname"  value="${lessee.lname }">
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td colspan="3" class="control">
					<input type="text" name="ltel" placeholder="楼层" value="${lessee.ltel }">
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td colspan="3" class="control">
					<input type="radio" name="lsex" value="1" ${lessee.lsex == 1?'checked':'' } >男
					<input type="radio" name="lsex" value="2" ${lessee.lsex == 2?'checked':'' } >女
				</td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td colspan="3" class="control">
					<input type="text" name="lnp" value="${lessee.lnp }" >
				</td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td colspan="3" class="control">
					<input type="text" name="lidCard" value="${lessee.lidCard }" >
				</td>
			</tr>
			<tr>
				<td>入住时间</td>
				<td colspan="3" class="control">
					<input type="date" name="laddTime" value="${lessee.lidCard }" >
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