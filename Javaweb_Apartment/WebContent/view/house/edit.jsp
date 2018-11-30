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
	<h3>修改房屋信息</h3>
	<form action="<c:url value='/house/edit'/>" method="post">
		<table class="form-table">
			<tr>
				<td>详细地址</td>
				<td colspan="3" class="control">
					<input type="text" name="haddress" placeholder="填写地区" value="${house.haddress }">
				</td>
			</tr>
			<tr>
				<td>所属楼层</td>
				<td colspan="3" class="control">
					<input type="text" name="hfloor" placeholder="楼层" value="${house.hfloor }">
				</td>
			</tr>
			<tr>
				<td>房间号</td>
				<td colspan="3" class="control">
					<input type="text" name="hroomNum" placeholder="房间号" value="${house.hroomNum }">
				</td>
			</tr>
			<tr>
				<td>面积（平米）</td>
				<td colspan="3" class="control">
					<input type="text" name="harea" placeholder="面积" value="${house.harea }">
				</td>
			</tr>
			<tr>
				<td>朝向</td>
				<td colspan="3" class="control">
					<input type="text" name="hdir" placeholder="朝向" value="${house.hdir }">
				</td>
			</tr>
			<tr>
				<td>精/简/毛</td>
				<td colspan="3" class="control">
					<select name="hdeco">
						<option value="1" ${house.hdeco==1 ?'selected':'' }>精装</option>
						<option value="2" ${house.hdeco==2 ?'selected':'' }>简装</option>
						<option value="3" ${house.hdeco==3 ?'selected':'' }>毛坯</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>是否双气</td>
				<td colspan="3" class="control">
					<input type="radio" name="hair" value="1" ${house.hair == 1 ?'checked':'' }>是
					<input type="radio" name="hair" value="2" ${house.hair == 2 ?'checked':'' }>否
				</td>
			</tr>
			<tr>
				<td>出租价格（元/月）</td>
				<td colspan="3" class="control">
					<input type="text" name="hprice" placeholder="出租价格" value="${house.hprice }">
				</td>
			</tr>
			<tr>
				<td>出租状态</td>
				<td colspan="3" class="control">
					<select name="hrentStatus">
						<option value="1" ${house.hrentStatus==1 ?'selected':'' }>已出租</option>
						<option value="1" ${house.hrentStatus==2 ?'selected':'' }>待出租</option>
						<option value="1" ${house.hrentStatus==3 ?'selected':'' }>未出租</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>房屋图片</td>
				<td colspan="3" class="control">
					<p><img src="../../../image/image.png" width="300px" height="200px"></p>
					<input type="file" name="">
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