<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/head.jsp" />
<body>
<jsp:include page="/WEB-INF/view/jsp/admin/fragment/navbar.jsp" />

<div class="container">
	<div class="page-header">
		<h1><b>CATEGORY LIST</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>CATEGORY</li>
		<li class="active">CATEGORY LIST</li>
	</ol>
	<div>

<div>&nbsp;</div>
<div class="panel panel-default">
	<table class="table table-hover">
		<thead>
			<tr class="active">
				<th class="text-center">ID</th>
				<th class="text-center">NAME</th>
				<th class="text-center"></th>
				<th class="text-center">NOTE</th>
				<th class="text-center">ADD DATE</th>
				<th class="text-center">MODIFY DATE</th>
				<th class="text-center">USER</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${ list }">
				<tr>
					<td class="text-center"><c:out value='${ category.categoryId }' /></td>
					<td>
						<c:forEach begin="2" end="${ category.level }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
						<a href="<c:url value='${ baseUrl }/${ category.categoryId }' />"><c:out value='${ category.name }' /></a>
					</td>
					<td class="text-center"><a href="<c:url value='${ baseUrl }/fm/${ category.categoryId }' />">[ + ]</a></td>
					<td class="text-center">***</td>
					<td class="text-center"><fmt:formatDate value='${ category.addTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><fmt:formatDate value='${ category.modifyTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><c:out value='${ category.user.name }' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="row">
	<div class="col-md-6">
		TOTAL <font color="tomato"><fmt:formatNumber value='${ totalRecord }' groupingUsed='true' /></font> RECORD
	</div>
</div>

<div>&nbsp;</div>
<div class="text-center">
	<a href="<c:url value='${ baseUrl }/fm/user/${ userId }' />" class="btn btn-default btn-lg">CATEGORY ADD</a><br><br>
</div>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
</body>
</html>
