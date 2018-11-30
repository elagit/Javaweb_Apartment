<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房屋信息更新</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>修改合同信息</h3>
	<form action="<c:url value='/contract/edit'/>" method="post">
		<table class="form-table">
			<tr>
				<td>合同号</td>
				<td colspan="3" class="control">
					<input type="text" name="cnum" value="${contract.cnum }" >
				</td>
			</tr>
			<tr>
				<td>房屋信息</td>
				<td colspan="3" class="control">
					<input type="text" name="chid" value="${contract.chid }" >
				</td>
			</tr>
			<tr>
				<td>租户信息</td>
				<td colspan="3" class="control">
					<input type="text" name="clid" value="${contract.clid }" >
				</td>
			</tr>
			<tr>
				<td>房租总额</td>
				<td colspan="3" class="control">
					<input type="text" name="ctotalMoney" value="${contract.ctotalMoney }" >
				</td>
			</tr>
			<tr>
				<td>出租状态</td>
				<td colspan="3" class="control">
					<select name="cpayType">
						<option value="1" ${contract.cpayType == 1?'selected':'' }>月付</option>
						<option value="2" ${contract.cpayType == 2?'selected':'' }>半年付</option>
						<option value="3" ${contract.cpayType == 3?'selected':'' }>年付</option>
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