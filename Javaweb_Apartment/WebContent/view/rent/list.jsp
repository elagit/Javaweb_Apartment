<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房租信息管理</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>房租信息管理</h3>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="<c:url value='/view/rent/add.jsp'/>">添加房租信息</a>
		</div>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>房屋序号</th>
			<th>租户序号</th>
			<th>租金</th>
			<th>交租时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${rents }" var="rent">
		<tr>
			<td>${rent.rid }</td>
			<td>${rent.rhid }</td>
			<td>${rent.rlid }</td>
			<td>${rent.rprice }</td>
			<td>${rent.rpayTime }</td>
			<td>
				<a class="fa fa-info" title="详情" href="<c:url value='/rent/detail?rid=${rent.rid }'/>"></a>
				&nbsp;&nbsp;
				<a class="fa fa-pencil" title="编辑" href="<c:url value='/rent/edit?rid=${rent.rid }'/>"></a>
				&nbsp;&nbsp;
				<c:choose>
					<c:when test="${roid==2 }">
						<a class="fa fa-remove" title="删除" href="#"> </a>
					</c:when>
					<c:otherwise >
						<a class="fa fa-remove" title="删除" href="<c:url value='/deleate?id=${rent.rid }&caseNo=3'/>" onclick="confirmDelete(1)"></a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	<div class="pager-info">
		<div>共有 ${page.total }条记录，第${page.pageNo }/${page.pageCount } 页 </div>
		<div>
			<ul class="pagination">
				<li class="paginate_button previous disabled }">
				<c:choose>
					<c:when test="${page.pageNo == 1 }">
						<a href="#">上一页</a>
					</c:when>
					<c:otherwise>
						<a href="<c:url value='/rent/list?pageNo=${page.pageNo-1 }'/>">上一页</a>
					</c:otherwise>
				</c:choose>
				</li>
				<li class="paginate_button active"><a href="#">${page.pageNo }</a></li>
				<li class="paginate_button next disabled">
				<c:choose>
					<c:when test="${page.pageNo == page.pageCount }">
						<a href="#">下一页</a>
					</c:when>
					<c:otherwise>
						<a href="<c:url value='/rent/list?pageNo=${page.pageNo+1 }'/>">下一页</a>
					</c:otherwise>
				</c:choose>
				</li>
			</ul>
		</div>
	</div>
</div>
<script src="<c:url value='/lib/jquery/jquery.js'/>"></script>
<script>
function confirmDelete(id){
	if (confirm("确定要删除码？")) {
		alert('发送删除请求，刷新页面（不要异步）');
	}
	return false;
}
</script>
</body>
</html>