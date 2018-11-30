<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租赁合同信息添加</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>添加租赁合同信息</h3>
	<form action="<c:url value='/contract/add'/>" method="post">
	<table class="form-table">
		<tr>
				<td>合同号</td>
				<td colspan="3" class="control">
					<input type="text" name="cnum"  >
				</td>
			</tr>
			<tr>
				<td>房屋信息</td>
				<td colspan="3" class="control">
					<input type="text" name="chid"  >
				</td>
			</tr>
			<tr>
				<td>租户信息</td>
				<td colspan="3" class="control">
					<input type="text" name="clid"  >
				</td>
			</tr>
			<tr>
				<td>合同日期</td>
				<td colspan="3" class="control">
					<input type="date" name="ctime"  >
				</td>
			</tr>
			<tr>
				<td>合同开始时间</td>
				<td colspan="3" class="control">
					<input type="date" name="cstartTime"  >
				</td>
			</tr>
			<tr>
				<td>合同结束时间</td>
				<td colspan="3" class="control">
					<input type="date" name="cendTime"  >
				</td>
			</tr>
			<tr>
				<td>房租总额</td>
				<td colspan="3" class="control">
					<input type="text" name="ctotalMoney"  >
				</td>
			</tr>
			<tr>
				<td>出租状态</td>
				<td colspan="3" class="control">
					<select name="cpayType">
						<option value="1" selected>月付</option>
						<option value="2" selected>半年付</option>
						<option value="3" selected>年付</option>
					</select>
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