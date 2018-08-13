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
		<h1><b>COMMENT LIST</b></h1>
	</div>
	<ol class="breadcrumb">
		<li><a href="<c:url value='/a/home' />">HOME</a></li>
		<li>COMMENT</li>
		<li class="active">COMMENT LIST</li>
	</ol>
	<div>

<div class="text-right">
	<form action="<c:url value='${ baseUrl }' />" method="get" class="form-inline">
		<div class="form-group">
			<input type="hidden" name="viewRecord" value="<c:out value='${ pageParam.viewRecord }' />">
			<select name="searchOption" id="searchOption" class="form-control">
				<option value="0">SELECT</option>
				<option value="1">ALL</option>
				<option value="2">COMMENT</option>
				<option value="3">BOARD SUBJECT</option>
				<option value="4">USER NAME</option>
			</select>
			<input type="text" name="searchValue" id="searchValue" placeholder="SEARCH" class="form-control">
			<button type="submit" class="btn btn-default"><font color="royalblue">GO</font></button>
			<a href="<c:url value='${ baseUrl }' />" class="btn btn-default">ALL</a>
		</div>
	</form>
</div>

<div>&nbsp;</div>
<div class="panel panel-default">
	<table class="table table-condensed table-bordered table-hover">
		<thead>
			<tr class="active">
				<th class="text-center">ID</th>
				<th class="text-center">COMMENT</th>
				<th class="text-center">VITAL</th>
				<th class="text-center">ADD DATE</th>
				<th class="text-center">MODIFY DATE</th>
				<th class="text-center">BOARD</th>
				<th class="text-center">USER</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${ list }">
				<tr>
					<td class="text-center active"><c:out value='${ comment.commentId }' /></td>
					<td class="text-center"><a href="<c:url value='${ baseUrl }/${ comment.commentId }?${ parameter }' />"><c:out value='${ comment.comment }' /></a></td>
					<td class="text-center">
						<c:if test="${ comment.vital == 'Y' }"><c:out value='${ comment.vital }' /></c:if>
						<c:if test="${ comment.vital == 'N' }"><font color="tomato"><c:out value='${ comment.vital }' /></font></c:if>
					</td>
					<td class="text-center"><fmt:formatDate value='${ comment.addTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><fmt:formatDate value='${ comment.modifyTime }' pattern='yyyy-MM-dd' /></td>
					<td class="text-center"><c:out value='${ comment.board.boardId }' /></td>
					<td class="text-center"><c:out value='${ comment.user.name }' /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="row">
	<div class="col-md-6">
		TOTAL <font color="tomato"><fmt:formatNumber value='${ totalRecord }' groupingUsed='true' /></font> RECORD
	</div>
	<div class="col-md-6 form-inline text-right">
		<select name="viewRecord" id="viewRecord" class="form-control">
			<option value="10">VIEW 10 RECORD</option>
			<option value="20">VIEW 20 RECORD</option>
			<option value="30">VIEW 30 RECORD</option>
			<option value="50">VIEW 50 RECORD</option>
		</select>
	</div>
</div>

<div class="text-center">
	<c:out value='${ pagination }' escapeXml='false' />
</div>

	</div>
</div>

<%@ include file="/WEB-INF/view/jsp/admin/fragment/footer.html" %>
<%@ include file="/WEB-INF/view/jsp/admin/fragment/js.jsp" %>
<script type="text/javascript">
	$("#searchOption").val("${ searchParam.searchOption }");
	$("#searchValue").val("${ searchParam.searchValue }");
	$("#viewRecord").val("${ pageParam.viewRecord }");
	
	$("#viewRecord").on("change", function() {
		location.href = "<c:url value='${ baseUrl }?viewRecord=' />"+ $("#viewRecord").val() +"&${ searchParam.getParam() }";
	});
</script>
</body>
</html>
