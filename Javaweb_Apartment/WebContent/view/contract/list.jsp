<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓系统 - 租赁合同信息管理</title>
	<link rel="stylesheet" href="<c:url value='/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/lib/font-awesome/css/font-awesome.css'/>">
</head>
<body>
<div class="box">
	<h3>租赁合同信息管理</h3>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="<c:url value='/view/contract/add.jsp'/>">添加租赁合同</a>
		</div>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>合同号</th>
			<th>房屋信息</th>
			<th>租户信息</th>
			<th>合同日期</th>
			<th>租赁开始时间</th>
			<th>租赁结束时间</th>
			<th>房租总额</th>
			<th>付款方式</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${contracts }" var="contract">
		<tr>
			<td>${contract.cid }</td>
			<td>${contract.cnum }</td>
			<td>${contract.chid }</td>
			<td>${contract.clid }</td>
			<td>${contract.ctime }</td>
			<td>${contract.cstartTime }</td>
			<td>${contract.cendTime }</td>
			<td>${contract.ctotalMoney }</td>
			<td>${contract.cpayType == 1?"月付":contract.cpayType == 2?"半年付":"年付" }</td>
			<td>
				<a class="fa fa-info" title="详情" href="<c:url value='/contract/detail?cid=${contract.cid }' />"></a>
				&nbsp;&nbsp;
				<a class="fa fa-pencil" title="编辑" href="<c:url value='/contract/edit?cid=${contract.cid }' />"></a>
				&nbsp;&nbsp;
				<c:choose>
					<c:when test="${roid==2 }">
						<a class="fa fa-remove" title="删除" href="#"> </a>
					</c:when>
					<c:otherwise >
						<a class="fa fa-remove" title="删除" href="<c:url value='/deleate?id=${contract.chid }&caseNo=4'/>" onclick="confirmDelete(1)"></a>
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
						<a href="<c:url value='/contract/list?pageNo=${page.pageNo-1 }'/>">上一页</a>
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
						<a href="<c:url value='/contract/list?pageNo=${page.pageNo+1 }'/>">下一页</a>
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